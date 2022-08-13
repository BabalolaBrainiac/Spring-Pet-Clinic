package com.babalola.springpetclinic.services.map;
import com.babalola.springpetclinic.models.Pet;
import com.babalola.springpetclinic.services.CrudService;
import com.babalola.springpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
