package com.api.digitalbank.resource;



import org.junit.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import com.api.digitalbank.DigitalbankApplicationTests;
import com.api.digitalbank.models.Pessoa;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class PessoaResourceTest extends DigitalbankApplicationTests {
   @Test
   public void deve_salvar_nova_pessoa() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("mariovaldoi");
	   pessoa.setSobrenome("sbbbbb");
	   pessoa.setNascimento("11101984");
	   pessoa.setCpf("33607069867");
	   pessoa.setEmail("gg@hotmail.com");
	   given()
	         .request()
	         .header("Accept", ContentType.ANY)
	         .header("Content-type", ContentType.JSON)
	         .body(pessoa)
	   .when()
	   .post("/pessoas")
	   .then()
	      .log().headers()
	      .and()
	         .log().body()
	       .and()
	         .statusCode(HttpStatus.CREATED.value())
	         .header("Location", equalTo("http://localhost:"+porta+"/pessoas"));
	                  
   }
   @Test
   public void nao_deve_salvar_pessoa_mesmo_cpf() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("mariovaldoi");
	   pessoa.setSobrenome("sbbbbb");
	   pessoa.setNascimento("11101985");
	   pessoa.setCpf("12345678912");
	   pessoa.setEmail("h");
	   given()
	         .request()
	         .header("Accept", ContentType.ANY)
	         .header("Content-type", ContentType.JSON)
	         .body(pessoa)
	   .when()
	   .post("/pessoas")
	   .then()
	         .log().body()
	       .and()
	         .statusCode(HttpStatus.BAD_REQUEST.value())
	         .body("erro",equalTo("Ja existe pessoa cadastrada com este CPF"));
	                
   }
   @Test
   public void nao_deve_salvar_pessoa_mesmo_email() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("mariovaldoi");
	   pessoa.setSobrenome("sbbbbb");
	   pessoa.setNascimento("31121989");
	   pessoa.setCpf("33607069867");
	   pessoa.setEmail("hr@hotmail.com");
	   given()
	         .request()
	         .header("Accept", ContentType.ANY)
	         .header("Content-type", ContentType.JSON)
	         .body(pessoa)
	   .when()
	   .post("/pessoas")
	   .then()
	         .log().body()
	       .and()
	         .statusCode(HttpStatus.BAD_REQUEST.value())
	         .body("erro",equalTo("Ja existe pessoa cadastrada com este Email"));
	        
	         
   }
   @Test
   public void nao_deve_salvar_pessoa_email_formato_naoexistente() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("mariovaldoi");
	   pessoa.setSobrenome("sbbbbb");
	   pessoa.setNascimento("31121989");
	   pessoa.setCpf("33607069867");
	   pessoa.setEmail("h");
	   given()
	         .request()
	         .header("Accept", ContentType.ANY)
	         .header("Content-type", ContentType.JSON)
	         .body(pessoa)
	   .when()
	   .post("/pessoas")
	   .then()
	         .log().body()
	       .and()
	         .statusCode(HttpStatus.BAD_REQUEST.value())
	         .body("erro",equalTo("Nao existe este formato de email"));
	        
	         
   }
   @Test
   public void nao_deve_salvar_pessoa_cpf_formato_naoexistente() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("mariovaldoi");
	   pessoa.setSobrenome("sbbbbb");
	   pessoa.setNascimento("31121989");
	   pessoa.setCpf("19560875432");
	   pessoa.setEmail("yt@hotmail.com");
	   given()
	         .request()
	         .header("Accept", ContentType.ANY)
	         .header("Content-type", ContentType.JSON)
	         .body(pessoa)
	   .when()
	   .post("/pessoas")
	   .then()
	         .log().body()
	       .and()
	         .statusCode(HttpStatus.BAD_REQUEST.value())
	         .body("erro",equalTo("Nao existe este formato de cpf"));
	        
	         
   }
}
