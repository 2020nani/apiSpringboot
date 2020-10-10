package com.api.digitalbank.service;

import com.api.digitalbank.exception.UnicidadeCpfException;
import com.api.digitalbank.exception.UnicidadeEmailException;
import com.api.digitalbank.models.Pessoa;

public interface PessoaService {

	Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException, UnicidadeEmailException;

}
