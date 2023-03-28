package io.hackfest.db;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    //    @JsonProperty("shop_id")
    public Long shopId;

    //    @JsonProperty("pos_device_id")
    public Long posDeviceId;

    //    @JsonProperty("customer_id")
    public Long customerId;

    //    @JsonProperty("created_at")
    public LocalDateTime createdAt;

    //    @JsonProperty("discount_total")
    public Double discountTotal;

    //    @JsonProperty("tax_total")
    public Double taxTotal;

    //    @JsonProperty("amount_total")
    public Double amountTotal;

    //    @JsonProperty("employee_id")
    public Long employeeId;

    //    @JsonProperty("delivery_shop_id")
    public Long deliveryShopId;

    @OneToMany(mappedBy = "receipt")
    public List<ReceiptPositionEntity> positions;
}
