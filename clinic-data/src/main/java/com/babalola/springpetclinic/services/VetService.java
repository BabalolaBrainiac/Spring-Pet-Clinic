package com.babalola.springpetclinic.services;

import com.babalola.springpetclinic.models.Vet;
import org.springframework.stereotype.Component;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);

}
