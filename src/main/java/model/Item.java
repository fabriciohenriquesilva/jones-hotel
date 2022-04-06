package model;

public class Item {
    
    private int identificador;
    private String descricao;
    private double preco;

    public Item() {
    }

    public Item(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
