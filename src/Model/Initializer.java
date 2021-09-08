package Model;

import Jframe.ConexaoComBancoSQL;
import Jframe.TelaLogin;
import Util.Functions;

/**
 *
 * @author vinni
 */
public class Initializer {

    public static void main(String[] args) {

        if (!Functions.getInstance().verifyIfDBConnectionPropertiesExists()) {
            ConexaoComBancoSQL conexaoComBancoSQL = new ConexaoComBancoSQL();
            conexaoComBancoSQL.setVisible(true);

        } else {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        }
    }
}
