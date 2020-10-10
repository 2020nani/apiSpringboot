package impl;

import models.Pessoa;
import repository.PessoaRepository;
import service.PessoaService;

public class PessoaServiceImpl implements PessoaService {
	private final PessoaRepository pessoaRepository;
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
    	this.pessoaRepository = pessoaRepository;
    }
    @Override
    public Pessoa salvar(Pessoa pessoa) {
    	return null;
    }
}
