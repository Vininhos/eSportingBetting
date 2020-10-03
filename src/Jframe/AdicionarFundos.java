package Jframe;

import javax.swing.JOptionPane;

public class AdicionarFundos extends javax.swing.JFrame {

    /**
     * Creates new form AdicionarFundos
     */
    public AdicionarFundos() {
        initComponents();
        setLocationRelativeTo(this);
    }
    int valorAtual = 0;
    int aux = 0;

    //Método que será utilizado pelo menu principal para pegar valor novo que
    //o cliente adicionou.
    public int pegaValorFundosAtual() {
        aux = valorAtual;
        valorAtual = 0;
        return aux;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtNumeroCartao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtCodVerificador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtValor = new javax.swing.JTextField();
        jbAdicionarFundos = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Fundos");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Adicionar Fundos");

        jLabel2.setText("Número do Cartão:");

        jtNumeroCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNumeroCartaoActionPerformed(evt);
            }
        });
        jtNumeroCartao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtNumeroCartaoKeyReleased(evt);
            }
        });

        jLabel3.setText("Código verificador:");

        jtCodVerificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCodVerificadorActionPerformed(evt);
            }
        });
        jtCodVerificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodVerificadorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCodVerificadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCodVerificadorKeyTyped(evt);
            }
        });

        jLabel4.setText("Valor:");

        jbAdicionarFundos.setText("Alimentar o Capitalismo");
        jbAdicionarFundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarFundosActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCodVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtValor)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAdicionarFundos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtCodVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAdicionarFundos)
                    .addComponent(jbFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    //Método que adiciona fundos, fazendo certas verificações nos campos.
    private void jbAdicionarFundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarFundosActionPerformed

        if (jtNumeroCartao.getText().length() < 16 || jtNumeroCartao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite 16 números para o número do cartão.");

        } else if (jtCodVerificador.getText().length() < 3 || jtCodVerificador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite 3 números para o código verificador.");

        } else if (jtValor.getText().isEmpty() || Integer.parseInt(jtValor.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido para o valor");

        } else {
            JOptionPane.showMessageDialog(this, "Fundos adicionados com sucesso!");
            valorAtual = Integer.parseInt(jtValor.getText());
            dispose();
        }
    }//GEN-LAST:event_jbAdicionarFundosActionPerformed

    private void jtCodVerificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCodVerificadorActionPerformed

    }//GEN-LAST:event_jtCodVerificadorActionPerformed

    private void jtNumeroCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNumeroCartaoActionPerformed

    }//GEN-LAST:event_jtNumeroCartaoActionPerformed

    private void jtCodVerificadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodVerificadorKeyPressed

    }//GEN-LAST:event_jtCodVerificadorKeyPressed

    private void jtCodVerificadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodVerificadorKeyTyped

    }//GEN-LAST:event_jtCodVerificadorKeyTyped

    //Verificação da quantidade de caracteres nos campos através de evento.
    private void jtCodVerificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodVerificadorKeyReleased
        if (jtCodVerificador.getText().length() > 3) {
            JOptionPane.showMessageDialog(this, "Digite apenas 3 números para o código verificador.");
            jtCodVerificador.setText("");
        }
    }//GEN-LAST:event_jtCodVerificadorKeyReleased
    //Verificação da quantidade de caracteres nos campos através de evento.
    private void jtNumeroCartaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNumeroCartaoKeyReleased
        if (jtNumeroCartao.getText().length() > 16) {
            JOptionPane.showMessageDialog(this, "Digite apenas 16 números para o número do cartão.");
            jtNumeroCartao.setText("");
        }
    }//GEN-LAST:event_jtNumeroCartaoKeyReleased

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
            java.util.logging.Logger.getLogger(AdicionarFundos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarFundos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarFundos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarFundos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarFundos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbAdicionarFundos;
    private javax.swing.JButton jbFechar;
    private javax.swing.JTextField jtCodVerificador;
    private javax.swing.JTextField jtNumeroCartao;
    private javax.swing.JTextField jtValor;
    // End of variables declaration//GEN-END:variables
}
