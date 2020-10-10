package service;

import exception.UnicidadeCpfException;
import exception.UnicidadeEmailException;
import models.Pessoa;

public interface PessoaService {

	Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException, UnicidadeEmailException;

}
