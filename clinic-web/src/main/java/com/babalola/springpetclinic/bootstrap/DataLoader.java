package com.babalola.springpetclinic.bootstrap;

import com.babalola.springpetclinic.models.Owner;
import com.babalola.springpetclinic.models.Pet;
import com.babalola.springpetclinic.models.PetType;
import com.babalola.springpetclinic.services.OwnerService;
import com.babalola.springpetclinic.services.PetTypeService;
import com.babalola.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;

public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);
        System.out.println(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);
        System.out.println(cat);

        Owner Opeyemi = new Owner();
        Opeyemi.setFirstName("Daniel");
        Opeyemi.setLastName("Babalola");

        Pet lucky = new Pet();
        lucky.setPetType(savedDogType);
        lucky.setBirthDate(LocalDate.now());
        lucky.setOwner(Opeyemi);
        lucky.setName("Lucky");
        Opeyemi.getPets().add(lucky);

        ownerService.save(Opeyemi);
        System.out.println(Opeyemi.getLastName());

        Owner Ajoke = new Owner();
        Ajoke.setLastName("Ibrahim");
        Ajoke.setFirstName("Baraqhat");

        Pet emerald = new Pet();
        emerald.setName("Emerald");
        emerald.setOwner(Ajoke);
        emerald.setPetType(savedCatType);
        emerald.setBirthDate(LocalDate.now());
        Ajoke.getPets().add(emerald);

        ownerService.save(Ajoke);
        System.out.println(Ajoke.getFirstName());


        Owner Florence = new Owner();
        Florence.setFirstName("Ajoke");
        Florence.setLastName("Olajide");

        ownerService.save(Florence);
        System.out.println(Florence.getFirstName());

    }


}
