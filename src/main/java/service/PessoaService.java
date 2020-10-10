package service;

import exception.UnicidadeCpfException;
import models.Pessoa;

public interface PessoaService {

	Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException;

}
