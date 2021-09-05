package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Functions {

    private static Functions INSTANCE;

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

    public boolean verificaCampos(String nome, String email, String usuario, String senha, String cpf, String nascimento) {
        if (nome.length() < 3 || nome.length() > 30 || nome.isEmpty() || !nome.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um nome válido. Máximo de 30 caracteres e no mínimo 3.", "Erro.", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.matches("[\\w]+[\\.]?([\\w]+)?[@]\\w+[\\.]?([\\w]+)?[\\.]?([\\w]+)?[\\.](br|net|com)")
                || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um email válido.", "Erro.", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (usuario.length() < 3 || usuario.length() > 20 || usuario.isEmpty() || !usuario.substring(0, 1).matches("[a-zA-Z]")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um nome de usuário válido. Máximo de 20 caracteres e no mínimo 3. O usuário deve começar com uma letra.",
                    "Erro.", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (senha.length() < 3 || senha.length() > 15 || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite uma senha válida. Máximo de 15 caracteres e no mínimo 3.", "Erro.", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!cpf.matches("[\\d]{11}")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um cpf válido. Somente números e 11 dígitos.", "Erro.", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!nascimento.matches("[\\d]{2}[\\/][\\d]{2}[\\/][\\d]{4}")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite uma data de nascimento válida. Formato: dia/mês/ano Ex:01/01/2000", "Erro.", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public ArrayList<String> gerarStringPDFCliente(ArrayList<ReturnClienteDataDB> RetClienteBD) {
        ArrayList<String> resultBuilder = new ArrayList<>();
        String dataHora;
        float saldoAntigo;
        float saldoNovo;

        for (ReturnClienteDataDB clienteData : RetClienteBD) {
            dataHora = clienteData.getData_hora();
            saldoAntigo = clienteData.getSaldoAntigo();
            saldoNovo = clienteData.getNovoSaldo();

            resultBuilder.add("Aposta realizada na seguinte data e hora: " + dataHora
                    + "\nSeu saldo antes da aposta: "
                    + saldoAntigo + "\nSeu saldo após a aposta: " + saldoNovo
                    + "\nLucro: " + (saldoNovo - saldoAntigo) + "\n\n");

        }
        return resultBuilder;
    }
}
