package com.babalola.springpetclinic.springdatajpaservice;
import com.babalola.springpetclinic.models.PetType;
import com.babalola.springpetclinic.repositories.PetTypeRepository;
import com.babalola.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springJpaService")
public class PetTypeJPAService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {

        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        PetType newPettype = petTypeRepository.save(petType);
        return newPettype;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> allPetTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(allPetTypes::add);
        return allPetTypes;
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);

    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);

    }
}
