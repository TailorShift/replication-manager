package io.hackfest.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends PanacheEntityBase {
    @Id
    public Long id;

    @JsonProperty("primary_shop_id")
    public Long primaryShopId;

    public String name;

    @JsonProperty("card_id")
    public Long cardId;

}
