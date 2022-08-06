package controller;

import dao.ClienteDAO;
import dao.ClienteDao;
import dao.MunicipioDao;
import model.*;
import util.MensagemUtil;
import view.TelaCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    private final TelaCliente telaCliente;
    private final ClienteDao clienteDao;

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

        String logradouro = telaCliente.getTfdLogradouroResidencial().getText();
        String numero = telaCliente.getTfdNumeroResidencial().getText();
        String bairro = telaCliente.getTfdBairroResidencial().getText();
        String nomeMunicipio = (String) telaCliente.getCbxMunicipioResidencial().getSelectedItem();
        Municipio municipio = new MunicipioDao().consultar(nomeMunicipio);
        String complemento = telaCliente.getTfdComplementoResidencial().getText();
        String cep = telaCliente.getTfdCepResidencial().getText();

        Endereco enderecoResidencial = new Endereco(logradouro, numero, bairro, municipio, complemento, cep);

        String logradouroComercial = telaCliente.getTfdLogradouroComercial().getText();
        String numeroComercial = telaCliente.getTfdNumeroComercial().getText();
        String bairroComercial = telaCliente.getTfdBairroComercial().getText();
        String nomeMunicipioComercial = (String) telaCliente.getCbxMunicipioComercial().getSelectedItem();
        Municipio municipioComercial = new MunicipioDao().consultar(nomeMunicipioComercial);
        String complementoComercial = telaCliente.getTfdComplementoComercial().getText();
        String cepComercial = telaCliente.getTfdCepComercial().getText();

        Endereco enderecoComercial = new Endereco(logradouroComercial, numeroComercial, bairroComercial, municipioComercial, complementoComercial, cepComercial);

        boolean ePessoaFisica = telaCliente.getRbtPessoaFisica().isSelected();
        boolean ePessoaJuridica = telaCliente.getRbtPessoaJuridica().isSelected();

        if (ePessoaFisica) {
            PessoaFisica clientePf = new PessoaFisica(cpfCnpj, nome);
            clientePf.setTelefoneFixo(telefoneFixo);
            clientePf.setTelefoneCelular(telefoneCelular);
            clientePf.setTelefoneComercial(telefoneComercial);

            clientePf.setEnderecoResidencial(enderecoResidencial);
            clientePf.setEnderecoComercial(enderecoComercial);

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

            clientePj.setEnderecoResidencial(enderecoResidencial);
            clientePj.setEnderecoComercial(enderecoComercial);

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
                    telaCliente.getTfdLogradouroResidencial().setText(logradouro);
                    String numero = cliente.getEnderecoResidencial().getNumero();
                    telaCliente.getTfdNumeroResidencial().setText(numero);
                    String bairro = cliente.getEnderecoResidencial().getBairro();
                    telaCliente.getTfdBairroResidencial().setText(bairro);
                    String complemento = cliente.getEnderecoResidencial().getComplemento();
                    telaCliente.getTfdComplementoResidencial().setText(complemento);
                    String cep = cliente.getEnderecoResidencial().getCep();
                    telaCliente.getTfdCepResidencial().setText(cep);

                    Municipio municipioResidencial = cliente.getEnderecoResidencial().getMunicipio();
                    if (municipioResidencial != null) {
                        String municipio = municipioResidencial.getNome();
                        telaCliente.getCbxMunicipioResidencial().setSelectedItem(municipio);
                    }

                    String logradouroComercial = cliente.getEnderecoComercial().getLogradouro();
                    telaCliente.getTfdLogradouroComercial().setText(logradouroComercial);
                    String numeroComercial = cliente.getEnderecoComercial().getNumero();
                    telaCliente.getTfdNumeroComercial().setText(numeroComercial);
                    String bairroComercial = cliente.getEnderecoComercial().getBairro();
                    telaCliente.getTfdBairroComercial().setText(bairroComercial);
                    String complementoComercial = cliente.getEnderecoComercial().getComplemento();
                    telaCliente.getTfdComplementoComercial().setText(complementoComercial);
                    String cepComercial = cliente.getEnderecoComercial().getCep();
                    telaCliente.getTfdCepComercial().setText(cepComercial);

                    Municipio municipioComercial = cliente.getEnderecoComercial().getMunicipio();
                    if (municipioComercial != null) {
                        String municipio = municipioComercial.getNome();
                        telaCliente.getCbxMunicipioResidencial().setSelectedItem(municipio);
                    }

                    return true;
                } catch (NullPointerException e) {
                    MensagemUtil.addAviso(telaCliente, "Não foi encontrado nenhum registro com o ID informado!");
                    return false;
                }
            } catch (NumberFormatException e) {
                MensagemUtil.addAviso(telaCliente, "O ID deve ser um número!");
                return false;
            }
        }
    }

    public boolean alterar(String textoId) {

        if (camposEmBranco()) {
            MensagemUtil.addAviso(telaCliente, "Preencha todos os campos para alterar um cliente!");
            return false;
        } else {
            try {
                int id = Integer.parseInt(textoId);

                try {
                    Cliente cliente = clienteDao.consultar(id);

                    String nome = telaCliente.getTfdNome().getText();
                    String cpfCnpj = telaCliente.getTfdCpfCnpj().getText();
                    String telefoneFixo = telaCliente.getTfdTelFixo().getText();
                    String telefoneCelular = telaCliente.getTfdTelCelular().getText();
                    String telefoneComercial = telaCliente.getTfdTelComercial().getText();
                    String nomeFantasia = telaCliente.getTfdNomeFantasia().getText();

                    String logradouro = telaCliente.getTfdLogradouroResidencial().getText();
                    String numero = telaCliente.getTfdNumeroResidencial().getText();
                    String bairro = telaCliente.getTfdBairroResidencial().getText();
                    String nomeMunicipio = (String) telaCliente.getCbxMunicipioResidencial().getSelectedItem();
                    Municipio municipio = new MunicipioDao().consultar(nomeMunicipio);
                    String complemento = telaCliente.getTfdComplementoResidencial().getText();
                    String cep = telaCliente.getTfdCepResidencial().getText();

                    Endereco enderecoResidencial = new Endereco(logradouro, numero, bairro, municipio, complemento, cep);

                    String logradouroComercial = telaCliente.getTfdLogradouroComercial().getText();
                    String numeroComercial = telaCliente.getTfdNumeroComercial().getText();
                    String bairroComercial = telaCliente.getTfdBairroComercial().getText();
                    String nomeMunicipioComercial = (String) telaCliente.getCbxMunicipioComercial().getSelectedItem();
                    Municipio municipioComercial = new MunicipioDao().consultar(nomeMunicipioComercial);
                    String complementoComercial = telaCliente.getTfdComplementoComercial().getText();
                    String cepComercial = telaCliente.getTfdCepComercial().getText();

                    Endereco enderecoComercial = new Endereco(logradouroComercial, numeroComercial, bairroComercial, municipioComercial, complementoComercial, cepComercial);

                    boolean ePessoaFisica = telaCliente.getRbtPessoaFisica().isSelected();
                    boolean ePessoaJuridica = telaCliente.getRbtPessoaJuridica().isSelected();

                    if (ePessoaFisica) {
                        PessoaFisica clientePf = (PessoaFisica) cliente;
                        clientePf.setNome(nome);
                        clientePf.setCpf(cpfCnpj);
                        clientePf.setTelefoneFixo(telefoneFixo);
                        clientePf.setTelefoneCelular(telefoneCelular);
                        clientePf.setTelefoneComercial(telefoneComercial);

                        clientePf.setEnderecoResidencial(enderecoResidencial);
                        clientePf.setEnderecoComercial(enderecoComercial);

                        MensagemUtil.addInfo(telaCliente, "Cliente alterado com sucesso!");

                    } else if (ePessoaJuridica) {
                        PessoaJuridica clientePj = (PessoaJuridica) cliente;
                        clientePj.setNome(nome);
                        clientePj.setCnpj(cpfCnpj);
                        clientePj.setNomeFantasia(nomeFantasia);
                        clientePj.setTelefoneFixo(telefoneFixo);
                        clientePj.setTelefoneCelular(telefoneCelular);
                        clientePj.setTelefoneComercial(telefoneComercial);

                        clientePj.setEnderecoResidencial(enderecoResidencial);
                        clientePj.setEnderecoComercial(enderecoComercial);

                        MensagemUtil.addInfo(telaCliente, "Cliente alterado com sucesso!");

                        return true;
                    }
                } catch (NullPointerException e) {
                    MensagemUtil.addAviso(telaCliente, "Não foi encontrado nenhum registro com o ID informado!");
                    return false;
                }
            } catch (NumberFormatException e) {
                MensagemUtil.addAviso(telaCliente, "O ID deve ser um número!");
                return false;
            }
        }
        return false;
    }

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
            } catch (NullPointerException e) {
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
                    ((PessoaFisica) cli).getCpf(),
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
        List<Municipio> municipios = new MunicipioDao().listarTodos();
        List<String> nomesMunicipios = new ArrayList<>();

        for (Municipio m : municipios) {
            nomesMunicipios.add(m.getNome());
        }
        Object[] nomes = nomesMunicipios.toArray();

        telaCliente.getCbxMunicipioResidencial().setModel(new DefaultComboBoxModel(nomes));
        telaCliente.getCbxMunicipioComercial().setModel(new DefaultComboBoxModel(nomes));
    }
}
