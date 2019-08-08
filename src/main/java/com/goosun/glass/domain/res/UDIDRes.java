package com.goosun.glass.domain.res;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="plist")
public class UDIDRes {

    private List<UDIDDict> dict;

    public List<UDIDDict> getDict() {
        return dict;
    }

    @XmlElement(name="dict")
    public void setDict(List<UDIDDict> dict) {
        this.dict = dict;
    }
}
