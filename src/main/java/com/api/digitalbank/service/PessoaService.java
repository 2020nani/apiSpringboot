package com.api.digitalbank.service;



import com.api.digitalbank.exception.MenorIdadeException;
import com.api.digitalbank.exception.UnicidadeCpfException;
import com.api.digitalbank.exception.UnicidadeEmailException;
import com.api.digitalbank.exception.UnicidadeValidaEmailException;
import com.api.digitalbank.exception.ValidaCpfException;
import com.api.digitalbank.models.Endereco;
import com.api.digitalbank.models.Pessoa;

public interface PessoaService {
	
	
	
	Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException, UnicidadeEmailException,MenorIdadeException,UnicidadeValidaEmailException, ValidaCpfException;
}
