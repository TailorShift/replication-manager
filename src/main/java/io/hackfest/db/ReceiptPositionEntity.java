package io.hackfest.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

/**
 * This entity is not serialized by Debezium but manually. Thus we do not need to map fields to snake case.
 */
@Entity
@Table(name = "receipt_positions")
public class ReceiptPositionEntity extends PanacheEntityBase {

    @Id
    public Long id;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    @JsonIgnore
    public ReceiptEntity receipt;

    public Long position;

    public Long productId;

    @Enumerated(EnumType.STRING)
    public Size size;

    public String color;

    public Integer quantity;

    public Double price;

    public Integer discount;

    public String discountReason;

    public Double taxRate;
}
