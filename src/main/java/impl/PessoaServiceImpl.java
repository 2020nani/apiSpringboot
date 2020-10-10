package impl;

import models.Pessoa;
import repository.PessoaRepository;
import service.PessoaService;
import java.util.Optional;

import exception.UnicidadeCpfException;

public class PessoaServiceImpl implements PessoaService {
	private final PessoaRepository pessoaRepository;
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
    	this.pessoaRepository = pessoaRepository;
    }
    @Override
    public Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException  {
    	Optional<Pessoa> optional = pessoaRepository.findByCpf(pessoa.getCpf());
    	
    	if( optional.isPresent() ) {
    		throw new UnicidadeCpfException();
    	}
    	
    	return pessoaRepository.save(pessoa);
    }
}
