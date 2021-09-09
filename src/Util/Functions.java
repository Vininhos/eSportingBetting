package Util;

import DAO.eSportBettingDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Functions {

    private static Functions INSTANCE;

    /**
     * Método para realizar a criação e gerenciamento do Singleton.
     *
     * @return retorna uma nova instância, caso não existe. Se existir, retorna
     * a existente.
     */
    public static Functions getInstance() {
        if (INSTANCE == null) {
            synchronized (Functions.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Functions();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Método responsável por converter a data recebida das telas de cadastro,
     * para tratar o formato aceito pelo PostgreSQL.
     *
     * @param dataNascimento recebe a data de nascimento informada na tela de
     * cadastro
     * @return retorna uma data formatada para posteriormente ser armazenada no
     * banco de dados, respeitando o formato único do PostgreSQL (yyyy-MM-dd).
     */
    public String converterData(String dataNascimento) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Date data = formato.parse(dataNascimento);

            formato.applyPattern("yyyy-MM-dd");

            return formato.format(data);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Método responsável por gerenciar os campos das telas de login, fazendo
     * diversas verificações para garantir dados corretos.
     */
    public boolean verificaCampos(String nome, String email, String usuario, String senha, String cpf, String nascimento) {
        if (nome.length() < 3 || nome.length() > 30 || nome.isEmpty() || !nome.matches("([a-zA-Z]+)([\\s])?([a-zA-Z]*)?([\\s]?)([a-zA-Z]*)?([\\s])?")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um nome válido. Máximo de 30 caracteres e no mínimo 3.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.matches("[\\w]+[\\.]?([\\w]+)?[@]\\w+[\\.]?([\\w]+)?[\\.]?([\\w]+)?[\\.](br|net|com)")
                || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um email válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (usuario.length() < 3 || usuario.length() > 20 || usuario.isEmpty() || !usuario.substring(0, 1).matches("[a-zA-Z]")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um nome de usuário válido. Máximo de 20 caracteres e no mínimo 3. O usuário deve começar com uma letra.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (senha.length() < 3 || senha.length() > 15 || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite uma senha válida. Máximo de 15 caracteres e no mínimo 3.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!cpf.matches("[\\d]{11}")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um cpf válido. Somente números e 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!nascimento.matches("[\\d]{2}[\\/][\\d]{2}[\\/][\\d]{4}")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite uma data de nascimento válida. Formato: dia/mês/ano Ex:01/01/2000", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Método responsável por gerar uma String com todas as informações do
     * cliente no banco de dados.
     *
     * @param retClienteBD recebe um ArrayList com todas as informações do
     * clientes capturadas do banco de dados.
     * @return retorna uma String bem formatada com todos os dados do banco.
     */
    public ArrayList<String> generateStringPDFCliente(ArrayList<ReturnClienteDataDB> retClienteBD) {

        ArrayList<String> resultBuilder = new ArrayList<>();
        String usuario;
        String dataHora;
        float saldoAntigo;
        float saldoNovo;

        for (ReturnClienteDataDB clienteData : retClienteBD) {

            usuario = clienteData.getUsuario();
            resultBuilder.add("Usuario: " + usuario + "\n");

            dataHora = clienteData.getData_hora();
            saldoAntigo = clienteData.getSaldoAntigo();
            saldoNovo = clienteData.getNovoSaldo();

            resultBuilder.add("Aposta/Depósito realizada na seguinte data e hora: " + dataHora
                    + "\nSeu saldo antes da aposta/depósito: "
                    + saldoAntigo + "\nSeu saldo após a aposta/depósito: " + saldoNovo
                    + "\nLucro/depósito: " + (saldoNovo - saldoAntigo) + "\n\n");

        }

        return resultBuilder;

    }

    /**
     * Método por gerar um arquivo .pdf com todos os dados do cliente.
     *
     * @param usuario recebe um usuário, se for passado na chamada do método,
     * responsável por buscar os registros de um único usuário. Caso seja
     * informado uma string vazia, será retornado os dados de todos os usuários.
     */
    public void generatePDFCliente(String usuario) {

        try {

            Document pdf = new Document();
            String targetDirectory = System.getProperty("user.dir") + "\\Relatorios";

            PdfWriter.getInstance(pdf, new FileOutputStream(targetDirectory + "\\Relatorio Geral " + usuario + ".pdf"));

            pdf.open();

            ArrayList<String> retProcessedCliente = null;

            if (usuario.isEmpty()) {
                pdf.addTitle("Relatório dos usuários");

                retProcessedCliente = Functions.getInstance().generateStringPDFCliente(
                        eSportBettingDAO.getInstance().retornaTodosOsDadosClientesRelatorio());

                pdf.add(new Paragraph("Relatório de todos os usuários:", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK)));

            } else {
                pdf.addTitle("Relatório do usuário " + usuario);

                retProcessedCliente = Functions.getInstance().generateStringPDFCliente(
                        eSportBettingDAO.getInstance().retornaDadosClienteRelatorio(usuario));

                String paragrafo = "Relatório do usuário " + usuario;
                pdf.add(new Paragraph(paragrafo, FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK)));
            }

            pdf.addAuthor("eSportingBetting");

            pdf.add(new Paragraph("\nTransações:\n"));

            for (String dadosClienteProcessados : retProcessedCliente) {
                pdf.add(new Paragraph(dadosClienteProcessados));
            }

            pdf.close();

            JOptionPane.showMessageDialog(null,
                    "O Relatório PDF foi gerado no diretório onde está localizado o eSportingBetting. (diretório do projeto)",
                    "Relatório Gerado", JOptionPane.INFORMATION_MESSAGE);

            Runtime.getRuntime().exec("explorer " + targetDirectory);
        } catch (IOException | DocumentException ex) {
            ex.printStackTrace();

        }
    }

    /**
     * Método responsável por verificar se o arquivo .properties do banco de
     * dados existe.
     *
     */
    public void createDBConnectionProperties() {

        try {
            File dbProp = new File(System.getProperty("user.dir") + "\\src\\Resources\\dbconnection.properties");

            if (!dbProp.exists()) {
                dbProp.createNewFile();
            }

        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método responsável por gerar retornar um novo arquivo .properties para
     * conexão do banco de dados.
     *
     * @return retorna o novo arquivo .properties.
     */
    public File returnNewDbConnectionProperties() {
        File file = null;

        try {
            file = new File(System.getProperty("user.dir") + "\\src\\Resources\\dbconnection.properties");

            if (file.exists()) {
                file.delete();
            }

            file.createNewFile();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return file;
    }

    /**
     * Método responsável por criar um diretório para armazenar o arquivo
     * .properties, caso não exista.
     *
     * @return true se o diretório já existe, falso se não existir.
     */
    public boolean createDirIfDbPropertiesDirNotExists() {
        File dbPropertiesDir = new File(System.getProperty("user.dir") + "\\src\\Resources");

        if (!dbPropertiesDir.exists()) {
            dbPropertiesDir.mkdir();
            createDBConnectionProperties();
            return false;
        }
        return true;
    }

    /**
     * Metódo responsável por criar um diretório para os relatórios, caso o
     * mesmo não exista.
     */
    public void createDirRelatorio() {
        File relatorioDir = new File(System.getProperty("user.dir") + "\\Relatorios");

        if (!relatorioDir.exists()) {
            relatorioDir.mkdir();
        }
    }
}
