package com.babalola.springpetclinic.services.map;
import com.babalola.springpetclinic.models.Owner;
import com.babalola.springpetclinic.models.Pet;
import com.babalola.springpetclinic.services.OwnerService;
import com.babalola.springpetclinic.services.PetService;
import com.babalola.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.Set;


@Service
@Profile({"default", "mapService"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;


    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                    } else throw new RuntimeException("Pet type is required");

                    if (pet.getId() == null) {
                        Pet newPet = petService.save(pet);
                        pet.setId(newPet.getId());
                    }

                });
            }
        }

        return super.save( object);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
