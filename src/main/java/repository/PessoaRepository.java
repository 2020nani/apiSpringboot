package repository;

import java.util.Optional;

import models.Pessoa;

public interface PessoaRepository {

    Pessoa save(Pessoa pessoa);

	Optional<Pessoa> findByCpf(String cpf);

}
