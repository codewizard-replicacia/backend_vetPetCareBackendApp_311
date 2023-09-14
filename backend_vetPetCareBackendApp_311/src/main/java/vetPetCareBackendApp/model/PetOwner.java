package vetPetCareBackendApp.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import vetPetCareBackendApp.model.Visit;
import vetPetCareBackendApp.model.Pet;
import vetPetCareBackendApp.model.PetOwner;
import vetPetCareBackendApp.model.VisitScheduler;
import vetPetCareBackendApp.model.Veterian;
import vetPetCareBackendApp.model.Appointment;
import vetPetCareBackendApp.model.VaccineScheduler;
import vetPetCareBackendApp.model.Image;
import vetPetCareBackendApp.converter.DurationConverter;
import vetPetCareBackendApp.converter.UUIDToByteConverter;
import vetPetCareBackendApp.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "PetOwner")
@Table(name = "\"PetOwner\"", schema =  "\"vetPetCareBackendApp\"")
@Data
                        
public class PetOwner {
	public PetOwner () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"Pet_ownerId\"", nullable = true )
  private Integer pet_ownerId;
	  
  @Column(name = "\"PetOwnername\"", nullable = true )
  private String petOwnername;
  
	  
  @Column(name = "\"PetOwnerphone\"", nullable = true )
  private Long petOwnerphone;
  
	  
  @Column(name = "\"PetOwnerDisplayImage\"", nullable = true )
  private String petOwnerDisplayImage;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"PetOwnerBookAppointmentScheduleVisitVaccine\"",
            joinColumns = @JoinColumn( name="\"Pet_ownerId\""),
            inverseJoinColumns = @JoinColumn( name="\"Vet_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Veterian> bookAppointmentScheduleVisitVaccine = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"PetOwnerPetOwnerImage\"",
            joinColumns = @JoinColumn( name="\"Pet_ownerId\""),
            inverseJoinColumns = @JoinColumn( name="\"ImageId\""), schema = "\"vetPetCareBackendApp\"")
private List<Image> petOwnerImage = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "PetOwner [" 
  + "Pet_ownerId= " + pet_ownerId  + ", " 
  + "PetOwnername= " + petOwnername  + ", " 
  + "PetOwnerphone= " + petOwnerphone  + ", " 
  + "PetOwnerDisplayImage= " + petOwnerDisplayImage 
 + "]";
	}
	
}