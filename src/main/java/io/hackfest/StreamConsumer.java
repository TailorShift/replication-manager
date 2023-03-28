package io.hackfest;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hackfest.db.*;
import io.hackfest.debezium.DebeziumMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class StreamConsumer {
    static final Logger logger = LoggerFactory.getLogger(StreamConsumer.class);

    @Inject
    ObjectMapper objectMapper;


    @Incoming("shops")
    @Transactional
    public void processShopChanges(String event) {
        try {
            var o = objectMapper.readValue(event, new TypeReference<DebeziumMessage<ShopEntity>>() {
            });

            switch (o.payload().op()) {
                case "u" -> ShopEntity.getEntityManager().merge(o.payload().after());
                case "c" -> ShopEntity.persist(o.payload().after());
                case "d" -> ShopEntity.deleteById(o.payload().before().id);
                default -> logger.warn("Unknown operation");
            }
        } catch (Exception e) {
            logger.error("Processing debezium message failed", e);
        }
    }

    @Incoming("pos_devices")
    @Transactional
    public void processPosDeviceChanges(String event) {
        try {
            var o = objectMapper.readValue(event, new TypeReference<DebeziumMessage<PosDeviceEntity>>() {
            });

            switch (o.payload().op()) {
                case "u" -> PosDeviceEntity.getEntityManager().merge(o.payload().after());
                case "c" -> PosDeviceEntity.persist(o.payload().after());
                case "d" -> PosDeviceEntity.deleteById(o.payload().before().id);
                default -> logger.warn("Unknown operation");
            }
        } catch (Exception e) {
            logger.error("Processing debezium message failed", e);
        }
    }

    @Incoming("products")
    @Transactional
    public void processProductChanges(String event) {
        try {
            var o = objectMapper.readValue(event, new TypeReference<DebeziumMessage<ProductEntity>>() {
            });

            switch (o.payload().op()) {
                case "u" -> ProductEntity.getEntityManager().merge(o.payload().after());
                case "c" -> ProductEntity.persist(o.payload().after());
                case "d" -> ProductEntity.deleteById(o.payload().before().id);
                default -> logger.warn("Unknown operation");
            }
        } catch (Exception e) {
            logger.error("Processing debezium message failed", e);
        }
    }

    @Incoming("customers")
    @Transactional
    public void processCustomersChanges(String event) {
        try {
            var o = objectMapper.readValue(event, new TypeReference<DebeziumMessage<CustomerEntity>>() {
            });

            switch (o.payload().op()) {
                case "u" -> CustomerEntity.getEntityManager().merge(o.payload().after());
                case "c" -> CustomerEntity.persist(o.payload().after());
                case "d" -> CustomerEntity.deleteById(o.payload().before().id);
                default -> logger.warn("Unknown operation");
            }
        } catch (Exception e) {
            logger.error("Processing debezium message failed", e);
        }
    }

    @Incoming("employees")
    @Transactional
    public void processEmployeeChanges(String event) {
        try {
            var o = objectMapper.readValue(event, new TypeReference<DebeziumMessage<EmployeeEntity>>() {
            });

            switch (o.payload().op()) {
                case "u" -> EmployeeEntity.getEntityManager().merge(o.payload().after());
                case "c" -> EmployeeEntity.persist(o.payload().after());
                case "d" -> EmployeeEntity.deleteById(o.payload().before().id);
                default -> logger.warn("Unknown operation");
            }
        } catch (Exception e) {
            logger.error("Processing debezium message failed", e);
        }
    }

    @Incoming("receiptexports")
    @Transactional
    public void processReceiptExport(String event) {
        try {
            var o = objectMapper.readValue(event, new TypeReference<DebeziumMessage<ReceiptEvent>>() {
            });

            switch (o.payload().op()) {
                case "u" -> logger.error("Update not allowed on receipt export");
                case "c" -> {
                    String json = o.payload().after().payload();
                    ReceiptEntity receiptEntity = objectMapper.readValue(json, ReceiptEntity.class);

                    EmployeeEntity.persist(receiptEntity);

                    for (var position : receiptEntity.positions) {
                        var movement = new InventoryMovementEntity();
                        movement.id = position.id;
                        movement.shopId = receiptEntity.shopId;
                        movement.productId = position.productId;
                        movement.receiptId = receiptEntity.id;
                        movement.color = position.color;
                        movement.size = position.size;
                        movement.quantity = -position.quantity;

                        InventoryMovementEntity.persist(movement);
                    }

                }
                case "d" -> logger.warn("Deleted ignored on receipt export");
                default -> logger.warn("Unknown operation");
            }
        } catch (Exception e) {
            logger.error("Processing debezium message failed", e);
        }
    }
}
