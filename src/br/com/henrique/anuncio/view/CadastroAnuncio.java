package br.com.henrique.anuncio.view;

import br.com.henrique.anuncio.dao.Dao;
import br.com.henrique.anuncio.model.Anuncio;
import java.awt.Color;
import java.sql.*;
import java.time.LocalDate;
import net.proteanit.sql.DbUtils;

public class CadastroAnuncio extends javax.swing.JFrame {

    static Anuncio anuncio = new Anuncio();
    static Connection conexao = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    
    /***
     * <h1>Inserir os dados no banco.</h1>
     * 
     * <p>Insere os dados do {@link Anuncio} no banco de dados</p>
     * @author Henrique
     */
    public static void inserirDados() {
        String sql = "insert into anuncios (nome, cliente, data_inicio, data_fim, investimento_dia)"
            + " values ('" + anuncio.getNome() + "', '" + anuncio.getCliente() + "', '"
            + anuncio.getDataInicio().toString() + "', '"
            + anuncio.getDataFim().toString() + "', "
            + anuncio.getInvestimentoDia() + ")";
        try {
            pst = conexao.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /***
     * <h1>Pesquisar os dados no banco.</h1>
     * 
     * <p>Pesquisa todos os dados do {@link Anuncio} no banco de dados</p>
     * @author Henrique
     */
    public static void procurarDados() {
        String sql = "select nome 'Nome', cliente 'Cliente', data_inicio 'Data Início', data_fim 'Data Fim', investimento_dia 'Valor Investimento' from anuncios";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            tblAnuncios.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public CadastroAnuncio() {
        initComponents();
        conexao = Dao.conector();
        procurarDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCadastroAnuncio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnuncios = new javax.swing.JTable();
        txtNome = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataFim = new javax.swing.JFormattedTextField();
        txtInvestimentoDia = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        lblMensagemErro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Anúncio");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblCadastroAnuncio.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        lblCadastroAnuncio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastroAnuncio.setText("Cadastro de Anúncios");

        tblAnuncios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAnuncios);

        txtNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 215, 96), 3, true), "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 18))); // NOI18N

        txtCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 215, 96), 3, true), "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 18))); // NOI18N

        txtDataInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 215, 96), 3, true), "Data de Início", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 18))); // NOI18N
        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtDataFim.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 215, 96), 3, true), "Data de Fim", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 18))); // NOI18N
        try {
            txtDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtInvestimentoDia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtInvestimentoDia.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 215, 96), 3, true), "Valor R$", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 18))); // NOI18N

        btnCadastrar.setBackground(new java.awt.Color(30, 215, 96));
        btnCadastrar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 215, 96), 2, true));
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setFocusable(false);
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseExited(evt);
            }
        });
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblMensagemErro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMensagemErro.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInvestimentoDia)
                    .addComponent(txtNome)
                    .addComponent(txtCliente)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataFim))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMensagemErro, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(lblCadastroAnuncio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblCadastroAnuncio)
                .addGap(44, 44, 44)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(txtDataFim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInvestimentoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(lblMensagemErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//-------------------------------Btn cadastrar----------------------------------
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Integer diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim;
        Boolean verificaDataInicio = false, verificaDataFim = false;

        if (txtNome.getText().isEmpty()) {
            lblMensagemErro.setText("Campos ou datas inválidas.");
        } else {
            anuncio.setNome(txtNome.getText());
            lblMensagemErro.setText("");
        }

        if (txtCliente.getText().isEmpty()) {
            lblMensagemErro.setText("Campos ou datas inválidas.");
        } else {
            anuncio.setCliente(txtCliente.getText());
            lblMensagemErro.setText("");
        }
        
        if (txtDataInicio.getText().isEmpty()) {
            lblMensagemErro.setText("Campos ou datas inválidas.");
            verificaDataInicio = false;
        } else {
            try{
                diaInicio = Integer.parseInt(txtDataInicio.getText().substring(0, 2));
                mesInicio = Integer.parseInt(txtDataInicio.getText().substring(3, 5));
                anoInicio = Integer.parseInt(txtDataInicio.getText().substring(6, 10));
                LocalDate dataInicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
                anuncio.setDataInicio(dataInicio);
                verificaDataInicio = true;
                lblMensagemErro.setText("");
            } catch(NumberFormatException e){
                lblMensagemErro.setText("Campos ou datas inválidas.");
                verificaDataInicio = false;
            }
        }

        if (txtDataFim.getText().isEmpty()) {
            lblMensagemErro.setText("Campos ou datas inválidas.");
            verificaDataFim = false;
        } else {
            try{
                diaFim = Integer.parseInt(txtDataFim.getText().substring(0, 2));
                mesFim = Integer.parseInt(txtDataFim.getText().substring(3, 5));
                anoFim = Integer.parseInt(txtDataFim.getText().substring(6, 10));
                LocalDate dataFim = LocalDate.of(anoFim, mesFim, diaFim);
                anuncio.setDataFim(dataFim);
                verificaDataFim = true;
                lblMensagemErro.setText("");
            } catch(NumberFormatException e){
                lblMensagemErro.setText("Campos ou datas inválidas.");
                verificaDataFim = false;
            }
        }

        if (txtInvestimentoDia.getText().isEmpty()) {
            lblMensagemErro.setText("Campos ou datas inválidas.");
        } else {
            try {
                double investimentoDia = Double.parseDouble(txtInvestimentoDia.getText());
                anuncio.setInvestimentoDia(investimentoDia);
                lblMensagemErro.setText("");
            } catch (NumberFormatException e) {
                lblMensagemErro.setText("Campos ou datas inválidas.");
            }
        }
        
        if(txtNome.getText().isEmpty() || txtCliente.getText().isEmpty() || verificaDataInicio == false || verificaDataFim == false || txtInvestimentoDia.getText().isEmpty()){
        } else {
            inserirDados();
            procurarDados();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseEntered
        btnCadastrar.setBackground(Color.white);
        btnCadastrar.setForeground(new Color(30, 215, 96));
        btnCadastrar.setFont(new java.awt.Font("Calibri", 0, 19));
    }//GEN-LAST:event_btnCadastrarMouseEntered

    private void btnCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseExited
        btnCadastrar.setBackground(new Color(30, 215, 96));
        btnCadastrar.setFont(new java.awt.Font("Calibri", 0, 18));
        btnCadastrar.setForeground(Color.white);
    }//GEN-LAST:event_btnCadastrarMouseExited
    //--------------------------------------------------------------------------

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroAnuncio().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCadastroAnuncio;
    private javax.swing.JLabel lblMensagemErro;
    public static javax.swing.JTable tblAnuncios;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataFim;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JTextField txtInvestimentoDia;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
