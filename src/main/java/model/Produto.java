package model;

import java.time.LocalDate;

public class Produto extends Item {
    
    private String marca;
    private LocalDate validade;

    public Produto() {
    }

    public Produto(String marca, String descricao, double preco) {
        super(descricao, preco);
        this.marca = marca;
    }

    public Produto(String marca, LocalDate validade, String descricao, double preco) {
        super(descricao, preco);
        this.marca = marca;
        this.validade = validade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
    
    
    
}
