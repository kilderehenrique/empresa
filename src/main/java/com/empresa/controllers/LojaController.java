package com.empresa.controllers;

import java.util.ArrayList;
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

import com.empresa.DTO.FuncionarioDTO;
import com.empresa.DTO.LojaDTO;
import com.empresa.models.Funcionario;
import com.empresa.models.Loja;
import com.empresa.repository.FuncionarioRepository;
import com.empresa.repository.LojaRepository;

@RestController
@RequestMapping("/lojas")
public class LojaController {
    
    @Autowired
    LojaRepository lojaRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping("/")
    public ResponseEntity<List<Loja>> list() {
        return ResponseEntity.ok().body(lojaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(lojaRepository.findById(id).get());
    }

    @GetMapping("/{id}/funcionarios")
    public ResponseEntity<LojaDTO> findWithFuncionarios(@PathVariable Long id) {
        Loja loja = lojaRepository.findById(id).get();
        List<Funcionario> funcionarios = funcionarioRepository.findAllByLoja(id);
        
        LojaDTO lojaDTO = new LojaDTO();

        List<FuncionarioDTO> funcionarioDTOs = new ArrayList<FuncionarioDTO>();

        for(Funcionario funcionario : funcionarios)
            funcionarioDTOs.add(new FuncionarioDTO(funcionario));

        lojaDTO.setLoja(loja);
        lojaDTO.setFuncionarios(funcionarioDTOs);
        
        return ResponseEntity.ok().body(lojaDTO);
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Loja loja) {
        String resp = "Nova loja criado!";
        
        if(loja.getId() != null && lojaRepository.existsById(loja.getId()))
            resp = "Dados da loja atualizados!";
        
        lojaRepository.save(loja);
        return ResponseEntity.ok().body(resp);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String resp = "Loja deletada!";

        if(lojaRepository.existsById(id))
            lojaRepository.deleteById(id);
        else        
            resp = "Loja não cadastrada!";

        return ResponseEntity.ok().body(resp);
    }
}
