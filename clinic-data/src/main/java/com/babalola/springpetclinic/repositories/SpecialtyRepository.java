package com.babalola.springpetclinic.repositories;
import com.babalola.springpetclinic.models.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
