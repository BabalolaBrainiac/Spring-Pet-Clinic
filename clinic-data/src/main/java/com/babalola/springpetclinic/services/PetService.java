package com.babalola.springpetclinic.services;

import com.babalola.springpetclinic.models.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Set<Pet>findAll();
    Pet save(Pet pet);
}
