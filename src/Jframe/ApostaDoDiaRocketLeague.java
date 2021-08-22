package Jframe;

import DAO.eSportBettingDAO;
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
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ApostaDoDiaRocketLeague extends javax.swing.JFrame {

    //Variaveis utilizadas para a classe.
    ArrayList<String> arrayListaTimes;
    ArrayList<String> arrayListaSons;
    PartidaTempoReal partidaTempoReal = new PartidaTempoReal();
    String nomeTimeAtual;
    String nomeTimeAtual2;
    float saldoAtual = 0;
    float saldoApostado = 0;
    float saldoGanhado = 0;
    float saldoPerdido = 0;
    String timeApostado = "";
    String usuario = "";

    /**
     * Creates new form ApostaDoDiaRocketLeague
     */
    public ApostaDoDiaRocketLeague() {
        initComponents();
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
    }

    //Método responsável por iniciar toda a funcionalidade do JFrame.
    public void iniciarFuncionalidades() {
        leArquivosDiretorio();
        geraApostaDia();
        tempoAntesPartida();
    }

    //Método que seta o saldo atual do menu principal para este jframe.
    public void setaSaldoAtual(float saldo) {
        saldoAtual = saldo;
        jlSaldoAtual.setText(saldo + "");
    }

    public void setaUsuarioAtual(String usuario) {
        this.usuario = usuario;
    }

    /*Método que lê e grava em um arraylist todos os nomes do arquivo do
    diretório dos times do Rocket League.*/
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

    //Método simples que desativa os campos desse JFrame.
    private void desativaCampos() {
        jtApostaTime1.setEnabled(false);
        jtApostaTime2.setEnabled(false);
        jtApostaTime1.setText("");
        jtApostaTime2.setText("");
        jbApostarTime1.setEnabled(false);
        jbApostarTime2.setEnabled(false);
    }

    /*Método responsável por gerar aleatoriamente os times que estão no arraylist
    e por colocar as imagens dos mesmos no jframe.*/
    private void geraApostaDia() {

        //Sorteia o time 1 aleatório da pasta e seta no JFrame sua imagem e nome.
        Random geradorNumeroAleatorio = new Random();
        String timeSorteado = arrayListaTimes.get(geradorNumeroAleatorio.nextInt(arrayListaTimes.size()));
        File timeAtual = new File(timeSorteado);
        nomeTimeAtual = timeAtual.getName().replace(".png", "");
        jlApostaTime1.setText(jlApostaTime1.getText().concat(" " + nomeTimeAtual + ":"));
        ImageIcon imagemTimes = new ImageIcon(timeSorteado);
        jlTime1.setIcon(imagemTimes);
        arrayListaTimes.remove(timeSorteado);

        //Sorteia o time 1 aleatório da pasta e seta no JFrame sua imagem e nome.
        String timeSorteado2 = arrayListaTimes.get(geradorNumeroAleatorio.nextInt(arrayListaTimes.size()));
        timeAtual = new File(timeSorteado2);
        nomeTimeAtual2 = timeAtual.getName().replace(".png", "");
        jlApostaTime2.setText(jlApostaTime2.getText().concat(" " + nomeTimeAtual2 + ":"));
        imagemTimes = new ImageIcon(timeSorteado2);
        jlTime2.setIcon(imagemTimes);
    }

    //Thread responsável por gerar a contagem antes de iniciar a partida.
    private void tempoAntesPartida() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    saldoAtual = Float.parseFloat(jlSaldoAtual.getText());
                    for (int i = 5; i > -1; i--) {
                        Thread.sleep(1000);
                        jlTempoPartida.setText(i + "");
                    }
                    //Após o X tempo, inicia a partida e entra na Thread tempoDurantePartida.
                    iniciaPartida();
                    tempoDurantePartida();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    /*Thread responsável por administrar o tempo quando a partida está rolando,
    gerando uma ação de um dos times a cada 5 segundos.*/
    private void tempoDurantePartida() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Contador utilizado para pegar 0 segundo 5, gerando uma ação aleatória na partida.
                    int contadorEvento = 0;
                    desativaCampos();
                    for (int i = 10; i > -1; i--) {
                        contadorEvento += 1;
                        Thread.sleep(1000);
                        jlTempoPartida.setText(i + "");
                        if (contadorEvento == 5) {
                            tocaSomPartida();
                            contadorEvento = 0;
                        }
                    }
                    tocaSomFimPartida();
                    verificaVencedorEPerdedor();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    /*Método utilizado para tocar o som, sendo sorteado através de um número aletório
    pela classe "Random"*/
    private void tocaSomPartida() {

        FileInputStream arquivoInputStream = null;

        Path caminho = Paths.get(System.getProperty("user.dir") + "\\SonsRL");
        DirectoryStream<Path> diretorio;

        try {
            //Pega todos os sons da pasta SonsRL e seta o nome em um array.
            diretorio = Files.newDirectoryStream(caminho);
            arrayListaSons = new ArrayList();

            for (Path file : diretorio) {
                arrayListaSons.add(file.toAbsolutePath().toString());
            }

            //Sorteia som e ação aleatória.
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

            //Verifica o som sorteado.
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
                partidaTempoReal.setaPartidaTempoReal("QUE DEFESA INCRÍVEL DO JOGADOR DA " + timeConcretizado + "!");
            }
            if (nomeSomAtual.equals("epicsave2")) {
                partidaTempoReal.setaPartidaTempoReal("DEFESA FANTÁSTICA DO TIME DA " + timeConcretizado + "!");
            }

            //Caso o som e ação seja de um gol, seta placar também.
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

            //Caso o som e ação seja de um gol, seta placar também.
            if (nomeSomAtual.equals("goal2")) {
                partidaTempoReal.setaPartidaTempoReal("QUE GOLAÇO DO TIME DA " + timeConcretizado + "!");

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

            //Caso o som e ação seja de um gol, seta placar também.
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

            //Toca o som sorteado.
            Player tocador = new Player(arquivoInputStream);
            tocador.play();

        } catch (IOException | JavaLayerException ex) {
            ex.printStackTrace();
        }

    }

    //Método que toca a música no fim da partida.
    private void tocaSomFimPartida() {
        try {
            FileInputStream arquivoInputStream = new FileInputStream(System.getProperty("user.dir") + "\\endgame.mp3");
            Player tocador = new Player(arquivoInputStream);
            tocador.play();
        } catch (IOException | JavaLayerException ex) {
            ex.printStackTrace();
        }
    }

    //Método responsável por iniciar os componentes do começo da partida.
    private void iniciaPartida() {
        jlEstadoPartida.setText("A PARTIDA INICIOU E TERMINA EM:");
        jlTempoPartida.setText("30");
        partidaTempoReal.setVisible(true);
        partidaTempoReal.setaNomeTime1(nomeTimeAtual);
        partidaTempoReal.setaNomeTime2(nomeTimeAtual2);
    }

    /*Método responsável por administrar todas as ações após o fim da partida,
    pintando jLabels e pagando o usuário que apostou corretamente*/
    private void verificaVencedorEPerdedor() {
        int golsTime1 = Integer.parseInt(jlPlacarTime1.getText());
        int golsTime2 = Integer.parseInt(jlPlacarTime2.getText());

        if (golsTime1 == golsTime2) {
            jlFimPartidaTime1.setText("EMPATE");
            jlFimPartidaTime1.setForeground(Color.yellow);
            jlFimPartidaTime2.setText("EMPATE");
            jlFimPartidaTime2.setForeground(Color.yellow);
            partidaTempoReal.setaPartidaTempoReal("O RESULTADO FOI UM EMPATE!");

            if (timeApostado == "time1" || timeApostado == "time2") {
                setaSaldoAtual(saldoAtual + saldoApostado);
            }

        } else if (golsTime1 > golsTime2) {
            jlFimPartidaTime1.setText("VITÓRIA");
            jlFimPartidaTime1.setForeground(Color.green);
            jlFimPartidaTime2.setText("DERROTA");
            jlFimPartidaTime2.setForeground(Color.red);
            partidaTempoReal.setaPartidaTempoReal("QUE BELA VITÓRIA DA " + nomeTimeAtual + "!");

            if (timeApostado == "time1") {

                saldoGanhado += (saldoApostado * 2);
                setaSaldoAtual(saldoAtual + saldoGanhado);
                eSportBettingDAO.getInstance().alteraSaldoCliente(usuario, (saldoAtual + saldoGanhado));

            } else {
                setaSaldoAtual(saldoAtual);
                eSportBettingDAO.getInstance().alteraSaldoCliente(usuario, (saldoAtual));
            }
        } else {

            jlFimPartidaTime1.setText("DERROTA");
            jlFimPartidaTime1.setForeground(Color.red);
            jlFimPartidaTime2.setText("VITÓRIA");
            jlFimPartidaTime2.setForeground(Color.green);
            partidaTempoReal.setaPartidaTempoReal("NOSSO VENCEDOR É O TIME DA " + nomeTimeAtual2 + "!");

            if (timeApostado == "time2") {
                saldoAtual += (saldoApostado * 2);
                setaSaldoAtual(saldoAtual + saldoGanhado);
                eSportBettingDAO.getInstance().alteraSaldoCliente(usuario, (saldoAtual + saldoGanhado));

            } else {
                setaSaldoAtual(saldoAtual);
                eSportBettingDAO.getInstance().alteraSaldoCliente(usuario, (saldoAtual));
            }
        }
    }

    //Método responsável por atualizar os fundos do menu principal.
    public float atualizaFundos() {
        return saldoAtual;
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
        jlFimPartidaTime1 = new javax.swing.JLabel();
        jlFimPartidaTime2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlSaldoAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aposta do dia - Rocket League");
        setResizable(false);

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
        jlTempoPartida.setText("15");

        jlPlacarTime2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jlPlacarTime2.setText("0");

        jlPlacarTime1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jlPlacarTime1.setText("0");

        jlFimPartidaTime1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jlFimPartidaTime2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel3.setText("Saldo atual:");

        jlSaldoAtual.setText("0");

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
                            .addComponent(jlApostaTime1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlSaldoAtual)
                                    .addComponent(jbApostarTime1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtApostaTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlApostaTime2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbApostarTime2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlPlacarTime1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtApostaTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlPlacarTime2)
                        .addGap(155, 155, 155))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(110, 110, 110)
                .addComponent(jlTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jlFimPartidaTime1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlFimPartidaTime2)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPlacarTime2)
                    .addComponent(jlPlacarTime1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFimPartidaTime1)
                    .addComponent(jlFimPartidaTime2))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlApostaTime1)
                    .addComponent(jlApostaTime2)
                    .addComponent(jtApostaTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtApostaTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbApostarTime1)
                    .addComponent(jbApostarTime2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstadoPartida)
                    .addComponent(jlTempoPartida)
                    .addComponent(jLabel3)
                    .addComponent(jlSaldoAtual))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botão que realiza as operações caso o usuário aposte no time 1.
    private void jbApostarTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApostarTime1ActionPerformed
        if (Float.parseFloat(jlSaldoAtual.getText()) < Float.parseFloat(jtApostaTime1.getText())) {
            JOptionPane.showMessageDialog(this, "Aposte um valor válido.");

        } else {
            if (saldoAtual <= 0.0f) {
                JOptionPane.showMessageDialog(null, "Você está sem fundos, adicione mais para poder apostar.");
            } else {
                jtApostaTime1.setEnabled(false);
                saldoApostado = Float.parseFloat(jtApostaTime1.getText());
                jtApostaTime1.setText("");
                jtApostaTime2.setText("");
                jtApostaTime2.setEnabled(false);
                jbApostarTime1.setEnabled(false);
                jbApostarTime2.setEnabled(false);
                timeApostado = "time1";
                saldoAtual -= saldoApostado;
                setaSaldoAtual(saldoAtual);
            }
        }
    }//GEN-LAST:event_jbApostarTime1ActionPerformed

    //Botão que realiza as operações caso o usuário aposte no time 2.
    private void jbApostarTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApostarTime2ActionPerformed
        if (saldoAtual <= 0.0f) {
            JOptionPane.showMessageDialog(null, "Você está sem fundos, adicione mais para poder apostar.");
        } else {

            jtApostaTime1.setEnabled(false);
            saldoApostado = Integer.parseInt(jtApostaTime2.getText());
            jtApostaTime1.setText("");
            jtApostaTime2.setText("");
            jtApostaTime2.setEnabled(false);
            jbApostarTime1.setEnabled(false);
            jbApostarTime2.setEnabled(false);
            timeApostado = "time2";
            saldoAtual -= saldoApostado;
            setaSaldoAtual(saldoAtual);
        }
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbApostarTime1;
    private javax.swing.JButton jbApostarTime2;
    private javax.swing.JLabel jlApostaTime1;
    private javax.swing.JLabel jlApostaTime2;
    private javax.swing.JLabel jlEstadoPartida;
    private javax.swing.JLabel jlFimPartidaTime1;
    private javax.swing.JLabel jlFimPartidaTime2;
    private javax.swing.JLabel jlPlacarTime1;
    private javax.swing.JLabel jlPlacarTime2;
    private javax.swing.JLabel jlSaldoAtual;
    private javax.swing.JLabel jlTempoPartida;
    private javax.swing.JLabel jlTime1;
    private javax.swing.JLabel jlTime2;
    private javax.swing.JTextField jtApostaTime1;
    private javax.swing.JTextField jtApostaTime2;
    // End of variables declaration//GEN-END:variables
}
