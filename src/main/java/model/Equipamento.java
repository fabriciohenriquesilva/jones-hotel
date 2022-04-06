package model;

public class Equipamento {
    
    private int identificador;
    private String descricao;

    public Equipamento() {
    }

    public Equipamento(int identificador, String descricao) {
        this.identificador = identificador;
        this.descricao = descricao;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
