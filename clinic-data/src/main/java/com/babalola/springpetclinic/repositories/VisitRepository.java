package com.babalola.springpetclinic.repositories;
import com.babalola.springpetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
