package controller;

import dao.MunicipioDAO;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.table.DefaultTableModel;
import model.Municipio;
import util.MensagemUtil;
import view.TelaMunicipio;

public class MunicipioController {

    private final TelaMunicipio telaMunicipio;
    private final MunicipioDAO municipioDao;

    public MunicipioController(TelaMunicipio telaMunicipio) {
        this.telaMunicipio = telaMunicipio;
        this.municipioDao = new MunicipioDAO();
    }

    public boolean incluir() {

        if (camposEmBranco()) {
            MensagemUtil.addAviso(telaMunicipio, "Preencha todos os campos para incluir um novo registro!");
            return false;
        }

        String nome = telaMunicipio.getTfdNome();
        String estado = telaMunicipio.getTfdEstado();
        String pais = telaMunicipio.getTfdPais();

        Municipio municipio = new Municipio(nome, estado, pais);
        return municipioDao.incluir(municipio);
    }

    public boolean consultar() {
        String textoId = telaMunicipio.getTfdId();
        if (textoId.isEmpty()) {
            MensagemUtil.addAviso(telaMunicipio, "Por favor, informe um ID para realizar a busca!");
            return false;
        } else {
            try {
                int id = Integer.parseInt(textoId);

                try {
                    Municipio municipio = municipioDao.consultar(id);

                    telaMunicipio.setTfdId(String.valueOf(municipio.getId()));
                    telaMunicipio.setTfdNome(municipio.getNome());
                    telaMunicipio.setTfdEstado(municipio.getEstado());
                    telaMunicipio.setTfdPais(municipio.getPais());

                    return true;
                } catch (NoSuchElementException e) {
                    MensagemUtil.addAviso(telaMunicipio, "Não foi encontrado nenhum registro com o ID informado!");
                }
            } catch (NumberFormatException e) {
                MensagemUtil.addErro(telaMunicipio, "O ID deve ser um número!");
            }
        }
        return false;
    }

    public boolean alterar() {
        String textoId = telaMunicipio.getTfdId();
        
        if(textoId.isEmpty()){
            MensagemUtil.addAviso(telaMunicipio, "Não existe nenhum registro selecionado para exclusão!");
            return false;
        }
        
        if (camposEmBranco()) {
            MensagemUtil.addAviso(telaMunicipio, "Preencha todos os campos para alterar o registro!");
            return false;
        }

        String nome = telaMunicipio.getTfdNome();
        String estado = telaMunicipio.getTfdEstado();
        String pais = telaMunicipio.getTfdPais();
        
        int id = Integer.parseInt(textoId);
        
        try {
            Municipio municipio = municipioDao.consultar(id);

            municipio.setNome(nome);
            municipio.setEstado(estado);
            municipio.setPais(pais);

            return true;
        } catch (NoSuchElementException e) {
            MensagemUtil.addAviso(telaMunicipio, "Não foi encontrado nenhum registro com o ID informado!");
        }
        return false;
    }

    public boolean excluir() {
        
        if (camposEmBranco()) {
            MensagemUtil.addAviso(telaMunicipio, "Não existe nenhum registro selecionado para exclusão!");
            return false;
        }
        
        String textoId = telaMunicipio.getTfdId();
        int id = Integer.parseInt(textoId);
        
        try {
            Municipio municipio = municipioDao.consultar(id);
            return municipioDao.excluir(municipio);
        } catch (NoSuchElementException e) {
            MensagemUtil.addAviso(telaMunicipio, "Não foi encontrado nenhum registro com o ID informado!");
        }

        return false;
    }

    public void atualizarTabela() {
        List<Municipio> municipios = municipioDao.listarTodos();

        DefaultTableModel tabelaMunicipios = (DefaultTableModel) telaMunicipio.getTableMunicipios().getModel();
        tabelaMunicipios.setRowCount(0);

        municipios.forEach((Municipio muni) -> {
            tabelaMunicipios.addRow(new Object[]{
                muni.getId(),
                muni.getNome(),
                muni.getEstado(),
                muni.getPais()
            });
        });
    }

    private boolean camposEmBranco() {
        String nome = telaMunicipio.getTfdNome();
        String estado = telaMunicipio.getTfdEstado();
        String pais = telaMunicipio.getTfdPais();
        
        return nome.isEmpty() || estado.isEmpty() || pais.isEmpty();
    }
}
