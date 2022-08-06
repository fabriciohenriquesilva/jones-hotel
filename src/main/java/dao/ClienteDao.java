package dao;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends GenericDao<Cliente, Integer> {

    private static final List<Cliente> clientes = new ArrayList<>();

    public ClienteDao(){
        super(Cliente.class, clientes);
    }
}
