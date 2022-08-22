package com.babalola.springpetclinic.springdatajpaservice;
import com.babalola.springpetclinic.models.Owner;
import com.babalola.springpetclinic.repositories.OwnerRepository;
import com.babalola.springpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springJpaService")
public class OwnerJPAService implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerJPAService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long aLong) {

        return  ownerRepository.findById(aLong).orElse(null);

    }

    @Override
    public Owner save(Owner owner) {
        Owner newOwner = ownerRepository.save(owner);
        return newOwner;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> allOwners = new HashSet<>();
        ownerRepository.findAll().forEach(allOwners::add);
        return allOwners;
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);

    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);

    }

}
