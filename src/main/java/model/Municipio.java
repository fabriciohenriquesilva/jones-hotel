package model;

public class Municipio {
    
    private Integer id;
    private String nome;
    private String estado;
    private String pais;
    
    private static int ultimoId = 1;

    public Municipio() {
        this.id = ultimoId;
        ultimoId++;
    }

    public Municipio(String nome, String estado, String pais) {
        this.id = ultimoId;
        ultimoId++;
        
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
        final Municipio other = (Municipio) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
