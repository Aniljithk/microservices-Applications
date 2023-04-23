package com.springbootapp.productservice.repository.impl;


import com.springbootapp.productservice.model.UuidIdentifiedEntity;
import com.springbootapp.productservice.repository.CustomMongoRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.List;
import java.util.UUID;


public class CustomMongoRepositoryImpl<T extends UuidIdentifiedEntity> extends SimpleMongoRepository<T, UUID> implements CustomMongoRepository<T> {

    public CustomMongoRepositoryImpl(MongoEntityInformation<T, UUID> metadata, MongoOperations mongoOperations) {

        super(metadata, mongoOperations);
    }

    @Override
    public <S extends T> S save(S entity) {
        generateId(entity);
        return super.save(entity);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::generateId);
        return super.saveAll(entities);
    }

    @Override
    public <S extends T> S insert(S entity) {
        generateId(entity);
        return super.insert(entity);
    }

    @Override
    public <S extends T> List<S> insert(Iterable<S> entities) {
        entities.forEach(this::generateId);
        return super.insert(entities);
    }

    protected <S extends T> void generateId(S entity) {

        if (entity != null && entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }

}
