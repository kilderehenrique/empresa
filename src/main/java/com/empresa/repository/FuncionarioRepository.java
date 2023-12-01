package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    @Query(
        value = "SELECT f.* FROM funcionario f WHERE f.loja_id = :id",
        nativeQuery = true
    )
    public List<Funcionario> findAllByLoja(@Param("id") Long id);

}
