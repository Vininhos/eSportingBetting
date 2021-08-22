package Jframe;

import Class.Administrador;
import Class.Cliente;
import DAO.eSportBettingDAO;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame implements Serializable {

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(this);
    }
    FrameMenuPrincipal frameMenu = new FrameMenuPrincipal();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jbLogar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jcbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jbCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Login - eSportBetting");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Usuário:");

        jtUsuario.setText("Vinicius");

        jbLogar.setText("Logar");
        jbLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogarActionPerformed(evt);
            }
        });
        jbLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbLogarKeyPressed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Senha:");

        jpfSenha.setText("123");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Tipo Usuário:");

        jcbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Administrador" }));

        jLabel5.setText("Não se cadastrou ainda? Clique no botão abaixo.");

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jbCadastrar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtUsuario)
                                        .addComponent(jpfSenha)
                                        .addComponent(jcbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jbLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrar, jbLogar, jbSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCadastrar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSair)
                    .addComponent(jbLogar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSairActionPerformed

    //Realiza o login do usuário e seta o nome no menu principal.
    private void jbLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogarActionPerformed

        if (jtUsuario.getText().length() < 0 || jtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um nome de usuário válido.");

        } else if (jpfSenha.getText().length() < 0 || jpfSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite uma senha válida.");

        } else {

            String result = eSportBettingDAO.getInstance().verificarLoginDAO(jtUsuario.getText(),
                    jpfSenha.getText(), jcbTipoUsuario.getSelectedItem().toString());

            if (result != null) {
                dispose();
                if (jcbTipoUsuario.getSelectedItem().toString() == "Cliente") {
                    Cliente retCliente = eSportBettingDAO.getInstance().returnParametrosCliente(jtUsuario.getText(), jpfSenha.getText());
                    Cliente cliente = new Cliente(retCliente.getUsuario(),
                            retCliente.getSenha(),
                            retCliente.getSaldo(),
                            retCliente.getNome(),
                            retCliente.getDataNascimento(),
                            retCliente.getEmail(),
                            retCliente.getCpf(),
                            retCliente.getGenero());
                    frameMenu.carregarDadosUsuarioMenuPrincipal(cliente, null);

                } else {
                    Administrador retAdmin = eSportBettingDAO.getInstance().returnParametrosAdministrador(jtUsuario.getText(), jpfSenha.getText());
                    Administrador admin = new Administrador(retAdmin.getUsuario(),
                            retAdmin.getSenha(),
                            retAdmin.getNome(),
                            retAdmin.getDataNascimento(),
                            retAdmin.getEmail(),
                            retAdmin.getCpf(),
                            retAdmin.getGenero());

                    frameMenu.carregarDadosUsuarioMenuPrincipal(null, admin);
                }

                frameMenu.setVisible(true);
                frameMenu.mudaNomeUsuario("Usuario atual: " + jtUsuario.getText());
                JOptionPane.showMessageDialog(this, "Bem-vindo, "
                        + result + ". Você logou com sucesso!");

            }
        }
    }//GEN-LAST:event_jbLogarActionPerformed

    private void jbLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbLogarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbLogar.doClick();
        }
    }//GEN-LAST:event_jbLogarKeyPressed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        CadastroCliente cadCliente;

        int escolha = JOptionPane.showConfirmDialog(this, "Você deseja se cadastrar como cliente?", "Cadastro", 0);

        if (escolha == 0) {

            cadCliente = new CadastroCliente();
            cadCliente.setVisible(true);

        } else if (escolha == 1) {
            String comparador = JOptionPane.showInputDialog(
                    "Digite o código secreto para se cadastrar como admin... (Psiu, o código é: Flyps é cansado)");
            if (comparador.equalsIgnoreCase("Flyps é cansado")) {
                CadastroAdmin cadAdmin = new CadastroAdmin();
                cadAdmin.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(this, "Você ainda não está preparado...");
                cadCliente = new CadastroCliente();
                cadCliente.setVisible(true);
            }
        }


    }//GEN-LAST:event_jbCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbLogar;
    private javax.swing.JButton jbSair;
    private javax.swing.JComboBox<String> jcbTipoUsuario;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables
}
