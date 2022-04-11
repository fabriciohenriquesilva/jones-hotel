package dao;

import java.util.List;
import java.util.NoSuchElementException;
import model.Veiculo;

public class VeiculoDAO {
    
    private final List<Veiculo> veiculos;
    
    public VeiculoDAO(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
    public boolean incluir(Veiculo veiculo){
        if(veiculos.contains(veiculo)){
            return false;
        }
        return veiculos.add(veiculo);
    }
    
    public Veiculo consultar(int id) throws NoSuchElementException {
        Veiculo veiculo = veiculos.stream()
                .filter(mncp -> id == mncp.getId())
                .findFirst()
                .orElseThrow();
        
        return veiculo;
    }
    
    public boolean excluir(Veiculo veiculo){
        if(veiculos.contains(veiculo)){
            return veiculos.remove(veiculo);
        }
        
        return false;
    }
    
    public List<Veiculo> listarTodos(){
        return veiculos;
    }
}
