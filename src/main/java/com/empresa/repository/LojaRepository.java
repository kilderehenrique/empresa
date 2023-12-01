package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.models.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    
}
