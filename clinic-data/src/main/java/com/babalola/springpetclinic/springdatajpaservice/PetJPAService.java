package com.babalola.springpetclinic.springdatajpaservice;
import com.babalola.springpetclinic.models.Pet;
import com.babalola.springpetclinic.repositories.PetRepository;
import com.babalola.springpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;


@Service
@Profile(("springJpaService"))
public class PetJPAService implements PetService {
    private final PetRepository petRepository;

    public PetJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        Pet newPet = petRepository.save(pet);
        return newPet;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> allPets = new HashSet<>();
        petRepository.findAll().forEach(allPets::add);
        return allPets;
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);

    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);

    }
}
