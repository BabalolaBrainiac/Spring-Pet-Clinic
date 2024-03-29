package com.babalola.springpetclinic.services.map;
import com.babalola.springpetclinic.models.Visit;
import com.babalola.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile({"default", "mapService"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null
        ||visit.getPet().getOwner().getId() == null)
            throw new RuntimeException("Visit requires a valid owner who has a valid pet");

        return super.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);

    }
}
