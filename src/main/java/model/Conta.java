package model;

import java.time.LocalDate;
import java.util.List;

public class Conta {
    
    private int id;
    private List<Item> itens;
    private LocalDate dataAbertura;
    private LocalDate dataechamento;
    private double total = 0;
    private Cliente cliente;
    private int quarto;

    public Conta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataechamento() {
        return dataechamento;
    }

    public void setDataechamento(LocalDate dataechamento) {
        this.dataechamento = dataechamento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }
    
    
    
}
