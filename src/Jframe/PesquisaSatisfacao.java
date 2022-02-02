/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jframe;

import DAO.eSportBettingDAO;
import Model.PesquisaSatisfacaoObject;
import javax.swing.JOptionPane;

/**
 *
 * @author vinni
 */
public class PesquisaSatisfacao extends javax.swing.JFrame {

    /**
     * Creates new form PesquisaSatisfacaoCliente
     */
    public PesquisaSatisfacao() {
        initComponents();
        setLocationRelativeTo(this);
    }

    private String usuario;
    private boolean pergunta1Resp = false;
    private boolean pergunta2Resp = false;
    private boolean pergunta3Resp = false;
    private boolean pergunta4Resp = false;
    private boolean pergunta5Resp = false;

    public void adicionarUsuario(String usuario) {
        this.usuario = usuario;
    }

    PesquisaSatisfacaoObject pesquisaSatisfacaoObject = new PesquisaSatisfacaoObject();

    private void apagarBotoesPergunta1() {
        jlRecomendar1.setSelected(false);
        jlRecomendar2.setSelected(false);
        jlRecomendar3.setSelected(false);
        jlRecomendar4.setSelected(false);
        jlRecomendar5.setSelected(false);
        jlRecomendar6.setSelected(false);
        jlRecomendar7.setSelected(false);
        jlRecomendar8.setSelected(false);
        jlRecomendar9.setSelected(false);
        jlRecomendar10.setSelected(false);
    }

    private void apagarBotoesPergunta2() {
        jlConcordoPergunta2.setSelected(false);
        jlNeutroPergunta2.setSelected(false);
        jlDiscordoPergunta2.setSelected(false);
    }

    private void apagarBotoesPergunta3() {
        jlConcordoPergunta3.setSelected(false);
        jlNeutroPergunta3.setSelected(false);
        jlDiscordoPergunta3.setSelected(false);
    }

    private void apagarBotoesPergunta4() {
        jlConcordoPergunta4.setSelected(false);
        jlNeutroPergunta4.setSelected(false);
        jlDiscordoPergunta4.setSelected(false);
    }

    private void apagarBotoesPergunta5() {
        jlConcordoPergunta5.setSelected(false);
        jlNeutroPergunta5.setSelected(false);
        jlDiscordoPergunta5.setSelected(false);
    }

    private boolean verificaObjetoPequisaSatisfacaoVazio() {
        if (pergunta1Resp == false || pergunta2Resp == false
                || pergunta3Resp == false || pergunta4Resp == false
                || pergunta5Resp == false) {
            return false;
        }
        return true;
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
        jlRecomendar1 = new javax.swing.JRadioButton();
        jlRecomendar2 = new javax.swing.JRadioButton();
        jlRecomendar3 = new javax.swing.JRadioButton();
        jlRecomendar4 = new javax.swing.JRadioButton();
        jlRecomendar5 = new javax.swing.JRadioButton();
        jlRecomendar6 = new javax.swing.JRadioButton();
        jlRecomendar7 = new javax.swing.JRadioButton();
        jlRecomendar8 = new javax.swing.JRadioButton();
        jlRecomendar9 = new javax.swing.JRadioButton();
        jlRecomendar10 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jlDiscordoPergunta2 = new javax.swing.JRadioButton();
        jlNeutroPergunta2 = new javax.swing.JRadioButton();
        jlConcordoPergunta2 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlDiscordoPergunta3 = new javax.swing.JRadioButton();
        jlNeutroPergunta3 = new javax.swing.JRadioButton();
        jlConcordoPergunta3 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jlConcordoPergunta4 = new javax.swing.JRadioButton();
        jlDiscordoPergunta4 = new javax.swing.JRadioButton();
        jlNeutroPergunta4 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jlConcordoPergunta5 = new javax.swing.JRadioButton();
        jlDiscordoPergunta5 = new javax.swing.JRadioButton();
        jlNeutroPergunta5 = new javax.swing.JRadioButton();
        jbSubmeterResposta = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Satisfação");

        jLabel1.setText("1. Entre 0 e 10, qual a chance de você recomendar o eSportBetting para um conhecido?");

        jlRecomendar1.setText("1");
        jlRecomendar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar1ActionPerformed(evt);
            }
        });

        jlRecomendar2.setText("2");
        jlRecomendar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar2ActionPerformed(evt);
            }
        });

        jlRecomendar3.setText("3");
        jlRecomendar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar3ActionPerformed(evt);
            }
        });

        jlRecomendar4.setText("4");
        jlRecomendar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar4ActionPerformed(evt);
            }
        });

        jlRecomendar5.setText("5");
        jlRecomendar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar5ActionPerformed(evt);
            }
        });

        jlRecomendar6.setText("6");
        jlRecomendar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar6ActionPerformed(evt);
            }
        });

        jlRecomendar7.setText("7");
        jlRecomendar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar7ActionPerformed(evt);
            }
        });

        jlRecomendar8.setText("8");
        jlRecomendar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar8ActionPerformed(evt);
            }
        });

        jlRecomendar9.setText("9");
        jlRecomendar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar9ActionPerformed(evt);
            }
        });

        jlRecomendar10.setText("10");
        jlRecomendar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlRecomendar10ActionPerformed(evt);
            }
        });

        jLabel3.setText("2. Você considera os serviços oferecidos como de alta qualidade?");

        jlDiscordoPergunta2.setText("Discordo");
        jlDiscordoPergunta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlDiscordoPergunta2ActionPerformed(evt);
            }
        });

        jlNeutroPergunta2.setText("Não concordo ou discordo");
        jlNeutroPergunta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlNeutroPergunta2ActionPerformed(evt);
            }
        });

        jlConcordoPergunta2.setText("Concordo");
        jlConcordoPergunta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlConcordoPergunta2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Pesquisa de Satisfação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setText("3. A interface do eSportBetting é intuitivo para você?");

        jlDiscordoPergunta3.setText("Discordo");
        jlDiscordoPergunta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlDiscordoPergunta3ActionPerformed(evt);
            }
        });

        jlNeutroPergunta3.setText("Não concordo ou discordo");
        jlNeutroPergunta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlNeutroPergunta3ActionPerformed(evt);
            }
        });

        jlConcordoPergunta3.setText("Concordo");
        jlConcordoPergunta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlConcordoPergunta3ActionPerformed(evt);
            }
        });

        jLabel5.setText("4. Você se sente seguro utilizando nossa plataforma de apostas?");

        jlConcordoPergunta4.setText("Concordo");
        jlConcordoPergunta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlConcordoPergunta4ActionPerformed(evt);
            }
        });

        jlDiscordoPergunta4.setText("Discordo");
        jlDiscordoPergunta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlDiscordoPergunta4ActionPerformed(evt);
            }
        });

        jlNeutroPergunta4.setText("Não concordo ou discordo");
        jlNeutroPergunta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlNeutroPergunta4ActionPerformed(evt);
            }
        });

        jLabel6.setText("5. Com o eSportBetting, sinto que consigo receber um valor justo em meus ganhos.");

        jlConcordoPergunta5.setText("Concordo");
        jlConcordoPergunta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlConcordoPergunta5ActionPerformed(evt);
            }
        });

        jlDiscordoPergunta5.setText("Discordo");
        jlDiscordoPergunta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlDiscordoPergunta5ActionPerformed(evt);
            }
        });

        jlNeutroPergunta5.setText("Não concordo ou discordo");
        jlNeutroPergunta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlNeutroPergunta5ActionPerformed(evt);
            }
        });

        jbSubmeterResposta.setText("Submeter Resposta");
        jbSubmeterResposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubmeterRespostaActionPerformed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlDiscordoPergunta5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNeutroPergunta5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlConcordoPergunta5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlDiscordoPergunta4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNeutroPergunta4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlConcordoPergunta4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlDiscordoPergunta3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNeutroPergunta3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlConcordoPergunta3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlRecomendar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecomendar10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlDiscordoPergunta2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNeutroPergunta2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlConcordoPergunta2))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbSubmeterResposta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSair))
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbSair, jbSubmeterResposta});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRecomendar1)
                    .addComponent(jlRecomendar2)
                    .addComponent(jlRecomendar3)
                    .addComponent(jlRecomendar4)
                    .addComponent(jlRecomendar5)
                    .addComponent(jlRecomendar6)
                    .addComponent(jlRecomendar7)
                    .addComponent(jlRecomendar8)
                    .addComponent(jlRecomendar9)
                    .addComponent(jlRecomendar10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDiscordoPergunta2)
                    .addComponent(jlNeutroPergunta2)
                    .addComponent(jlConcordoPergunta2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDiscordoPergunta3)
                    .addComponent(jlNeutroPergunta3)
                    .addComponent(jlConcordoPergunta3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDiscordoPergunta4)
                    .addComponent(jlNeutroPergunta4)
                    .addComponent(jlConcordoPergunta4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDiscordoPergunta5)
                    .addComponent(jlNeutroPergunta5)
                    .addComponent(jlConcordoPergunta5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSubmeterResposta)
                    .addComponent(jbSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlRecomendar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar1ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar1.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(1);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar1ActionPerformed

    private void jlRecomendar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar2ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar2.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(2);
        System.out.println(pesquisaSatisfacaoObject.getPontosPergunta2());
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar2ActionPerformed

    private void jlRecomendar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar3ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar3.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(3);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar3ActionPerformed

    private void jlRecomendar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar4ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar4.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(4);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar4ActionPerformed

    private void jlRecomendar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar5ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar5.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(5);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar5ActionPerformed

    private void jlRecomendar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar6ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar6.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(6);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar6ActionPerformed

    private void jlRecomendar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar7ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar7.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(7);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar7ActionPerformed

    private void jlRecomendar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar8ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar8.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(8);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar8ActionPerformed

    private void jlRecomendar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar9ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar9.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(9);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar9ActionPerformed

    private void jlRecomendar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlRecomendar10ActionPerformed
        apagarBotoesPergunta1();
        jlRecomendar10.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta1(10);
        pergunta1Resp = true;
    }//GEN-LAST:event_jlRecomendar10ActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jlDiscordoPergunta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlDiscordoPergunta2ActionPerformed
        apagarBotoesPergunta2();
        jlDiscordoPergunta2.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta2(1);
        pergunta2Resp = true;
    }//GEN-LAST:event_jlDiscordoPergunta2ActionPerformed

    private void jlNeutroPergunta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlNeutroPergunta2ActionPerformed
        apagarBotoesPergunta2();
        jlNeutroPergunta2.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta2(5);
        pergunta2Resp = true;
    }//GEN-LAST:event_jlNeutroPergunta2ActionPerformed

    private void jlConcordoPergunta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlConcordoPergunta2ActionPerformed
        apagarBotoesPergunta2();
        jlConcordoPergunta2.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta2(10);
        pergunta2Resp = true;
    }//GEN-LAST:event_jlConcordoPergunta2ActionPerformed

    private void jlDiscordoPergunta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlDiscordoPergunta3ActionPerformed
        apagarBotoesPergunta3();
        jlDiscordoPergunta3.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta3(1);
        pergunta3Resp = true;
    }//GEN-LAST:event_jlDiscordoPergunta3ActionPerformed

    private void jlNeutroPergunta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlNeutroPergunta3ActionPerformed
        apagarBotoesPergunta3();
        jlNeutroPergunta3.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta3(5);
        pergunta3Resp = true;
    }//GEN-LAST:event_jlNeutroPergunta3ActionPerformed

    private void jlConcordoPergunta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlConcordoPergunta3ActionPerformed
        apagarBotoesPergunta3();
        jlConcordoPergunta3.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta3(10);
        pergunta3Resp = true;
    }//GEN-LAST:event_jlConcordoPergunta3ActionPerformed

    private void jlDiscordoPergunta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlDiscordoPergunta4ActionPerformed
        apagarBotoesPergunta4();
        jlDiscordoPergunta4.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta4(1);
        pergunta4Resp = true;
    }//GEN-LAST:event_jlDiscordoPergunta4ActionPerformed

    private void jlNeutroPergunta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlNeutroPergunta4ActionPerformed
        apagarBotoesPergunta4();
        jlNeutroPergunta4.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta4(5);
        pergunta4Resp = true;
    }//GEN-LAST:event_jlNeutroPergunta4ActionPerformed

    private void jlConcordoPergunta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlConcordoPergunta4ActionPerformed
        apagarBotoesPergunta4();
        jlConcordoPergunta4.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta4(10);
        pergunta4Resp = true;
    }//GEN-LAST:event_jlConcordoPergunta4ActionPerformed

    private void jlDiscordoPergunta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlDiscordoPergunta5ActionPerformed
        apagarBotoesPergunta5();
        jlDiscordoPergunta5.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta5(1);
        pergunta5Resp = true;
    }//GEN-LAST:event_jlDiscordoPergunta5ActionPerformed

    private void jlNeutroPergunta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlNeutroPergunta5ActionPerformed
        apagarBotoesPergunta5();
        jlNeutroPergunta5.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta5(5);
        pergunta5Resp = true;
    }//GEN-LAST:event_jlNeutroPergunta5ActionPerformed

    private void jlConcordoPergunta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlConcordoPergunta5ActionPerformed
        apagarBotoesPergunta5();
        jlConcordoPergunta5.setSelected(true);
        pesquisaSatisfacaoObject.setPontosPergunta5(10);
        pergunta5Resp = true;
    }//GEN-LAST:event_jlConcordoPergunta5ActionPerformed

    private void jbSubmeterRespostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmeterRespostaActionPerformed
        if (verificaObjetoPequisaSatisfacaoVazio()) {
            eSportBettingDAO.getInstance().inserePesquisaSatisfacao(usuario, pesquisaSatisfacaoObject);

            JOptionPane.showMessageDialog(null, "Resposta registrada! Obrigado pelo feedback.", "Sucesso no envio", JOptionPane.INFORMATION_MESSAGE);

            //JOptionPane.showMessageDialog(null, "Ocorreu um erro ao registrar sua resposta.", "Erro no envio", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSubmeterRespostaActionPerformed

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
            java.util.logging.Logger.getLogger(PesquisaSatisfacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaSatisfacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaSatisfacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaSatisfacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaSatisfacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSubmeterResposta;
    private javax.swing.JRadioButton jlConcordoPergunta2;
    private javax.swing.JRadioButton jlConcordoPergunta3;
    private javax.swing.JRadioButton jlConcordoPergunta4;
    private javax.swing.JRadioButton jlConcordoPergunta5;
    private javax.swing.JRadioButton jlDiscordoPergunta2;
    private javax.swing.JRadioButton jlDiscordoPergunta3;
    private javax.swing.JRadioButton jlDiscordoPergunta4;
    private javax.swing.JRadioButton jlDiscordoPergunta5;
    private javax.swing.JRadioButton jlNeutroPergunta2;
    private javax.swing.JRadioButton jlNeutroPergunta3;
    private javax.swing.JRadioButton jlNeutroPergunta4;
    private javax.swing.JRadioButton jlNeutroPergunta5;
    private javax.swing.JRadioButton jlRecomendar1;
    private javax.swing.JRadioButton jlRecomendar10;
    private javax.swing.JRadioButton jlRecomendar2;
    private javax.swing.JRadioButton jlRecomendar3;
    private javax.swing.JRadioButton jlRecomendar4;
    private javax.swing.JRadioButton jlRecomendar5;
    private javax.swing.JRadioButton jlRecomendar6;
    private javax.swing.JRadioButton jlRecomendar7;
    private javax.swing.JRadioButton jlRecomendar8;
    private javax.swing.JRadioButton jlRecomendar9;
    // End of variables declaration//GEN-END:variables
}