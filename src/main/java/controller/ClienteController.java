package controller;

import dao.ClienteDAO;
import java.awt.Component;
import java.util.NoSuchElementException;
import javax.swing.JTextField;
import model.Cliente;
import util.MensagemUtil;
import view.TelaCliente;

public class ClienteController {
    
    private Cliente cliente;
    private final TelaCliente telaCliente;
    private final ClienteDAO clienteDao;

    public ClienteController(TelaCliente telaCliente) {
        this.telaCliente = telaCliente;
        clienteDao = new ClienteDAO();
    }

    public boolean incluir() {
        
        if(camposEmBranco()){
            MensagemUtil.addAviso(telaCliente, "Preencha todos os campos para cadastrar um cliente!");
            return false;
        }
        
        String cpf = telaCliente.getTfdCpf();
        String nome = telaCliente.getTfdNome();
        String identidade = telaCliente.getTfdIdentidade();
        String salario = telaCliente.getTfdSalario();

        try {
            float salarioFloat = Float.parseFloat(salario);

            cliente = new Cliente(cpf, nome, salarioFloat, identidade);
            System.out.println("Incluir - Controller: " + cliente);

            if (clienteDao.incluir(cliente)) {
                MensagemUtil.addInfo(telaCliente, "Funcionário cadastrado com sucesso!");
                return true;
            } else {
                MensagemUtil.addAviso(telaCliente, "Já existe um funcionário com o CPF informado!");
            }
            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            MensagemUtil.addErro(telaCliente, "O campo de salário deve conter apenas números");
        }
        return false;
    }

    public boolean consultar(String cpfBuscado) {

        if("".equals(cpfBuscado) || cpfBuscado == null){
            MensagemUtil.addAviso(telaCliente, "Por favor, informe um CPF para realizar a busca!");
            return false;
        }

        try {
            cliente = clienteDao.consultar(cpfBuscado);

            telaCliente.setTfdCpf(cliente.getCpf());
            telaCliente.setTfdNome(cliente.getNome());
            telaCliente.setTfdIdentidade(cliente.getIdentidade());
            float salario = cliente.getSalario();
            telaCliente.setTfdSalario(String.valueOf(salario));
            
            System.out.println(cliente);
        } catch (NoSuchElementException e) {
            MensagemUtil.addAviso(telaCliente, "Não foi encontrado funcionário com o CPF informado!");
            return false;
        }
        return true;
    }
    
    public boolean alterar(){
        
        if(camposEmBranco()){
            MensagemUtil.addAviso(telaCliente, "Preencha todos os campos para alterar um cliente!");
            return false;
        }
        
        try {
            String cpf = telaCliente.getTfdCpf();
            String nome = telaCliente.getTfdNome();
            String identidade = telaCliente.getTfdIdentidade();
            String salario = telaCliente.getTfdSalario();
            
            try {
                float salarioFloat = Float.parseFloat(salario);
                
                cliente = new Cliente(cpf, nome, salarioFloat, identidade);
                
                cliente.setNome(nome);
                cliente.setIdentidade(identidade);
                cliente.setSalario(salarioFloat);
                
                clienteDao.alterar(cliente);
                
                return true;
                
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                MensagemUtil.addErro(telaCliente, "O campo de salário deve conter apenas números");
            }
            
        } catch (NoSuchElementException e){
            MensagemUtil.addAviso(telaCliente, "Não foi encontrado funcionário com o CPF informado!");
        }
        return false;
    }
    
    private boolean camposEmBranco(){
        for (Component c : telaCliente.getPanel().getComponents()) {
            if (c instanceof JTextField) {
                if (((JTextField) c).getText().isBlank()) {
                    return true;
                }
            }
        }
        return false;
    }
}
