package com.api.digitalbank.repository;


import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.api.digitalbank.models.Pessoa;
import com.api.digitalbank.repository.PessoaRepository;

import java.util.Optional;

@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD )
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD ) 
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:aplication-test.properties")
public class PessoaRepositoryTest {
	@Autowired
	private PessoaRepository sut;
	
	@Test
	public void deve_procurar_pessoa() throws Exception{
		Optional<Pessoa> optional = sut.findByCpf("12345678912");
		
		assertThat(optional.isPresent()).isTrue();
	}

}
