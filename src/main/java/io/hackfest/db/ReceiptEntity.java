package io.hackfest.db;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This entity is not serialized by Debezium but manually. Thus we do not need to map fields to snake case.
 */
@Entity
@Table(name = "receipts")
public class ReceiptEntity extends PanacheEntityBase {

    @Id
    public Long id;

    public Long shopId;

    public Long posDeviceId;

    public Long customerId;

    public LocalDateTime createdAt;

    public Double discountTotal;

    public Double taxTotal;

    public Double amountTotal;

    public Long employeeId;

    public Long deliveryShopId;

    @OneToMany(mappedBy = "receipt")
    public List<ReceiptPositionEntity> positions;
}
