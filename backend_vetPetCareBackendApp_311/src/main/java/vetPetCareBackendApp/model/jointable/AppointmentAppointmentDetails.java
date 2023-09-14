package vetPetCareBackendApp.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import vetPetCareBackendApp.model.Visit;
import vetPetCareBackendApp.model.Pet;
import vetPetCareBackendApp.model.PetOwner;
import vetPetCareBackendApp.model.VisitScheduler;
import vetPetCareBackendApp.model.Veterian;
import vetPetCareBackendApp.model.Appointment;
import vetPetCareBackendApp.model.VaccineScheduler;
import vetPetCareBackendApp.model.Image;

@Entity(name = "AppointmentAppointmentDetails")
@Table(schema = "\"vetPetCareBackendApp\"", name = "\"AppointmentAppointmentDetails\"")
@Data
public class AppointmentAppointmentDetails{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"AppointmentId\"")
	private Integer appointmentId;

    
    @Column(name = "\"Visit_id\"")
    private Integer visit_id;
 
}