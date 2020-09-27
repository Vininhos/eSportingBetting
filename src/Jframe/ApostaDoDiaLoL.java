package Jframe;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class ApostaDoDiaLoL extends javax.swing.JFrame {

    ArrayList<String> arrayListaTimes;

    private void leArquivosDiretorio() {
        Path caminho = Paths.get(System.getProperty("user.dir") + "\\TimesLoL");
        DirectoryStream<Path> diretorio;
        try {
            diretorio = Files.newDirectoryStream(caminho);
            arrayListaTimes = new ArrayList();
            for (Path file : diretorio) {
                System.out.println(file.toAbsolutePath());
                arrayListaTimes.add(file.toAbsolutePath().toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void geraApostaDia() {
        Random geradorNumeroAleatorio = new Random();
        String timeSorteado = arrayListaTimes.get(geradorNumeroAleatorio.nextInt(arrayListaTimes.size()));
        File timeAtual = new File(timeSorteado);
        String nomeTimeAtual = timeAtual.getName().replace(".png", "");
        jlApostaTime1.setText(jlApostaTime1.getText().concat(" " + nomeTimeAtual + ":"));
        ImageIcon imagemTimes = new ImageIcon(timeSorteado);
        jlTime1.setIcon(imagemTimes);
        arrayListaTimes.remove(timeSorteado);

        String timeSorteado2 = arrayListaTimes.get(geradorNumeroAleatorio.nextInt(arrayListaTimes.size()));
        timeAtual = new File(timeSorteado2);
        nomeTimeAtual = timeAtual.getName().replace(".png", "");
        jlApostaTime2.setText(jlApostaTime2.getText().concat(" " + nomeTimeAtual + ":"));
        imagemTimes = new ImageIcon(timeSorteado2);
        jlTime2.setIcon(imagemTimes);
    }

    private void tempoAntesComecoPartida() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 19; i > -1; i--) {
                        Thread.sleep(1000);
                        jlTempoAntesPartida.setText(i + "");
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Creates new form ApostaDoDiaLeague
     */
    public ApostaDoDiaLoL() {
        initComponents();
        setLocationRelativeTo(this);
        leArquivosDiretorio();
        geraApostaDia();
        tempoAntesComecoPartida();
        getContentPane().setBackground(Color.white);
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
        jlTime1 = new javax.swing.JLabel();
        jlTime2 = new javax.swing.JLabel();
        jtApostaTime1 = new javax.swing.JTextField();
        jtApostaTime2 = new javax.swing.JTextField();
        jbApostarTime1 = new javax.swing.JButton();
        jlApostaTime1 = new javax.swing.JLabel();
        jbApostarTime2 = new javax.swing.JButton();
        jlApostaTime2 = new javax.swing.JLabel();
        jlTime3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlTempoAntesPartida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aposta do dia - League Of Legends");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("APOSTA DO DIA - LEAGUE OF LEGENDS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2.setText("VS");

        jbApostarTime1.setText("Apostar");
        jbApostarTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApostarTime1ActionPerformed(evt);
            }
        });

        jlApostaTime1.setText("Valor para apostar no time");

        jbApostarTime2.setText("Apostar");
        jbApostarTime2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApostarTime2ActionPerformed(evt);
            }
        });

        jlApostaTime2.setText("Valor para apostar no time");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tempo antes da partida começar:");

        jlTempoAntesPartida.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlTempoAntesPartida.setText("20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(227, 227, 227))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlApostaTime1)
                            .addComponent(jbApostarTime1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlTempoAntesPartida)
                                .addGap(0, 143, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtApostaTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlApostaTime2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbApostarTime2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jtApostaTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jlTime1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTime2)
                .addGap(97, 97, 97))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(294, 294, 294)
                    .addComponent(jlTime3)
                    .addContainerGap(515, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtApostaTime1, jtApostaTime2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTime1)
                            .addComponent(jlTime2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlApostaTime1)
                    .addComponent(jlApostaTime2)
                    .addComponent(jtApostaTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtApostaTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbApostarTime1)
                    .addComponent(jbApostarTime2))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlTempoAntesPartida))
                .addGap(36, 36, 36))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(jlTime3)
                    .addContainerGap(614, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbApostarTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApostarTime1ActionPerformed
        jtApostaTime1.setEnabled(false);
        jtApostaTime2.setText("");
        jtApostaTime2.setEnabled(false);
        jbApostarTime1.setEnabled(false);
        jbApostarTime2.setEnabled(false);
    }//GEN-LAST:event_jbApostarTime1ActionPerformed

    private void jbApostarTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApostarTime2ActionPerformed
        jtApostaTime1.setEnabled(false);
        jtApostaTime1.setText("");
        jtApostaTime2.setEnabled(false);
        jbApostarTime1.setEnabled(false);
        jbApostarTime2.setEnabled(false);
    }//GEN-LAST:event_jbApostarTime2ActionPerformed

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
            java.util.logging.Logger.getLogger(ApostaDoDiaLoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApostaDoDiaLoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApostaDoDiaLoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApostaDoDiaLoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApostaDoDiaLoL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbApostarTime1;
    private javax.swing.JButton jbApostarTime2;
    private javax.swing.JLabel jlApostaTime1;
    private javax.swing.JLabel jlApostaTime2;
    private javax.swing.JLabel jlTempoAntesPartida;
    private javax.swing.JLabel jlTime1;
    private javax.swing.JLabel jlTime2;
    private javax.swing.JLabel jlTime3;
    private javax.swing.JTextField jtApostaTime1;
    private javax.swing.JTextField jtApostaTime2;
    // End of variables declaration//GEN-END:variables
}
