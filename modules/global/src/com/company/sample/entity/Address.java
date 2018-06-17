package com.company.sample.entity;

import javax.persistence.Embeddable;
import com.haulmont.chile.core.annotations.MetaClass;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

@MetaClass(name = "sample$Address")
@Embeddable
public class Address extends EmbeddableEntity {
    private static final long serialVersionUID = -2523861087795979065L;

    @Column(name = "CITY")
    protected String city;

    @Column(name = "STREET")
    protected String street;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }


}