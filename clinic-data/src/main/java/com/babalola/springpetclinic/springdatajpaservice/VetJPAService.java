package com.babalola.springpetclinic.springdatajpaservice;
import com.babalola.springpetclinic.models.Vet;
import com.babalola.springpetclinic.repositories.VetRepository;
import com.babalola.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springJpaService")
public class VetJPAService implements VetService {

    private final  VetRepository vetRepository;

    public VetJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        vetRepository.save(vet);
        return vet;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> allVets= new HashSet<>();
        vetRepository.findAll().forEach(allVets::add);
        return allVets;
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);

    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public Vet findByLastName(String lastName) {
        Vet vet = vetRepository.findByLastName(lastName);
        return vet;
    }
}
