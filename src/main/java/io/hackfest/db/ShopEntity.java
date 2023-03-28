package io.hackfest.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class ShopEntity extends PanacheEntityBase {
    @Id
    public Long id;

    public String city;

    public String postcode;

    @JsonProperty("street_1")
    @Column(name = "street_1")
    public String street1;

    @JsonProperty("street_2")
    @Column(name = "street_2")
    public String street2;

    @JsonProperty("iot_certificate")
    public String iotCertificate;
}
