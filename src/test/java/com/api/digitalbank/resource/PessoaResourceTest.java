package com.api.digitalbank.resource;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import com.api.digitalbank.DigitalbankApplicationTests;
import com.api.digitalbank.models.Pessoa;

import io.restassured.http.ContentType;

public class PessoaResourceTest extends DigitalbankApplicationTests {
   @Test
   public void deve_salvar_nova_pessoa() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("hernani");
	   pessoa.setSobrenome("Almeida");
	   pessoa.setNascimento("11/10/1984");
	   pessoa.setCpf("12345678912");
	   pessoa.setEmail("her@outlook");
	   given()
	         .request()
	         .header("Accept", ContentType.ANY)
	         .header("Content-type", ContentType.JSON)
	         .body(pessoa)
	   .when()
	   .post("/pessoas")
	   .then()
	        // .log().headers()
	     //  .and()
	         .log().body()
	       .and()
	         .statusCode(HttpStatus.CREATED.value());
	        // .header("Location", equalTo("http://localhost:"+porta+"/pessoas/6"));
	         
   }
}
