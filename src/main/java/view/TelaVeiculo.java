package view;

import controller.VeiculoController;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaVeiculo extends javax.swing.JInternalFrame {

    private final VeiculoController veiculoController;

    public TelaVeiculo() {
        initComponents();

        DefaultTableModel tabelaVeiculos = (DefaultTableModel) tableVeiculos.getModel();
        tabelaVeiculos.setRowCount(0);

        veiculoController = new VeiculoController(this);
    }

    private void alterarEstadoBotoes(boolean incluir, boolean consultar, boolean alterar, boolean excluir) {
        btnIncluir.setEnabled(incluir);
        btnConsultar.setEnabled(consultar);
        btnExcluir.setEnabled(excluir);
        btnAlterar.setEnabled(alterar);
    }

    private void estadoTelaInclusao(boolean inclusao) {
        tfdId.setEnabled(!inclusao);

        tfdMarca.setEnabled(inclusao);
        tfdModelo.setEnabled(inclusao);
        tfdPlaca.setEnabled(inclusao);
//        tfdCor.setEnabled(inclusao);
        tfdVagaOcupada.setEnabled(inclusao);
    }

    private void limparCampos() {
        tfdId.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVeiculo = new javax.swing.JPanel();
        tfdMarca = new javax.swing.JTextField();
        tfdModelo = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();
        tfdId = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        lblVagaOcupada = new javax.swing.JLabel();
        tfdPlaca = new javax.swing.JTextField();
        tfdVagaOcupada = new javax.swing.JTextField();
        cbxCor = new javax.swing.JComboBox<>();
        lblCamposObrigatorios = new javax.swing.JLabel();
        panelCliente = new javax.swing.JPanel();
        lblIdCliente = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        lblCpfCnpj = new javax.swing.JLabel();
        tfdIdCliente = new javax.swing.JTextField();
        tfdNomeCliente = new javax.swing.JTextField();
        tfdCpfCnpj = new javax.swing.JTextField();
        btnSelecionarCliente = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Gravar alterações");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblId.setText("ID do veículo");
        lblId.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblMarca.setText("* Marca");
        lblMarca.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblModelo.setText("* Modelo");
        lblModelo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblCor.setText("* Cor");
        lblCor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Modelo", "Placa", "Vaga Ocupada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVeiculos);

        lblPlaca.setText("* Placa");

        lblVagaOcupada.setText("Vaga Ocupada");

        cbxCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarelo", "Azul", "Branco", "Ciano", "Cinza", "Cinza Claro", "Cinza Escuro", "Laranja", "Magenta", "Preto", "Rosa", "Verde", "Vermelho" }));

        lblCamposObrigatorios.setText("* Campos obrigatórios");

        panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        lblIdCliente.setText("ID do Cliente");

        lblNomeCliente.setText("Nome do Cliente");

        lblCpfCnpj.setText("CPF/CNPJ");

        btnSelecionarCliente.setText("Selecionar Cliente");
        btnSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdCliente)
                    .addComponent(lblNomeCliente))
                .addGap(33, 33, 33)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addComponent(tfdNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnSelecionarCliente))
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addComponent(tfdIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(lblCpfCnpj)
                        .addGap(33, 33, 33)
                        .addComponent(tfdCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCpfCnpj)
                        .addComponent(tfdCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdCliente)
                        .addComponent(tfdIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(tfdNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNovo.setText("Novo");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout panelVeiculoLayout = new javax.swing.GroupLayout(panelVeiculo);
        panelVeiculo.setLayout(panelVeiculoLayout);
        panelVeiculoLayout.setHorizontalGroup(
            panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVeiculoLayout.createSequentialGroup()
                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVeiculoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVeiculoLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelVeiculoLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1))
                            .addGroup(panelVeiculoLayout.createSequentialGroup()
                                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAlterar)
                                    .addGroup(panelVeiculoLayout.createSequentialGroup()
                                        .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblId)
                                            .addComponent(lblMarca)
                                            .addComponent(lblModelo)
                                            .addComponent(lblCor))
                                        .addGap(26, 26, 26)
                                        .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbxCor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tfdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelVeiculoLayout.createSequentialGroup()
                                                .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnConsultar))
                                            .addComponent(tfdModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelVeiculoLayout.createSequentialGroup()
                                        .addGap(132, 132, 132)
                                        .addComponent(lblCamposObrigatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelVeiculoLayout.createSequentialGroup()
                                        .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelVeiculoLayout.createSequentialGroup()
                                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(6, 6, 6))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVeiculoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVeiculoLayout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(panelVeiculoLayout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(tfdPlaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVeiculoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblVagaOcupada)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfdVagaOcupada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(51, 51, 51)))
                .addGap(96, 96, 96))
        );
        panelVeiculoLayout.setVerticalGroup(
            panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(btnNovo))
                .addGap(18, 18, 18)
                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(tfdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdVagaOcupada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVagaOcupada))
                .addGap(18, 18, 18)
                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(tfdModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlaca))
                .addGap(18, 18, 18)
                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor)
                    .addComponent(cbxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCamposObrigatorios))
                .addGap(41, 41, 41)
                .addGroup(panelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
//        veiculoController.consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
//        veiculoController.incluir();
//        veiculoController.atualizarTabela();
        limparCampos();
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
//        veiculoController.alterar();
//        veiculoController.atualizarTabela();
        limparCampos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        veiculoController.excluir();
//        veiculoController.atualizarTabela();
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVeiculosMouseClicked
        if (evt.getClickCount() == 2) {

            Integer id = (Integer) tableVeiculos.getModel().getValueAt(tableVeiculos.getSelectedRow(), 0);
            String nome = (String) tableVeiculos.getModel().getValueAt(tableVeiculos.getSelectedRow(), 1);
            String modelo = (String) tableVeiculos.getModel().getValueAt(tableVeiculos.getSelectedRow(), 2);
            String placa = (String) tableVeiculos.getModel().getValueAt(tableVeiculos.getSelectedRow(), 3);

            tfdId.setText(String.valueOf(id));
            tfdMarca.setText(nome);
            tfdModelo.setText(modelo);
            tfdPlaca.setText(placa);
        }
    }//GEN-LAST:event_tableVeiculosMouseClicked

    private void btnSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarClienteActionPerformed
        TelaConsultaCliente telaConsultaCliente = new TelaConsultaCliente(this);
        TelaConsultaCliente telaTeste = new TelaConsultaCliente(this);
        telaTeste.setVisible(true);
//        JDesktopPane desktopPane = getDesktopPane();
//        desktopPane.add(telaConsultaCliente);
//        System.out.println(telaConsultaCliente);
//        telaConsultaCliente.setVisible(true);
////        this.setVisible(false);
//        this.dispose();
    }//GEN-LAST:event_btnSelecionarClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSelecionarCliente;
    private javax.swing.JComboBox<String> cbxCor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCamposObrigatorios;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblCpfCnpj;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblVagaOcupada;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelVeiculo;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JTextField tfdCpfCnpj;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdIdCliente;
    private javax.swing.JTextField tfdMarca;
    private javax.swing.JTextField tfdModelo;
    private javax.swing.JTextField tfdNomeCliente;
    private javax.swing.JTextField tfdPlaca;
    private javax.swing.JTextField tfdVagaOcupada;
    // End of variables declaration//GEN-END:variables

    public String getTfdMarca() {
        return tfdMarca.getText();
    }

    public void setTfdMarca(String estado) {
        this.tfdMarca.setText(estado);
    }

    public String getTfdId() {
        return tfdId.getText();
    }

    public void setTfdId(String id) {
        this.tfdId.setText(id);
    }

    public String getTfdModelo() {
        return tfdModelo.getText();
    }

    public void setTfdModelo(String modelo) {
        this.tfdModelo.setText(modelo);
    }

    public String getTfdPlaca() {
        return tfdPlaca.getText();
    }

    public void setTfdPlaca(String placa) {
        this.tfdPlaca.setText(placa);
    }

    public String getTfdVagaOcupada() {
        return tfdVagaOcupada.getText();
    }

    public void setTfdVagaOcupada(String placa) {
        this.tfdVagaOcupada.setText(placa);
    }

    public JComboBox<String> getCbxCor() {
        return cbxCor;
    }

    public void setCbxCor(JComboBox<String> cbxCor) {
        this.cbxCor = cbxCor;
    }

    public JTextField getTfdCpfCnpj() {
        return tfdCpfCnpj;
    }

    public JTextField getTfdIdCliente() {
        return tfdIdCliente;
    }

    public JTextField getTfdNomeCliente() {
        return tfdNomeCliente;
    }

    
}
