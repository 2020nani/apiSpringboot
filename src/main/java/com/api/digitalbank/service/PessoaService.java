package com.api.digitalbank.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.api.digitalbank.exception.MenorIdadeException;
import com.api.digitalbank.exception.UnicidadeCpfException;
import com.api.digitalbank.exception.UnicidadeEmailException;
import com.api.digitalbank.exception.UnicidadeValidaEmailException;
import com.api.digitalbank.exception.ValidaCpfException;
import com.api.digitalbank.models.Pessoa;

public interface PessoaService {
	
	Pessoa pess = new Pessoa();
	
	Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException, UnicidadeEmailException,MenorIdadeException,UnicidadeValidaEmailException, ValidaCpfException;
	
}
