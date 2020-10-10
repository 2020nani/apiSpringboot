package service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import exception.UnicidadeCpfException;
import impl.PessoaServiceImpl;
import models.Pessoa;
import repository.PessoaRepository;

@RunWith(SpringRunner.class)
public class PessoaServiceTest {
	
	private static final String NOME = "Hernani Almeida";
	private static final String CPF = "ok";
	
//faz um mock de pessoarepository
	@MockBean
	private PessoaRepository pessoaRepository;
	
	private PessoaService sut;
	
	private Pessoa pessoa;
//utiliza interface pessoaService para injetar os dados pessoa repository	
	@Before
	public void setUp() throws Exception{
		sut = new PessoaServiceImpl(pessoaRepository);
		
		pessoa = new Pessoa();
		pessoa.setNome(NOME);
		pessoa.setCpf(CPF);
		
		when(pessoaRepository.findByCpf(CPF)).thenReturn(Optional.empty());
	
	}
//teste salvar pessoa	
@Test
public void deve_salvar_pessoa_no_repositorio() throws Exception{
	
	sut.salvar(pessoa);
	
	verify(pessoaRepository).save(pessoa);
}

@Test(expected = UnicidadeCpfException.class)
public void nao_deve_salvar_duas_pessoas_com_o_mesmo_cpf() throws Exception{
	when(pessoaRepository.findByCpf(CPF)).thenReturn(Optional.of(pessoa));
	
	sut.salvar(pessoa);
}

}
