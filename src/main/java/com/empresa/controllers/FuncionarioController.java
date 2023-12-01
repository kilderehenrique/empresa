package com.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.models.Funcionario;
import com.empresa.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping("/")
    public ResponseEntity<List<Funcionario>> list() {
        return ResponseEntity.ok().body(funcionarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(funcionarioRepository.findById(id).get());
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody(required = true) Funcionario funcionario) {
        String resp = "Novo funcionário criado!";
        
        if(funcionario.getId() != null && funcionarioRepository.existsById(funcionario.getId()))
            resp = "Dados do funcionário atualizados!";
        
        funcionarioRepository.save(funcionario);

        return ResponseEntity.ok().body(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String resp = "Funcionário deletado!";
        
        if(funcionarioRepository.existsById(id))
            funcionarioRepository.deleteById(id);
        else        
            resp = "Funcionário não cadastrado!";

        return ResponseEntity.ok().body(resp);
    }

}
