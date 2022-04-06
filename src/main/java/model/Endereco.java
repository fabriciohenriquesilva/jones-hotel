package model;

public class Endereco {
    
//    private int id;
    private String logradouro;
    private String numero;
    private String bairro;
    private Municipio municipio;
    private String complemento;
    private String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String bairro, Municipio municipio, String complemento, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.municipio = municipio;
        this.complemento = complemento;
        this.cep = cep;
    }
    
    
}
