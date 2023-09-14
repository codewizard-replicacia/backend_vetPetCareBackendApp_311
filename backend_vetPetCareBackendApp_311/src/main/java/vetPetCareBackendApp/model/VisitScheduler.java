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

@Entity(name = "VisitScheduler")
@Table(name = "\"VisitScheduler\"", schema =  "\"vetPetCareBackendApp\"")
@Data
                        
public class VisitScheduler {
	public VisitScheduler () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ScheduleVisit_id\"", nullable = true )
  private Integer scheduleVisit_id;
	  
  @Column(name = "\"ScheduleVisitfrom\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date scheduleVisitfrom;  
  
	  
  @Column(name = "\"ScheduleVisitto\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date scheduleVisitto;  
  
	  
  @Column(name = "\"AlertPhonenum\"", nullable = true )
  private Long alertPhonenum;
  
	  
  @Column(name = "\"VisitRecurrence\"", nullable = true )
  private Integer visitRecurrence;
  
	  
  @Column(name = "\"VisitRecurrenceType\"", nullable = true )
  private String visitRecurrenceType;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VisitSchedulerPetVisit\"",
            joinColumns = @JoinColumn( name="\"ScheduleVisit_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Pet> petVisit = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VisitSchedulerPetVaccineSchedular\"",
            joinColumns = @JoinColumn( name="\"ScheduleVisit_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Visit_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Visit> petVaccineSchedular = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VisitSchedulerVisitSchedular\"",
            joinColumns = @JoinColumn( name="\"ScheduleVisit_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Vet_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Veterian> visitSchedular = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VisitSchedulerVetPetVisitSchedular\"",
            joinColumns = @JoinColumn( name="\"ScheduleVisit_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_ownerId\""), schema = "\"vetPetCareBackendApp\"")
private List<PetOwner> vetPetVisitSchedular = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "VisitScheduler [" 
  + "ScheduleVisit_id= " + scheduleVisit_id  + ", " 
  + "ScheduleVisitfrom= " + scheduleVisitfrom  + ", " 
  + "ScheduleVisitto= " + scheduleVisitto  + ", " 
  + "AlertPhonenum= " + alertPhonenum  + ", " 
  + "VisitRecurrence= " + visitRecurrence  + ", " 
  + "VisitRecurrenceType= " + visitRecurrenceType 
 + "]";
	}
	
}