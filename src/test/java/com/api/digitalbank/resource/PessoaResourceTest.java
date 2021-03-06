package com.api.digitalbank.resource;



import org.junit.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import com.api.digitalbank.DigitalbankApplicationTests;
import com.api.digitalbank.models.Endereco;
import com.api.digitalbank.models.Pessoa;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class PessoaResourceTest extends DigitalbankApplicationTests {
   @Test
   public void deve_salvar_nova_pessoa() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("mariovaldoi");
	   pessoa.setSobrenome("sbbbbb");
	   pessoa.setNascimento("11101984");
	   pessoa.setCpf("26848991007");
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
	   pessoa.setCpf("26848991007");
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
	   pessoa.setCpf("26848991007");
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
   @Test
   public void nao_deve_salvar_pessoa_idade_menor_18() throws Exception {
	   final Pessoa pessoa = new Pessoa();
	   pessoa.setNome("mariovaldoi");
	   pessoa.setSobrenome("sbbbbb");
	   pessoa.setNascimento("31122009");
	   pessoa.setCpf("26848991007");
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
	         .body("erro",equalTo("Apenas maiores de 18 anos podem abrir conta"));
	        
	         
   }
   @Test
   public void deve_salvar_endereco() throws Exception {
	   final Endereco endereco = new Endereco();
	   endereco.setRua("rua 10");
	   endereco.setNumero(1234);
	   endereco.setComplemento("casa");
	   endereco.setBairro("Jd Ype");
	   endereco.setCidade("Botucatu");
	   endereco.setEstado("SP");
	   given()
	         .request()
	         .header("Accept", ContentType.ANY)
	         .header("Content-type", ContentType.JSON)
	         .body(endereco)
	   .when()
	   .post("/3/endereco")
	   .then()
	      .log().headers()
	      .and()
	         .log().body()
	       .and()
	         .statusCode(HttpStatus.CREATED.value())
	         .header("Location", equalTo("http://localhost:"+porta+"/pessoas"));
	                  
   }
}
