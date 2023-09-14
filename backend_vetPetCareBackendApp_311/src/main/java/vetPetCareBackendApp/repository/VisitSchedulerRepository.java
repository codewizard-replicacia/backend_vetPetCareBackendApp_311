package vetPetCareBackendApp.repository;


import vetPetCareBackendApp.model.VisitScheduler;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class VisitSchedulerRepository extends SimpleJpaRepository<VisitScheduler, String> {
    private final EntityManager em;
    public VisitSchedulerRepository(EntityManager em) {
        super(VisitScheduler.class, em);
        this.em = em;
    }
    @Override
    public List<VisitScheduler> findAll() {
        return em.createNativeQuery("Select * from \"vetPetCareBackendApp\".\"VisitScheduler\"", VisitScheduler.class).getResultList();
    }
}