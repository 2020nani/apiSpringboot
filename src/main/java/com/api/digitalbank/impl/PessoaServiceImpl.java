package com.api.digitalbank.impl;

import com.api.digitalbank.models.*;
import com.api.digitalbank.repository.*;
import com.api.digitalbank.service.*;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.digitalbank.exception.MenorIdadeException;
import com.api.digitalbank.exception.UnicidadeCpfException;
import com.api.digitalbank.exception.UnicidadeEmailException;
import com.api.digitalbank.exception.UnicidadeValidaEmailException;
import com.api.digitalbank.exception.ValidaCpfException;



@Service
public class PessoaServiceImpl implements PessoaService {
	private final PessoaRepository pessoaRepository;
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
    	this.pessoaRepository = pessoaRepository;
    }
    @Override
    public Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException,UnicidadeEmailException,MenorIdadeException, UnicidadeValidaEmailException,ValidaCpfException  {
    	boolean validaEmail = PessoaRepository.isValidEmailAddress(pessoa.getEmail()) ;
    	
    	boolean validacpf = PessoaRepository.ValidaCPF(pessoa.getCpf());
       int nasci = PessoaRepository.calculaIdade(pessoa.getNascimento()) ;
    	
    	Optional<Pessoa> optionalcpf = pessoaRepository.findByCpf(pessoa.getCpf());
    	
    	Optional<Pessoa> optionalemail = pessoaRepository.findByEmail(pessoa.getEmail());
    	
    	if( optionalcpf.isPresent() ) {
    		throw new UnicidadeCpfException("Ja existe pessoa cadastrada com este CPF");
    	}
    	if( optionalemail.isPresent() ) {
    		throw new UnicidadeEmailException("Ja existe pessoa cadastrada com este Email");
    	}
    	if(validaEmail == false ) {
    		throw new UnicidadeValidaEmailException("Nao existe este formato de email");
    	}
    	if(validacpf == false ) {
    		throw new UnicidadeValidaEmailException("Nao existe este formato de cpf");
    	}
    	if(nasci<18) {
    		throw new MenorIdadeException("Apenas maiores de 18 anos podem abrir conta");
    	}
    	return pessoaRepository.save(pessoa);
    }
}
