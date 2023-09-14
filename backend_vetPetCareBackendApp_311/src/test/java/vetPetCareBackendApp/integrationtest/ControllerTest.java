package vetPetCareBackendApp.integrationtest;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import vetPetCareBackendApp.SpringApp;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.yml" })
class ControllerTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private WebApplicationContext context;
  @LocalServerPort
  private int port;

  @BeforeEach
  void setup() {
    RestAssuredMockMvc.webAppContextSetup(context);
  }

  
  
   private JsonNode getJSONFromFile(String filePath) throws IOException {
    try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)){
      JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
      return jsonNode;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  
  private String getPayload(String filePath) throws IOException {
	  String jsonString = mapper.writeValueAsString( getJSONFromFile(filePath) );
	  return jsonString;
  }

  @Test
  void testRetrieveServiceDocument() {
    final String xml = given()
        .accept(ContentType.XML)
        .when()
        .get("/vetPetCareBackendApp/")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Collection<Node> n = ((Node) ((Node) path.get("service")).get("workspace")).get("collection");
    assertNotNull(n);
    assertFalse(n.isEmpty());
  }

  @Test
  void  testRetrieveMetadataDocument() {
    final String xml = given()
        .when()
        .get("/vetPetCareBackendApp/$metadata")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Node n = ((Node) ((Node) path.get("edmx:Ed mx")).get("DataServices")).get("Schema");
    assertNotNull(n);
    assertEquals("vetPetCareBackendApp", n.getAttribute("Namespace"));
    assertNotNull(n.get("EntityContainer"));
  }

	

	
  @Test
  void  testCreateAppointmentInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("AppointmentInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Appointments")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsAppointment() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("AppointmentInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Appointments")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/Appointments?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).AppointmentId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/Appointments/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreatePetOwnerInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("PetOwnerInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/PetOwners")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsPetOwner() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("PetOwnerInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/PetOwners")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/PetOwners?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Pet_ownerId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/PetOwners/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateVeterianInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("VeterianInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Veterians")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsVeterian() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("VeterianInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Veterians")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/Veterians?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Vet_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/Veterians/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateVisitInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("VisitInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Visits")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsVisit() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("VisitInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Visits")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/Visits?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Visit_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/Visits/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateVaccineSchedulerInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("VaccineSchedulerInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/VaccineSchedulers")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsVaccineScheduler() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("VaccineSchedulerInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/VaccineSchedulers")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/VaccineSchedulers?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Vaccine_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/VaccineSchedulers/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateImageInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ImageInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Images")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsImage() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ImageInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Images")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/Images?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ImageId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/Images/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreatePetInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("PetInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Pets")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsPet() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("PetInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/Pets")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/Pets?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Pet_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/Pets/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateVisitSchedulerInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("VisitSchedulerInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/VisitSchedulers")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsVisitScheduler() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("VisitSchedulerInstance.json"))
        .when()
        .post("/vetPetCareBackendApp/VisitSchedulers")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/vetPetCareBackendApp/VisitSchedulers?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ScheduleVisit_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/vetPetCareBackendApp/VisitSchedulers/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
           
       
  
  
  
  
 
  @AfterEach
  void  teardown() {
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.Appointment");
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.PetOwner");
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.Veterian");
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.Visit");
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VaccineScheduler");
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.Image");
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.Pet");
    jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VisitScheduler");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VaccineSchedulerPetVaccine");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.PetOwnerPetOwnerImage");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VisitSchedulerPetVisit");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.PetPetImage");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VisitSchedulerVetPetVisitSchedular");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VaccineSchedulerVetVaccineSchedular");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.PetVisits");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VisitSchedulerVisitSchedular");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.AppointmentVetPetVaccineSchedular");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VeterianVetImage");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VaccineSchedulerVaccineDetails");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.AppointmentPetappointment");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VaccineSchedulerVetPetVaccineSchedularAlert");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.PetOwns");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.PetOwnerBookAppointmentScheduleVisitVaccine");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VisitSchedulerPetVaccineSchedular");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.AppointmentAppointmentDetails");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.AppointmentVetpetappointment");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VaccineSchedulerPrescription");
     jdbcTemplate.execute("DELETE FROM vetPetCareBackendApp.VeterianExaminehealth");

    RestAssuredMockMvc.reset();
  }
}
