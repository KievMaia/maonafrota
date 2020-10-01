package br.com.kiev.maonafrota.domain.condutor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CondutorRepository extends JpaRepository<Condutor, Integer>{

	public Condutor findByMatricula (String matricula);
}
