package com.empresa.DTO;

import com.empresa.models.Cargo;
import com.empresa.models.Funcionario;
import com.empresa.models.Loja;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class FuncionarioDTO {
    
    private String nome;
    private Integer idade;
    private String telefone;
    private String email;
    private Cargo cargo;
    

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.idade = funcionario.getIdade();
        this.telefone = funcionario.getTelefone();
        this.email = funcionario.getEmail();
        this.cargo = funcionario.getCargo();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
