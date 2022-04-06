package model;

import java.time.LocalDate;

public class Parcela {
    
    private int identificador;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private double valor;
    private double jurosMoraAplicado;
    private double valorFinal;

    public Parcela() {
    }

    public Parcela(int identificador, LocalDate dataVencimento, double valor, double jurosMoraAplicado, double valorFinal) {
        this.identificador = identificador;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.jurosMoraAplicado = jurosMoraAplicado;
        this.valorFinal = valorFinal;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJurosMoraAplicado() {
        return jurosMoraAplicado;
    }

    public void setJurosMoraAplicado(double jurosMoraAplicado) {
        this.jurosMoraAplicado = jurosMoraAplicado;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    
}
