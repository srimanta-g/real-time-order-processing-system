# Real-Time Order Processing

An event-driven microservices system that handles the full order lifecycle (order creation and fulfillment) asynchronously using RabbitMQ.

## Overview

Instead of services calling each other directly, each step in an order's life is published as an event. Services react to those events independently, so a slow or failing service doesn't block the rest of the system.

```
Client -> Order Service -> [RabbitMQ] -> Product Service -> [RabbitMQ] -> Order Service
```

## Features

- Asynchronous order and fulfillment pipelines over RabbitMQ
- Idempotent consumers, so duplicate events don't cause duplicate processing
- Retry mechanism with dead-letter queues (DLQ) for events that keep failing
- Topic partitioning and consumer groups for high-throughput processing
- Service discovery with Eureka
- Centralized configuration with Spring Cloud Config

## Tech Stack

- Java, Spring Boot, Spring Cloud
- RabbitMQ
- Eureka (service discovery), Spring Cloud Config
- <Database, e.g. MySQL>
- <Build tool, e.g. Maven>
- <Docker / Docker Compose>

## Services

| Service | Responsibility |
|---|---|---|
| config-server | Serves centralized configuration |
| discovery-server | Eureka service registry |
| order-service | Creates orders and publishes order events |
| product-service | 

## Event Flow

1. `order-service` accepts a request and publishes an `OrderCreated` event.
2. `product-service` consumes it, processes the order, and mark the order as completed or failed.
4. Events that fail after the configured retries are sent to a dead-letter topic.


## Reliability Notes

- **Idempotency:** consumers track processed event IDs so replays are safe.
- **Retries and DLQ:** failed events are retried a limited number of times, then moved to a dead-letter topic for inspection.
- **Scaling:** topics are partitioned, and each service runs as a consumer group, so you can add instances to increase throughput.

## Future Improvements

- < add monitoring with Prometheus/Grafana>
- < add distributed tracing>
- < add an API gateway>
