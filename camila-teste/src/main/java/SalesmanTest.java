import org.apache.http.HttpStatus;
import org.junit.Test;

import dto.SalesmanDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SalesmanTest {

	private final String salesmanURL = "http://localhost:8080/salesmen";

	// Salvar um novo objeto - #1
	@Test
	public void testCreateSalesmanSucess() {
		Long registry = 2L;
		Response resp = createSalesmanWithId(registry);
		resp.then().assertThat().statusCode(HttpStatus.SC_CREATED);
	}

	//Buscar objeto por chave primária - #4
	@Test
	public void testFindByIDSucess() {
		Long registry = 2L;
		Response resp = RestAssured.get(salesmanURL + "/" + registry);
		resp.then().assertThat().statusCode(HttpStatus.SC_OK);
	}
	
	//Buscar objeto por chave primária - #5
	@Test
	public void testFindByIDInvalid() {
		Long registry = 3L;
		Response resp = RestAssured.get(salesmanURL + "/" + registry);
		resp.then().assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	//Ativar/desativar um objeto - #6
	@Test
	public void testChangeActiveSuccess() {
		Long registry = 2L;
		Response resp = RestAssured.put(salesmanURL + "/changeActive/" + registry);
		resp.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
	}

	//Ativar/desativar um objeto - #7
	@Test
	public void testChangeActiveInvalid() {
		Long registry = 3L;
		Response resp = RestAssured.put(salesmanURL + "/changeActive/" + registry);
		resp.then().assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	private Response createSalesmanWithId(Long registry) {
		SalesmanDTO order = new SalesmanDTO(2, "Camila", "35984475175", "14/04/2023", 5);
		Response resp = RestAssured.given().body(order).contentType(ContentType.JSON).post(salesmanURL);
		return resp;
	}

}
