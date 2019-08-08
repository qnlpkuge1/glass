package com.goosun.glass.domain;

import java.io.Serializable;
import java.util.Objects;

public class Equipment implements Serializable {

    private String product;
    private String udid;
    private String version;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Equipment equipment = (Equipment) o;
        return udid.equals(equipment.udid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(udid);
    }
}
