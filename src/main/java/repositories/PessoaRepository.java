package repositories;

import org.springframework.data.repository.CrudRepository;

import entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
