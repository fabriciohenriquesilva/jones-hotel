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

    // Acredito que o metódo abaixo seja desnecessário
    // Pois, para alterar um cliente, posso simplesmente
    // Buscar pelo seu ID, retornar e modificar os seus atributos
    // Com os devidos Setters na classe Controller
//    public Cliente alterar(Cliente cliente){
//        
//        Cliente clienteAlterado = consultar(cliente.getCpf());
//        
//        clienteAlterado.setNome(cliente.getNome());
//        clienteAlterado.setIdentidade(cliente.getIdentidade());
//        clienteAlterado.setSalario(cliente.getSalario());
//        
//        return clienteAlterado;
//    }
    
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