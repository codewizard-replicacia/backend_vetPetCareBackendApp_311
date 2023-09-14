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

@Entity(name = "VaccineScheduler")
@Table(name = "\"VaccineScheduler\"", schema =  "\"vetPetCareBackendApp\"")
@Data
                        
public class VaccineScheduler {
	public VaccineScheduler () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"Vaccine_id\"", nullable = true )
  private Integer vaccine_id;
	  
  @Column(name = "\"ScheduleVaccinefrom\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date scheduleVaccinefrom;  
  
	  
  @Column(name = "\"ScheduleVaccineto\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date scheduleVaccineto;  
  
	  
  @Column(name = "\"VaccineRecurrence\"", nullable = true )
  private Integer vaccineRecurrence;
  
	  
  @Column(name = "\"VaccineRecurrenceType\"", nullable = true )
  private String vaccineRecurrenceType;
  
	  
  @Column(name = "\"AlertPhonenum\"", nullable = true )
  private Long alertPhonenum;
  
	  
  @Column(name = "\"UploadPrescription\"", nullable = true )
  private String uploadPrescription;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VaccineSchedulerPetVaccine\"",
            joinColumns = @JoinColumn( name="\"Vaccine_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Pet> petVaccine = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VaccineSchedulerVaccineDetails\"",
            joinColumns = @JoinColumn( name="\"Vaccine_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Visit_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Visit> vaccineDetails = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VaccineSchedulerVetVaccineSchedular\"",
            joinColumns = @JoinColumn( name="\"Vaccine_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Vet_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Veterian> vetVaccineSchedular = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VaccineSchedulerVetPetVaccineSchedularAlert\"",
            joinColumns = @JoinColumn( name="\"Vaccine_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_ownerId\""), schema = "\"vetPetCareBackendApp\"")
private List<PetOwner> vetPetVaccineSchedularAlert = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VaccineSchedulerPrescription\"",
            joinColumns = @JoinColumn( name="\"Vaccine_id\""),
            inverseJoinColumns = @JoinColumn( name="\"ImageId\""), schema = "\"vetPetCareBackendApp\"")
private List<Image> prescription = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "VaccineScheduler [" 
  + "Vaccine_id= " + vaccine_id  + ", " 
  + "ScheduleVaccinefrom= " + scheduleVaccinefrom  + ", " 
  + "ScheduleVaccineto= " + scheduleVaccineto  + ", " 
  + "VaccineRecurrence= " + vaccineRecurrence  + ", " 
  + "VaccineRecurrenceType= " + vaccineRecurrenceType  + ", " 
  + "AlertPhonenum= " + alertPhonenum  + ", " 
  + "UploadPrescription= " + uploadPrescription 
 + "]";
	}
	
}