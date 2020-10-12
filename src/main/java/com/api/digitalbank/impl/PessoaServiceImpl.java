package com.api.digitalbank.impl;

import com.api.digitalbank.models.*;
import com.api.digitalbank.repository.*;
import com.api.digitalbank.service.*;



import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.digitalbank.exception.UnicidadeCpfException;
import com.api.digitalbank.exception.UnicidadeEmailException;


@Service
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
