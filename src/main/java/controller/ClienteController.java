package controller;

import dao.ClienteDAO;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.MensagemUtil;
import view.TelaCliente;

public class ClienteController {

    private final TelaCliente telaCliente;
    private final ClienteDAO clienteDao;

    public ClienteController(TelaCliente telaCliente) {
        this.telaCliente = telaCliente;
        clienteDao = new ClienteDAO();
    }

    public boolean incluir() {

        if (camposEmBranco()) {
            MensagemUtil.addAviso(telaCliente, "Preencha todos os campos para cadastrar um cliente!");
            return false;
        }

        String nome = telaCliente.getTfdNome().getText();
        String cpfCnpj = telaCliente.getTfdCpfCnpj().getText();
        String telefoneFixo = telaCliente.getTfdTelFixo().getText();
        String telefoneCelular = telaCliente.getTfdTelCelular().getText();
        String telefoneComercial = telaCliente.getTfdTelComercial().getText();

        boolean ePessoaFisica = telaCliente.getRbtPessoaFisica().isSelected();
        boolean ePessoaJuridica = telaCliente.getRbtPessoaJuridica().isSelected();

        if (ePessoaFisica) {
            Cliente clientePf = new PessoaFisica(cpfCnpj, nome);
            clientePf.setTelefoneFixo(telefoneFixo);
            clientePf.setTelefoneCelular(telefoneCelular);
            clientePf.setTelefoneComercial(telefoneComercial);
            
            if (clienteDao.incluir(clientePf)) {
                MensagemUtil.addInfo(telaCliente, "Cliente cadastrado com sucesso!");
                return true;
            }

        } else if (ePessoaJuridica) {
            Cliente clientePj = new PessoaFisica(cpfCnpj, nome);
            clientePj.setTelefoneFixo(telefoneFixo);
            clientePj.setTelefoneCelular(telefoneCelular);
            clientePj.setTelefoneComercial(telefoneComercial);
            
            if (clienteDao.incluir(clientePj)) {
                MensagemUtil.addInfo(telaCliente, "Cliente cadastrado com sucesso!");
                return true;
            }
        }
        return false;
    }

    public boolean consultar() {
        String textoId = telaCliente.getTfdId().getText();
        if (textoId.isEmpty()) {
            MensagemUtil.addAviso(telaCliente, "Por favor, informe um ID para realizar a busca!");
            return false;
        } else {
            try {
                int id = Integer.parseInt(textoId);

                try {
                    Cliente cliente = clienteDao.consultar(id);
                    
                    if(cliente instanceof PessoaJuridica){
                        telaCliente.getTfdCpfCnpj().setText(((PessoaJuridica) cliente).getCnpj());
                    }
                    if(cliente instanceof PessoaFisica){
                        telaCliente.getTfdCpfCnpj().setText(((PessoaFisica) cliente).getCpf());
                    }
                    
                    telaCliente.getTfdNome().setText(cliente.getNome());
                    telaCliente.getTfdTelFixo().setText(cliente.getTelefoneFixo());
                    telaCliente.getTfdTelCelular().setText(cliente.getTelefoneCelular());
                    telaCliente.getTfdTelComercial().setText(cliente.getTelefoneComercial());
                    
                } catch (NoSuchElementException e) {
                    MensagemUtil.addAviso(telaCliente, "Não foi encontrado nenhum registro com o ID informado!");
                    return false;
                }
            } catch (NumberFormatException e) {
                MensagemUtil.addAviso(telaCliente, "O ID deve ser um número!");
                return false;
            }
            return true;
        }
    }

//    public boolean alterar() {
//
//        if (camposEmBranco()) {
//            MensagemUtil.addAviso(telaCliente, "Preencha todos os campos para alterar um cliente!");
//            return false;
//        }
//
//        try {
//            String cpf = telaCliente.getTfdCpf();
//            String nome = telaCliente.getTfdNome();
//            String identidade = telaCliente.getTfdIdentidade();
//            String salario = telaCliente.getTfdSalario();
//
//            try {
//                float salarioFloat = Float.parseFloat(salario);
//
//                cliente = new Cliente(cpf, nome, salarioFloat, identidade);
//
//                cliente.setNome(nome);
//                cliente.setIdentidade(identidade);
//                cliente.setSalario(salarioFloat);
//
//                clienteDao.alterar(cliente);
//
//                return true;
//
//            } catch (NumberFormatException e) {
//                System.out.println(e.getMessage());
//                MensagemUtil.addErro(telaCliente, "O campo de salário deve conter apenas números");
//            }
//
//        } catch (NoSuchElementException e) {
//            MensagemUtil.addAviso(telaCliente, "Não foi encontrado funcionário com o CPF informado!");
//        }
//        return false;
//    }
    
    public boolean excluir() {
        
        if (camposEmBranco()) {
            MensagemUtil.addAviso(telaCliente, "Não existe nenhum registro selecionado para exclusão!");
            return false;
        }
        
        String textoId = telaCliente.getTfdId();
        
        try {
            int id = Integer.parseInt(textoId);
            
            try {
                Cliente cliente = clienteDao.consultar(id);
                return clienteDao.excluir(cliente);
            } catch (NoSuchElementException e) {
                MensagemUtil.addAviso(telaCliente, "Não foi encontrado nenhum registro com o ID informado!");
            }
        } catch (NumberFormatException e){
            MensagemUtil.addAviso(telaCliente, "O ID deve ser um número!");
            return false;
        }
        return false;
    }
    
    public void atualizarTabela() {
        List<Cliente> municipios = clienteDao.listarTodos();

        DefaultTableModel tabelaMunicipios = (DefaultTableModel) telaCliente.getTableClientes().getModel();
        tabelaMunicipios.setRowCount(0);

        municipios.forEach((Cliente cli) -> {
            tabelaMunicipios.addRow(new Object[]{
                cli.getId(),
                cli.getNome(),
                cli.getCpf(),
                "Teste"
            });
        });
    }

    private boolean camposEmBranco() {
        String nome = telaCliente.getTfdNome().getText();
        String cpfCnpj = telaCliente.getTfdCpfCnpj().getText();
        
        return nome.isEmpty() || cpfCnpj.isEmpty();
    }
}
