package com.babalola.springpetclinic.services;

import com.babalola.springpetclinic.models.PetType;
import org.springframework.stereotype.Component;


@Component
public interface PetTypeService extends CrudService<PetType, Long>{
}

