package dao;

import java.util.ArrayList;
import java.util.List;

import model.Veiculo;

public class VeiculoDao extends GenericDao<Veiculo, Integer> {
    
    private static final List<Veiculo> veiculos = new ArrayList<>();

    public VeiculoDao(Class<Veiculo> classe, List<Veiculo> entidades) {
        super(classe, entidades);
    }
}
