package vetPetCareBackendApp.repository;


import vetPetCareBackendApp.model.VaccineScheduler;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class VaccineSchedulerRepository extends SimpleJpaRepository<VaccineScheduler, String> {
    private final EntityManager em;
    public VaccineSchedulerRepository(EntityManager em) {
        super(VaccineScheduler.class, em);
        this.em = em;
    }
    @Override
    public List<VaccineScheduler> findAll() {
        return em.createNativeQuery("Select * from \"vetPetCareBackendApp\".\"VaccineScheduler\"", VaccineScheduler.class).getResultList();
    }
}