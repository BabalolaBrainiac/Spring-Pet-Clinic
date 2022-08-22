package com.babalola.springpetclinic.repositories;

import com.babalola.springpetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
   Owner findByLastName(String lastName);
}
