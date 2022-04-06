package model;

import java.util.List;

public class Servico extends Item {
    
    private List<Funcionario> profissionais;
    private List<Equipamento> equipamentos;

    public Servico() {
    }

    public Servico(String descricao, double preco) {
        super(descricao, preco);
    }

    public List<Funcionario> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Funcionario> profissionais) {
        this.profissionais = profissionais;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
    
    
}
