package dao;

import java.util.List;
import java.util.NoSuchElementException;
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
    
    public Municipio consultar(int id) throws NoSuchElementException {
        Municipio municipio = municipios.stream()
                .filter(mncp -> id == mncp.getId())
                .findFirst()
                .orElseThrow();
        
        return municipio;
    }
    
    public Municipio consultar(String nome){
        for(Municipio m : municipios){
            if(nome.equals(m.getNome())){
                return m;
            }
        }
        return null;
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
