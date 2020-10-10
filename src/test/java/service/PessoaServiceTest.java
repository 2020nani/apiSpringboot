package service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import impl.PessoaServiceImpl;
import models.Pessoa;
import repository.PessoaRepository;

@RunWith(SpringRunner.class)
public class PessoaServiceTest {
	
	private static final String nome = "Hernani";
	private static final String cpf = "12345678912";
	
//faz um mock de pessoarepository
	@MockBean
	private PessoaRepository pessoaRepository;
	
	private PessoaService sut;
	
	private Pessoa pessoa;
//utiliza interface pessoaService para injetar os dados pessoa repository	
	@BeforeAll
	public void setUp() throws Exception{
		sut = new PessoaServiceImpl(pessoaRepository);
		pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
	
	}
//teste salvar pessoa	
@Test
public void deve_salvar_pessoa_no_repositorio() throws Exception{
	sut.salvar(pessoa);
	
	verify(pessoaRepository).save(pessoa);
}

}
