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

@Entity(name = "Veterian")
@Table(name = "\"Veterian\"", schema =  "\"vetPetCareBackendApp\"")
@Data
                        
public class Veterian {
	public Veterian () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"Vet_id\"", nullable = true )
  private Integer vet_id;
	  
  @Column(name = "\"VetName\"", nullable = true )
  private String vetName;
  
	  
  @Column(name = "\"VetSpecialization\"", nullable = true )
  private String vetSpecialization;
  
	  
  @Column(name = "\"VetPetAnimal\"", nullable = true )
  private String vetPetAnimal;
  
	  
  @Column(name = "\"VetDescription\"", nullable = true )
  private String vetDescription;
  
	  
  @Column(name = "\"VetInstagramprofiletofollow\"", nullable = true )
  private String vetInstagramprofiletofollow;
  
	  
  @Column(name = "\"VetDisplayImage\"", nullable = true )
  private String vetDisplayImage;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VeterianExaminehealth\"",
            joinColumns = @JoinColumn( name="\"Vet_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_id\""), schema = "\"vetPetCareBackendApp\"")
private List<Pet> examinehealth = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"VeterianVetImage\"",
            joinColumns = @JoinColumn( name="\"Vet_id\""),
            inverseJoinColumns = @JoinColumn( name="\"ImageId\""), schema = "\"vetPetCareBackendApp\"")
private List<Image> vetImage = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Veterian [" 
  + "Vet_id= " + vet_id  + ", " 
  + "VetName= " + vetName  + ", " 
  + "VetSpecialization= " + vetSpecialization  + ", " 
  + "VetPetAnimal= " + vetPetAnimal  + ", " 
  + "VetDescription= " + vetDescription  + ", " 
  + "VetInstagramprofiletofollow= " + vetInstagramprofiletofollow  + ", " 
  + "VetDisplayImage= " + vetDisplayImage 
 + "]";
	}
	
}