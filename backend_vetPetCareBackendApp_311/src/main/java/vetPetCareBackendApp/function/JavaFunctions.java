package vetPetCareBackendApp.function;

import vetPetCareBackendApp.model.Visit;
import vetPetCareBackendApp.model.Pet;
import vetPetCareBackendApp.model.PetOwner;
import vetPetCareBackendApp.model.VisitScheduler;
import vetPetCareBackendApp.model.Veterian;
import vetPetCareBackendApp.model.Appointment;
import vetPetCareBackendApp.model.VaccineScheduler;
import vetPetCareBackendApp.model.Image;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;
import vetPetCareBackendApp.repository.AppointmentRepository;
import vetPetCareBackendApp.repository.PetOwnerRepository;
import vetPetCareBackendApp.repository.VeterianRepository;
import vetPetCareBackendApp.repository.VisitRepository;
import vetPetCareBackendApp.repository.VaccineSchedulerRepository;
import vetPetCareBackendApp.repository.ImageRepository;
import vetPetCareBackendApp.repository.PetRepository;
import vetPetCareBackendApp.repository.VisitSchedulerRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class JavaFunctions implements ODataFunction {


    
    
}
   
