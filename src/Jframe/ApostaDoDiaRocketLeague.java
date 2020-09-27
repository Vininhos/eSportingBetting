package Jframe;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ApostaDoDiaRocketLeague extends javax.swing.JFrame {

    ArrayList<String> arrayListaTimes;
    ArrayList<String> arrayListaSons;
    PartidaTempoReal partidaTempoReal = new PartidaTempoReal();
    String nomeTimeAtual;
    String nomeTimeAtual2;

    private void leArquivosDiretorio() {
        Path caminho = Paths.get(System.getProperty("user.dir") + "\\TimesRL");
        DirectoryStream<Path> diretorio;
        try {
            diretorio = Files.newDirectoryStream(caminho);
            arrayListaTimes = new ArrayList();
            for (Path file : diretorio) {
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
        nomeTimeAtual = timeAtual.getName().replace(".png", "");
        jlApostaTime1.setText(jlApostaTime1.getText().concat(" " + nomeTimeAtual + ":"));
        ImageIcon imagemTimes = new ImageIcon(timeSorteado);
        jlTime1.setIcon(imagemTimes);
        arrayListaTimes.remove(timeSorteado);

        String timeSorteado2 = arrayListaTimes.get(geradorNumeroAleatorio.nextInt(arrayListaTimes.size()));
        timeAtual = new File(timeSorteado2);
        nomeTimeAtual2 = timeAtual.getName().replace(".png", "");
        jlApostaTime2.setText(jlApostaTime2.getText().concat(" " + nomeTimeAtual + ":"));
        imagemTimes = new ImageIcon(timeSorteado2);
        jlTime2.setIcon(imagemTimes);
    }

    private void tempoAntesPartida() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 5; i > -1; i--) {
                        Thread.sleep(1000);
                        jlTempoPartida.setText(i + "");
                    }
                    iniciaPartida();
                    tempoDurantePartida();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void tempoDurantePartida() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int contadorEvento = 0;
                    for (int i = 29; i > -1; i--) {
                        contadorEvento += 1;
                        Thread.sleep(1000);
                        jlTempoPartida.setText(i + "");
                        if (contadorEvento == 5) {
                            tocaSomPartida();
                            contadorEvento = 0;
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void tocaSomPartida() {

        FileInputStream arquivoInputStream = null;

        Path caminho = Paths.get(System.getProperty("user.dir") + "\\SonsRL");
        DirectoryStream<Path> diretorio;

        try {
            diretorio = Files.newDirectoryStream(caminho);
            arrayListaSons = new ArrayList();

            for (Path file : diretorio) {
                arrayListaSons.add(file.toAbsolutePath().toString());
            }

            Random geradorNumeroAleatorio = new Random();
            String somSorteado = arrayListaSons.get(geradorNumeroAleatorio.nextInt(arrayListaSons.size()));
            File somAtual = new File(somSorteado);
            System.out.println(somAtual);
            arquivoInputStream = new FileInputStream(somSorteado);
            String nomeSomAtual = somAtual.getName().replace(".mp3", "");

            String timeConcretizado;
            int numero = geradorNumeroAleatorio.nextInt(2);
            System.out.println(numero);
            if (numero == 0) {
                timeConcretizado = nomeTimeAtual;
            } else {
                timeConcretizado = nomeTimeAtual2;
            }

            if (nomeSomAtual.equals("save1")) {
                partidaTempoReal.setaPartidaTempoReal("O jogador do time da " + timeConcretizado + " fez uma defesa!");
            }
            if (nomeSomAtual.equals("save2")) {
                partidaTempoReal.setaPartidaTempoReal("O jogador do time da " + timeConcretizado + " fez uma boa defesa!");
            }
            if (nomeSomAtual.equals("save3")) {
                partidaTempoReal.setaPartidaTempoReal("O jogador do time da " + timeConcretizado + " defendeu o seu gol");
            }
            if (nomeSomAtual.equals("epicsave1")) {
                partidaTempoReal.setaPartidaTempoReal("QUE DEFESA INCRÍVEL DO JOGADOR DA " + timeConcretizado);
            }
            if (nomeSomAtual.equals("epicsave2")) {
                partidaTempoReal.setaPartidaTempoReal("DEFESA FANTÁSTICA DO TIME DA" + timeConcretizado);
            }
            if (nomeSomAtual.equals("goal1")) {
                partidaTempoReal.setaPartidaTempoReal("O time " + timeConcretizado + " fez uma otima jogada com um belo gol!");
                if (timeConcretizado == nomeTimeAtual) {
                    int placarAtual = Integer.parseInt(jlPlacarTime1.getText());
                    placarAtual++;
                    jlPlacarTime1.setText(placarAtual + "");
                } else {
                    int placarAtual = Integer.parseInt(jlPlacarTime2.getText());
                    placarAtual++;
                    jlPlacarTime2.setText(placarAtual + "");
                }
            }
            if (nomeSomAtual.equals("goal2")) {
                partidaTempoReal.setaPartidaTempoReal("QUE GOLAÇO DO TIME DA " + timeConcretizado);
                if (timeConcretizado == nomeTimeAtual) {
                    int placarAtual = Integer.parseInt(jlPlacarTime1.getText());
                    placarAtual++;
                    jlPlacarTime1.setText(placarAtual + "");
                } else {
                    int placarAtual = Integer.parseInt(jlPlacarTime2.getText());
                    placarAtual++;
                    jlPlacarTime2.setText(placarAtual + "");
                }
            }
            if (nomeSomAtual.equals("goal3")) {
                partidaTempoReal.setaPartidaTempoReal("UM BELO WALLDRAG E UM LINDO GOL DA " + timeConcretizado);
                if (timeConcretizado == nomeTimeAtual) {
                    int placarAtual = Integer.parseInt(jlPlacarTime1.getText());
                    placarAtual++;
                    jlPlacarTime1.setText(placarAtual + "");
                } else {
                    int placarAtual = Integer.parseInt(jlPlacarTime2.getText());
                    placarAtual++;
                    jlPlacarTime2.setText(placarAtual + "");
                }
            }

            Player tocador = new Player(arquivoInputStream);
            tocador.play();

        } catch (IOException | JavaLayerException ex) {
            ex.printStackTrace();
        }

    }

    private void iniciaPartida() {
        jlEstadoPartida.setText("A PARTIDA INICIOU E TERMINA EM:");
        jlTempoPartida.setText("30");
        partidaTempoReal.setVisible(true);
        partidaTempoReal.setaNomeTime1(nomeTimeAtual);
        partidaTempoReal.setaNomeTime2(nomeTimeAtual2);
    }

    /**
     * Creates new form ApostaDoDiaRocketLeague
     */
    public ApostaDoDiaRocketLeague() {
        initComponents();
        leArquivosDiretorio();
        geraApostaDia();
        tempoAntesPartida();
        setLocationRelativeTo(this);
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
        jlTime1 = new javax.swing.JLabel();
        jlTime2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbApostarTime1 = new javax.swing.JButton();
        jlApostaTime1 = new javax.swing.JLabel();
        jbApostarTime2 = new javax.swing.JButton();
        jlApostaTime2 = new javax.swing.JLabel();
        jtApostaTime1 = new javax.swing.JTextField();
        jtApostaTime2 = new javax.swing.JTextField();
        jlEstadoPartida = new javax.swing.JLabel();
        jlTempoPartida = new javax.swing.JLabel();
        jlPlacarTime2 = new javax.swing.JLabel();
        jlPlacarTime1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aposta do dia - Rocket League");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("APOSTA DO DIA - ROCKET LEAGUE");

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

        jlEstadoPartida.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlEstadoPartida.setText("Tempo antes da partida começar:");

        jlTempoPartida.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlTempoPartida.setText("20");

        jlPlacarTime2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jlPlacarTime2.setText("0");

        jlPlacarTime1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jlPlacarTime1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jlEstadoPartida)
                        .addGap(18, 18, 18)
                        .addComponent(jlTempoPartida)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbApostarTime1)
                            .addComponent(jlApostaTime1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlPlacarTime1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtApostaTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlApostaTime2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbApostarTime2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtApostaTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlPlacarTime2)
                        .addGap(155, 155, 155))))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(110, 110, 110)
                .addComponent(jlTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtApostaTime1, jtApostaTime2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jlTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jlTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlApostaTime1)
                            .addComponent(jlApostaTime2)
                            .addComponent(jtApostaTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtApostaTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbApostarTime1)
                            .addComponent(jbApostarTime2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEstadoPartida)
                            .addComponent(jlTempoPartida))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPlacarTime2)
                            .addComponent(jlPlacarTime1))
                        .addGap(295, 295, 295))))
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
            java.util.logging.Logger.getLogger(ApostaDoDiaRocketLeague.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApostaDoDiaRocketLeague.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApostaDoDiaRocketLeague.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApostaDoDiaRocketLeague.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApostaDoDiaRocketLeague().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbApostarTime1;
    private javax.swing.JButton jbApostarTime2;
    private javax.swing.JLabel jlApostaTime1;
    private javax.swing.JLabel jlApostaTime2;
    private javax.swing.JLabel jlEstadoPartida;
    private javax.swing.JLabel jlPlacarTime1;
    private javax.swing.JLabel jlPlacarTime2;
    private javax.swing.JLabel jlTempoPartida;
    private javax.swing.JLabel jlTime1;
    private javax.swing.JLabel jlTime2;
    private javax.swing.JTextField jtApostaTime1;
    private javax.swing.JTextField jtApostaTime2;
    // End of variables declaration//GEN-END:variables
}
