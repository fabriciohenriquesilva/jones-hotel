package dao;

import java.util.List;
import model.Municipio;

public class MunicipioDAO {

    private final List<Municipio> municipios;

    public MunicipioDAO() {
        municipios = BaseDeDados.getMunicipios();
    }
    
    public boolean incluir(Municipio municipio){
        if(municipios.contains(municipio)){
            return false;
        }
        return municipios.add(municipio);
    }
    
    public Municipio consultar(int id) throws NullPointerException {
        for(Municipio m : municipios){
            if(id == m.getId()){
                return m;
            }
        }
        throw new NullPointerException();
    }
    
    public Municipio consultar(String nome) throws NullPointerException{
        for(Municipio m : municipios){
            if(nome.equals(m.getNome())){
                return m;
            }
        }
        throw new NullPointerException();
    }
    
    public boolean excluir(Municipio municipio){
        if(municipios.contains(municipio)){
            return municipios.remove(municipio);
        }
        
        return false;
    }
    
    public List<Municipio> listarTodos(){
        return municipios;
    }
}
