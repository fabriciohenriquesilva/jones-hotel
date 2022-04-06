package model;

public class Funcionario {
    
    private int id;
    private String matricula;
    private String nome;
    private String profissao;

    public Funcionario() {
    }

    public Funcionario(String matricula, String nome, String profissao) {
        this.matricula = matricula;
        this.nome = nome;
        this.profissao = profissao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    
}
