package com.babalola.springpetclinic.services.map;

import com.babalola.springpetclinic.models.Specialty;
import com.babalola.springpetclinic.models.Vet;
import com.babalola.springpetclinic.services.SpecialtyService;
import com.babalola.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile({"default", "mapService"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty saved = specialtyService.save(specialty);
                    saved.setId(specialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
