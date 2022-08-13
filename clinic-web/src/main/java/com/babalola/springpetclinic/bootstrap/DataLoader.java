package com.babalola.springpetclinic.bootstrap;

import com.babalola.springpetclinic.models.*;
import com.babalola.springpetclinic.services.OwnerService;
import com.babalola.springpetclinic.services.PetTypeService;
import com.babalola.springpetclinic.services.SpecialtyService;
import com.babalola.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

        loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);
        System.out.println("PetType dog created");

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);
        System.out.println("PetType cat created");

        Specialty surgery = new Specialty();
        surgery.setDescription("Performs surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Takes care of dental/teeth health");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Specialty radiology = new Specialty();
        radiology.setDescription("Performs screening of cells");
        Specialty savedRadioogy = specialtyService.save(radiology);

        System.out.println("Speciality types created and loading");

        Owner Opeyemi = new Owner();
        Opeyemi.setFirstName("Daniel");
        Opeyemi.setLastName("Babalola");
        ownerService.save(Opeyemi);


        Owner Ajoke = new Owner();
        Ajoke.setLastName("Ibrahim");
        Ajoke.setFirstName("Baraqhat");
        ownerService.save(Ajoke);


        Owner Florence = new Owner();
        Florence.setFirstName("Ajoke");
        Florence.setLastName("Olajide");
        ownerService.save(Florence);

        System.out.println("Three owners created and loading");


        Pet lucky = new Pet();
        lucky.setPetType(savedDogType);
        lucky.setBirthDate(LocalDate.now());
        lucky.setOwner(Opeyemi);
        lucky.setName("Lucky");
        Opeyemi.getPets().add(lucky);


        Pet emerald = new Pet();
        emerald.setName("Emerald");
        emerald.setOwner(Ajoke);
        emerald.setPetType(savedCatType);
        emerald.setBirthDate(LocalDate.now());
        Ajoke.getPets().add(emerald);
        System.out.println("Owners and their pets loading");


        Vet Abiola = new Vet();
        Abiola.setFirstName("Bimbo");
        Abiola.setLastName("Abiola");
        vetService.save(Abiola);
        Abiola.getSpecialities().add(savedDentistry);

        Vet Aminat = new Vet();
        Aminat.setFirstName("Olaitan");
        Aminat.setLastName("Aminat");
        vetService.save(Aminat);
        Aminat.getSpecialities().add(savedRadioogy);

        Vet Toyin = new Vet();
        Toyin.setFirstName("Elizabeth");
        Toyin.setLastName("Babalola");
        Toyin.getSpecialities().add(savedDentistry);
        vetService.save(Toyin);
        System.out.println("Vets and their specialties loading");
    }


}
