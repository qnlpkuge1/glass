package com.goosun.glass.domain.res;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dict")
public class UDIDDict {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    @XmlElement
    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    @XmlElement(name="string")
    public void setValue(String value) {
        this.value = value;
    }
}
