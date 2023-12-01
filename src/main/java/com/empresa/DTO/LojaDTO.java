package com.empresa.DTO;

import java.util.List;

import com.empresa.models.Loja;

public class LojaDTO {
    
    private Loja loja;
    private List<FuncionarioDTO> funcionarios;

    
    public LojaDTO() {
    }

    public LojaDTO(Loja loja, List<FuncionarioDTO> funcionarios) {
        this.loja = loja;
        this.funcionarios = funcionarios;
    }

    public Loja getLoja() {
        return loja;
    }
    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    public List<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
