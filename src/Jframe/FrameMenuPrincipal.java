package Jframe;

public class FrameMenuPrincipal extends javax.swing.JFrame {

    public FrameMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(this);
        jmiGerarFundos.setVisible(false);
    }
    int valorFundoAtual = 0;
    int saldoNovo = 0;
    AdicionarFundos frameAdicionarFundos = new AdicionarFundos();
    ApostaDoDiaRocketLeague frameRocketLeague = new ApostaDoDiaRocketLeague();

    public void ativaPrivilegiosAdministrador() {
        jmiGerarFundos.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiCadCliente = new javax.swing.JMenuItem();
        jmiCadAdmin = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiRocketLeague = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiDeslogar = new javax.swing.JMenuItem();
        jmiAdicionarFundos = new javax.swing.JMenuItem();
        jmiGerarFundos = new javax.swing.JMenuItem();
        jmUsuario = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jmiAtualizar = new javax.swing.JMenuItem();
        jmSaldoAtual = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eSportingBetting");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ROCKET-LEAGUE-DESTACADA-1-900x503.jpg"))); // NOI18N

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastros");

        jmiCadCliente.setText("Cadastro de Cliente");
        jmiCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadCliente);

        jmiCadAdmin.setText("Cadastro de Admin");
        jmiCadAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadAdminActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadAdmin);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Apostas");

        jmiRocketLeague.setText("Rocket League");
        jmiRocketLeague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRocketLeagueActionPerformed(evt);
            }
        });
        jMenu2.add(jmiRocketLeague);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Opções");

        jmiDeslogar.setText("Deslogar");
        jMenu3.add(jmiDeslogar);

        jmiAdicionarFundos.setText("Alimentar Capitalismo");
        jmiAdicionarFundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdicionarFundosActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAdicionarFundos);

        jmiGerarFundos.setText("Gerar Milhões de Bolsonaros (ADM)");
        jmiGerarFundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGerarFundosActionPerformed(evt);
            }
        });
        jMenu3.add(jmiGerarFundos);

        jMenuBar1.add(jMenu3);

        jmUsuario.setText("issovaisermodificado");
        jMenuBar1.add(jmUsuario);

        jMenu4.setText("Dinheiros:");

        jmiAtualizar.setText("Atualizar");
        jmiAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAtualizarActionPerformed(evt);
            }
        });
        jMenu4.add(jmiAtualizar);

        jMenuBar1.add(jMenu4);

        jmSaldoAtual.setText("5");
        jMenuBar1.add(jmSaldoAtual);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadClienteActionPerformed
        CadastroCliente cadCliente = new CadastroCliente();
        cadCliente.setVisible(true);
    }//GEN-LAST:event_jmiCadClienteActionPerformed

    private void jmiCadAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadAdminActionPerformed
        CadastroAdmin cadAdmin = new CadastroAdmin();
        cadAdmin.setVisible(true);
    }//GEN-LAST:event_jmiCadAdminActionPerformed

    private void jmiRocketLeagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRocketLeagueActionPerformed
        frameRocketLeague = new ApostaDoDiaRocketLeague();
        frameRocketLeague.setaSaldoAtual(jmSaldoAtual.getText());
        frameRocketLeague.setVisible(true);
        frameRocketLeague.iniciaComponentes();
    }//GEN-LAST:event_jmiRocketLeagueActionPerformed

    private void jmiAdicionarFundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdicionarFundosActionPerformed
        frameAdicionarFundos.setVisible(true);
    }//GEN-LAST:event_jmiAdicionarFundosActionPerformed

    private void jmiGerarFundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGerarFundosActionPerformed
        jmSaldoAtual.setText("99999999");
    }//GEN-LAST:event_jmiGerarFundosActionPerformed

    //Método responsável por atualizar o saldo no menu principal.
    private void jmiAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAtualizarActionPerformed
        int saldoAtual = Integer.parseInt(jmSaldoAtual.getText());
        saldoNovo = saldoAtual + (frameAdicionarFundos.pegaValorFundosAtual()
                + frameRocketLeague.atualizaFundos());
        jmSaldoAtual.setText(saldoNovo + "");
        saldoNovo = 0;
        valorFundoAtual = 0;
    }//GEN-LAST:event_jmiAtualizarActionPerformed
    
    //Muda o nome do usuário no menu para o que foi cadastrado.
    public void mudaNomeUsuario(String usuario) {
        jmUsuario.setText(usuario);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmSaldoAtual;
    private javax.swing.JMenu jmUsuario;
    private javax.swing.JMenuItem jmiAdicionarFundos;
    private javax.swing.JMenuItem jmiAtualizar;
    private javax.swing.JMenuItem jmiCadAdmin;
    private javax.swing.JMenuItem jmiCadCliente;
    private javax.swing.JMenuItem jmiDeslogar;
    private javax.swing.JMenuItem jmiGerarFundos;
    private javax.swing.JMenuItem jmiRocketLeague;
    // End of variables declaration//GEN-END:variables
}
