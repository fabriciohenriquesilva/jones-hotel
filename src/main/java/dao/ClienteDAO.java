package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO {

    private final List<Cliente> clientes;

    public ClienteDAO() {
        clientes = BaseDeDados.getClientes();
    }

    public boolean incluir(Cliente cliente) {
        if (clientes.contains(cliente)) {
            return false;
        }
        return clientes.add(cliente);
    }

    public Cliente consultar(int id) throws NullPointerException {
        for (Cliente cli : clientes) {
            if (id == cli.getId()) {
                return cli;
            }
        }
        throw new NullPointerException();
    }

    public List<Cliente> consultarPorNome(String nome) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cli : clientes) {
            if (cli.getNome().toLowerCase().startsWith(nome)) {
                System.out.println(cli.getNome());
                System.out.println(nome);
                System.out.println(cli.getNome().toLowerCase().startsWith(nome));
                resultado.add(cli);
            }
        }
        if (resultado.isEmpty()) {
            throw new NullPointerException();
        }
        return resultado;
    }

    public boolean excluir(Cliente cliente) {
        if (clientes.contains(cliente)) {
            return clientes.remove(cliente);
        }

        return false;
    }

    public List<Cliente> listarTodos() throws NullPointerException {
        if (clientes.isEmpty()) {
            throw new NullPointerException("A base de clientes está vazia!");
        } else {
            return clientes;
        }
    }

}
