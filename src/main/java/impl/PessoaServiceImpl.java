package impl;

import models.Pessoa;
import repository.PessoaRepository;
import service.PessoaService;
import java.util.Optional;

import exception.UnicidadeCpfException;
import exception.UnicidadeEmailException;

public class PessoaServiceImpl implements PessoaService {
	private final PessoaRepository pessoaRepository;
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
    	this.pessoaRepository = pessoaRepository;
    }
    @Override
    public Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException,UnicidadeEmailException  {
    	Optional<Pessoa> optionalcpf = pessoaRepository.findByCpf(pessoa.getCpf());
    	
    	Optional<Pessoa> optionalemail = pessoaRepository.findByEmail(pessoa.getEmail());
    	
    	if( optionalcpf.isPresent() ) {
    		throw new UnicidadeCpfException();
    	}
    	if( optionalemail.isPresent() ) {
    		throw new UnicidadeEmailException();
    	}
    	
    	return pessoaRepository.save(pessoa);
    }
}
