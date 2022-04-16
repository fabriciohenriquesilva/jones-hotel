package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Municipio;

public class BaseDeDados {
    
    private static final List<Municipio> municipios = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    
    public static List<Municipio> getMunicipios(){
        return municipios;
    }
    
    
}
