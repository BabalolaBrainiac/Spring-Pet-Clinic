package com.babalola.springpetclinic.repositories;

import com.babalola.springpetclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName(String lastName);
}
