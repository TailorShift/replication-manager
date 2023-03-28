package io.hackfest.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pos_devices")
public class PosDeviceEntity extends PanacheEntityBase {
    @Id
    public Long id;

    @JsonProperty("shop_id")
    public Long shopId;

    public String serial;

    @JsonProperty("iot_certificate")
    public String iotCertificate;

}
