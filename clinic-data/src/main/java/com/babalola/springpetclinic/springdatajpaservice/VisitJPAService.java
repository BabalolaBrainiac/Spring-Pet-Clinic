package com.babalola.springpetclinic.springdatajpaservice;
import com.babalola.springpetclinic.models.Visit;
import com.babalola.springpetclinic.repositories.VisitRepository;
import com.babalola.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springJpaService")
public class VisitJPAService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }


    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);

    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> allVisits = new HashSet<>();
        visitRepository.findAll().forEach(allVisits::add);
        return allVisits;
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);

    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);

    }
}
