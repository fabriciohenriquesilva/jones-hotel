package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO {
    
    private final List<Cliente> clientes;

    public ClienteDAO() {
        clientes = new ArrayList<>();
    }
    
    public boolean incluir(Cliente cliente){
        if(clientes.contains(cliente)){
            return false;
        }
        return clientes.add(cliente);
    }
    
    public Cliente consultar(int id){
        Cliente cliente = clientes.stream()
                .filter(cli -> id == cli.getId())
                .findFirst()
                .orElseThrow();
        
        return cliente;
    }
    
    public boolean excluir(Cliente cliente){
        if(clientes.contains(cliente)){
            return clientes.remove(cliente);
        }
        
        return false;
    }
    
    public List<Cliente> listarTodos(){
        return clientes;
    }
    
}