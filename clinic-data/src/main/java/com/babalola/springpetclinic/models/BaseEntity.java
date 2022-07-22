package com.babalola.springpetclinic.models;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
