package com.babalola.springpetclinic.repositories;

import com.babalola.springpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
