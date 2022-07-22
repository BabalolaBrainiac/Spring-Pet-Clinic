package com.babalola.springpetclinic.services;

import com.babalola.springpetclinic.models.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);

}
