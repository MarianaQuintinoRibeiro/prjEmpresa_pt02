package com.marianaquintino.PrjEmpresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marianaquintino.PrjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	@Query("SELECT f FROM Funcionario f WHERE LOWER(f.funnome) LIKE LOWER(CONCAT('%', :funnome, '%'))")
	List<Funcionario> findByNomeContaining(@Param("funnome") String funnome);

}
