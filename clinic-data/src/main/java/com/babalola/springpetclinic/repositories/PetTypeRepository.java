package com.babalola.springpetclinic.repositories;

import com.babalola.springpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
