package model;

import java.awt.Color;

public class Veiculo {
    
//    private int id;
    private String marca;
    private String modelo;
    private Color cor;
    private String placa;
    private String vagaOcupada;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, Color cor, String placa, String vagaOcupada) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.vagaOcupada = vagaOcupada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVagaOcupada() {
        return vagaOcupada;
    }

    public void setVagaOcupada(String vagaOcupada) {
        this.vagaOcupada = vagaOcupada;
    }
    
    
}
