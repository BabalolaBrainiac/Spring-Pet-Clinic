package com.babalola.springpetclinic.services;

import com.babalola.springpetclinic.models.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet findByLastName(String lastName);
    Set<Vet>findAll();
    Vet save(Vet vet);
}
