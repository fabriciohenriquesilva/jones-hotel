package model;

import java.awt.Color;

public class Veiculo {
    
    private int id;
    private String marca;
    private String modelo;
    private Color cor;
    private String placa;
    private String vagaOcupada;
    
    private static int ultimoId = 1;

    public Veiculo() {
        this.id = ultimoId;
        ultimoId++;
    }

    public Veiculo(String marca, String modelo, Color cor, String placa) {
        this.id = ultimoId;
        ultimoId++;
        
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }
    
    public Veiculo(String marca, String modelo, Color cor, String placa, String vagaOcupada) {
        this.id = ultimoId;
        ultimoId++;
        
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.vagaOcupada = vagaOcupada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        return this.id == other.id;
    }
    
    
    
}
