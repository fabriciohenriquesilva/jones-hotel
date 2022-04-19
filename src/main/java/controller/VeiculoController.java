package controller;

import dao.VeiculoDAO;
import java.awt.Color;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import util.MensagemUtil;
import view.TelaVeiculo;

public class VeiculoController {
//    

    private TelaVeiculo telaVeiculo;
    private VeiculoDAO veiculoDao;
    private Veiculo veiculo;
//

    public VeiculoController() {
//        this.telaVeiculo = telaVeiculo;
//        this.veiculoDao = new VeiculoDAO();
    }
//
//    public boolean incluir() {
//
//        if (camposEmBranco()) {
//            MensagemUtil.addAviso(telaVeiculo, "Preencha todos os campos para incluir um novo registro!");
//            return false;
//        }
//
//        String marca = telaVeiculo.getTfdMarca();
//        String modelo = telaVeiculo.getTfdModelo();
////        String cor = telaVeiculo.getTfdCor();
//        String placa = telaVeiculo.getTfdPlaca();
//        String vagaOcupada = telaVeiculo.getTfdVagaOcupada();
//
//        Veiculo veiculo = new Veiculo(marca, modelo, Color.BLACK, placa, vagaOcupada);
//        
//        
//        return veiculoDao.incluir(veiculo);
//    }
//

    public boolean consultar(String idVeiculo) {
        try {
            int id = Integer.parseInt(idVeiculo);

            try {
                this.veiculo = veiculoDao.consultar(id);

                // E se eu quisesse utilizar essas informações para outra tela?
                // Soluções:
                // 1 - Passar como argumento o JInternalFrame e fazer parse (um para cada tela)
                // 2 - Devolver os dados por meio de um Objeto
                // 3 - Criar um atributo model no controller e recuperar os dados através dele
                // na view
                // 4 - 
                return true;
            } catch (NoSuchElementException e) {
                MensagemUtil.addAviso(telaVeiculo, "Não foi encontrado nenhum registro com o ID informado!");
            }
        } catch (NumberFormatException e) {
            MensagemUtil.addErro(telaVeiculo, "O ID deve ser um número!");
        }

        return false;
    }
//
//    public boolean alterar() {
//        String textoId = telaVeiculo.getTfdId();
//        
//        if(textoId.isEmpty()){
//            MensagemUtil.addAviso(telaVeiculo, "Não existe nenhum registro selecionado para exclusão!");
//            return false;
//        }
//        
//        if (camposEmBranco()) {
//            MensagemUtil.addAviso(telaVeiculo, "Preencha todos os campos para alterar o registro!");
//            return false;
//        }
//
//        String nome = telaVeiculo.getTfdNome();
//        String estado = telaVeiculo.getTfdEstado();
//        String pais = telaVeiculo.getTfdPais();
//        
//        int id = Integer.parseInt(textoId);
//        
//        try {
//            Veiculo veiculo = veiculoDao.consultar(id);
//
//            veiculo.setNome(nome);
//            veiculo.setEstado(estado);
//            veiculo.setPais(pais);
//
//            return true;
//        } catch (NoSuchElementException e) {
//            MensagemUtil.addAviso(telaVeiculo, "Não foi encontrado nenhum registro com o ID informado!");
//        }
//        return false;
//    }
//
//    public boolean excluir() {
//        
//        if (camposEmBranco()) {
//            MensagemUtil.addAviso(telaVeiculo, "Não existe nenhum registro selecionado para exclusão!");
//            return false;
//        }
//        
//        String textoId = telaVeiculo.getTfdId();
//        int id = Integer.parseInt(textoId);
//        
//        try {
//            Veiculo veiculo = veiculoDao.consultar(id);
//            return veiculoDao.excluir(veiculo);
//        } catch (NoSuchElementException e) {
//            MensagemUtil.addAviso(telaVeiculo, "Não foi encontrado nenhum registro com o ID informado!");
//        }
//
//        return false;
//    }
//
//    public void atualizarTabela() {
//        List<Veiculo> veiculos = veiculoDao.listarTodos();
//
//        DefaultTableModel tabelaVeiculos = (DefaultTableModel) telaVeiculo.getTableVeiculos().getModel();
//        tabelaVeiculos.setRowCount(0);
//
//        veiculos.forEach((Veiculo muni) -> {
//            tabelaVeiculos.addRow(new Object[]{
//                muni.getId(),
//                muni.getNome(),
//                muni.getEstado(),
//                muni.getPais()
//            });
//        });
//    }
//
//    private boolean camposEmBranco() {
//        String nome = telaVeiculo.getTfdNome();
//        String estado = telaVeiculo.getTfdEstado();
//        String pais = telaVeiculo.getTfdPais();
//        
//        return nome.isEmpty() || estado.isEmpty() || pais.isEmpty();
//    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

}
