package com.babalola.springpetclinic.services;

import com.babalola.springpetclinic.models.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
