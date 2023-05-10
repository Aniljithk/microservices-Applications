# Product Service
Install MongoDB
-- introduce OPEN API SPEC

—for installing community server of mongo
Brew install mongodb-community@6.0

—to install compass (GUI) download from mongo db website

—to start mongo service

mongod --dbpath ~/documents/mongodb/data/db


To stop
Login to mongoose using mongosh command

use admin

db.shutdownServer()

Check for more mongosh commands

docker run -d -p 9411:9411 openzipkin/zipkin
Connection string
mongodb://localhost:27017

For running integration test case run the docker desktop and run the integration


A brief description of what this project does and who it's for



for kafka
https://developer.confluent.io/quickstart/kafka-docker/
## API Reference
to run keycloak in local

./kc.sh start-dev --http-port=8181

Set up the Keycloak realm and clients.
After we can access api with security..

#### Get all items

```http
  GET /api/items
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get item

```http
  GET /api/items/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### add(num1, num2)

Takes two numbers and returns the sum.

## 🛠 Skills

Javascript, HTML, CSS...

## 🔗 Links

[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://katherineoelsner.com/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)

## Acknowledgements

- [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

## Appendix

Any additional information goes here

## Authors

- [@AniljithK](https://www.github.com/Aniljithk)

## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)

## Deployment

To deploy this project run

```bash
  mvn spring-boot:run
```

## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`API_KEY`

`ANOTHER_API_KEY`
## Installation

Install my-project with npm

```bash
  cd $ProjectDirectory
  mvn clean install
```
## Run Locally

Clone the project

```bash
  git clone git@github.com:Aniljithk/microservices-Applications.git
```

Go to the project directory

```bash
  cd $ProjectName
```

Install dependencies

```bash
  mvn clean isntall
```

Start the server

```bash
  mvn springboot::run
```
## Running Tests

To run tests, run the following command

```bash
  mvn clean test
```