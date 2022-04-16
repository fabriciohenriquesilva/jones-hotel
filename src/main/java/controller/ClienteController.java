package controller;

import dao.ClienteDAO;
import dao.MunicipioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Endereco;
import model.Municipio;
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
        String nomeFantasia = telaCliente.getTfdNomeFantasia().getText();

        String logradouro = telaCliente.getTfdLogradouro().getText();
        String numero = telaCliente.getTfdNumero().getText();
        String bairro = telaCliente.getTfdBairro().getText();

        String nomeMunicipio = (String) telaCliente.getCbxMunicipio().getSelectedItem();
        Municipio municipio = new MunicipioDAO().consultar(nomeMunicipio);

        String complemento = telaCliente.getTfdComplemento().getText();
        String cep = telaCliente.getTfdCep().getText();

        Endereco endereco = new Endereco(logradouro, numero, bairro, municipio, complemento, cep);

        boolean ePessoaFisica = telaCliente.getRbtPessoaFisica().isSelected();
        boolean ePessoaJuridica = telaCliente.getRbtPessoaJuridica().isSelected();

        if (ePessoaFisica) {
            PessoaFisica clientePf = new PessoaFisica(cpfCnpj, nome);
            clientePf.setTelefoneFixo(telefoneFixo);
            clientePf.setTelefoneCelular(telefoneCelular);
            clientePf.setTelefoneComercial(telefoneComercial);

            clientePf.setEnderecoResidencial(endereco);

            if (clienteDao.incluir(clientePf)) {
                MensagemUtil.addInfo(telaCliente, "Cliente cadastrado com sucesso!");
                return true;
            }

        } else if (ePessoaJuridica) {
            PessoaJuridica clientePj = new PessoaJuridica(cpfCnpj, nome);
            clientePj.setNomeFantasia(nomeFantasia);
            clientePj.setTelefoneFixo(telefoneFixo);
            clientePj.setTelefoneCelular(telefoneCelular);
            clientePj.setTelefoneComercial(telefoneComercial);

            clientePj.setEnderecoResidencial(endereco);

            if (clienteDao.incluir(clientePj)) {
                MensagemUtil.addInfo(telaCliente, "Cliente cadastrado com sucesso!");
                return true;
            }
        }
        return false;
    }

    public boolean consultar(String textoId) {
        if (textoId.isEmpty()) {
            MensagemUtil.addAviso(telaCliente, "Por favor, informe um ID para realizar a busca!");
            return false;
        } else {
            try {
                int id = Integer.parseInt(textoId);

                try {
                    Cliente cliente = clienteDao.consultar(id);

                    if (cliente instanceof PessoaJuridica) {
                        telaCliente.getTfdCpfCnpj().setText(((PessoaJuridica) cliente).getCnpj());
                        telaCliente.getTfdNomeFantasia().setText(((PessoaJuridica) cliente).getNomeFantasia());
                    }
                    if (cliente instanceof PessoaFisica) {
                        telaCliente.getTfdCpfCnpj().setText(((PessoaFisica) cliente).getCpf());
                    }

                    telaCliente.getTfdNome().setText(cliente.getNome());
                    telaCliente.getTfdTelFixo().setText(cliente.getTelefoneFixo());
                    telaCliente.getTfdTelCelular().setText(cliente.getTelefoneCelular());
                    telaCliente.getTfdTelComercial().setText(cliente.getTelefoneComercial());

                    String logradouro = cliente.getEnderecoResidencial().getLogradouro();
                    telaCliente.getTfdLogradouro().setText(logradouro);
                    String numero = cliente.getEnderecoResidencial().getNumero();
                    telaCliente.getTfdNumero().setText(numero);
                    String bairro = cliente.getEnderecoResidencial().getBairro();
                    telaCliente.getTfdBairro().setText(bairro);
                    String municipio = cliente.getEnderecoResidencial().getMunicipio().getNome();
                    telaCliente.getCbxMunicipio().setSelectedItem(municipio);
                    String complemento = cliente.getEnderecoResidencial().getComplemento();
                    telaCliente.getTfdComplemento().setText(complemento);
                    String cep = cliente.getEnderecoResidencial().getCep();
                    telaCliente.getTfdCep().setText(cep);

                    return true;
                } catch (NoSuchElementException e) {
                    MensagemUtil.addAviso(telaCliente, "Não foi encontrado nenhum registro com o ID informado!");
                    return false;
                }
            } catch (NumberFormatException e) {
                MensagemUtil.addAviso(telaCliente, "O ID deve ser um número!");
                return false;
            }
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

        String textoId = telaCliente.getTfdId().getText();

        try {
            int id = Integer.parseInt(textoId);

            try {
                Cliente cliente = clienteDao.consultar(id);
                return clienteDao.excluir(cliente);
            } catch (NoSuchElementException e) {
                MensagemUtil.addAviso(telaCliente, "Não foi encontrado nenhum registro com o ID informado!");
            }
        } catch (NumberFormatException e) {
            MensagemUtil.addAviso(telaCliente, "O ID deve ser um número!");
            return false;
        }
        return false;
    }

    public void atualizarTabela() {
        List<Cliente> clientes = clienteDao.listarTodos();

        DefaultTableModel tabelaClientes = (DefaultTableModel) telaCliente.getTableClientes().getModel();
        tabelaClientes.setRowCount(0);

        for (Cliente cli : clientes) {
            if (cli instanceof PessoaFisica) {
                tabelaClientes.addRow(new Object[]{
                    cli.getId(),
                    cli.getNome(),
                    cli.getCpf(),
                    "Pessoa Física"});
            }
            if (cli instanceof PessoaJuridica) {
                tabelaClientes.addRow(new Object[]{
                    cli.getId(),
                    cli.getNome(),
                    ((PessoaJuridica) cli).getCnpj(),
                    "Pessoa Jurídica"});
            }
        }
    }

    private boolean camposEmBranco() {
        String nome = telaCliente.getTfdNome().getText();
        String cpfCnpj = telaCliente.getTfdCpfCnpj().getText();
        boolean pfSelecionado = telaCliente.getRbtPessoaFisica().isSelected();
        boolean pjSelecionado = telaCliente.getRbtPessoaJuridica().isSelected();

        return nome.isEmpty() || cpfCnpj.isEmpty() || (!pfSelecionado && !pjSelecionado);
    }

    public void atualizarMunicipios() {
        List<Municipio> municipios = new MunicipioDAO().listarTodos();
        List<String> nomesMunicipios = new ArrayList<>();

        for (Municipio m : municipios) {
            nomesMunicipios.add(m.getNome());
        }
        Object[] nomes = nomesMunicipios.toArray();

        telaCliente.getCbxMunicipio().setModel(new DefaultComboBoxModel(nomes));
    }
}
