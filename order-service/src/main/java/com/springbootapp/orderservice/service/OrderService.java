package com.springbootapp.orderservice.service;

import com.springbootapp.orderservice.dto.InventoryResponse;
import com.springbootapp.orderservice.dto.OrderLineItemsDto;
import com.springbootapp.orderservice.dto.OrderRequest;
import com.springbootapp.orderservice.event.OrderPlacedEvent;
import com.springbootapp.orderservice.model.Order;
import com.springbootapp.orderservice.model.OrderLineItems;
import com.springbootapp.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
    public String placeOrder(OrderRequest orderRequest){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                        .orderLineItemsList(orderRequest.getOrderLineItemsDtoList()
                                .stream()
                                .map(this::mapToDto)
                                .collect(Collectors.toList()))
                .build();
        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode).toList();

        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/inventory/api/v1",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        Boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if (Boolean.TRUE.equals(allProductsInStock)){
            orderRepository.save(order);
            kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(order.getOrderNumber()));
            return "Order Placed Successfully";
        }
        else
            throw new IllegalArgumentException("Product is not in stock.. Please try again later.");
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.builder()
                .id(orderLineItemsDto.getId())
                .price(orderLineItemsDto.getPrice())
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.getSkuCode())
                .build();
    }
}
