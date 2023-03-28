package io.hackfest.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity extends PanacheEntityBase {
    @Id
    public Long id;

    public String name;

    @JsonProperty("card_id")
    public Long cardId;

    @JsonProperty("street_1")
    @Column(name = "street_1")
    public String street1;

    @JsonProperty("street_2")
    @Column(name = "street_2")
    public String street2;

    public String postcode;

    public String city;

    public Integer discount;
}
