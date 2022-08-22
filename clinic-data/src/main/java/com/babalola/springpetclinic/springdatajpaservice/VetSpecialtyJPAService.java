package com.babalola.springpetclinic.springdatajpaservice;

import com.babalola.springpetclinic.models.Pet;
import com.babalola.springpetclinic.models.Specialty;
import com.babalola.springpetclinic.repositories.SpecialtyRepository;
import com.babalola.springpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springJpaService")
public class VetSpecialtyJPAService implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public VetSpecialtyJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        Specialty newSpecialty = specialtyRepository.save(specialty);
        return newSpecialty;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> allSpecialties = new HashSet<>();
        allSpecialties.forEach(allSpecialties::add);
        return allSpecialties;
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);

    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);

    }
}
