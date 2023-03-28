package io.hackfest.db;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "inventory_movements")
public class InventoryMovementEntity extends PanacheEntityBase {
    @Id
    public Long id;

    public Long shopId;

    public Long productId;

    public Long receiptId;

    public Long returnId;

    @Enumerated(EnumType.STRING)
    public Size size;

    public String color;

    public Integer quantity;
}
