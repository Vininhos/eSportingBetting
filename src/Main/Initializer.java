package Main;

import Jframe.ConexaoComBancoSQL;
import Jframe.TelaLogin;
import Util.Functions;
import Util.LookAndFeelHandler;
import java.io.File;

/**
 *
 * @author vinni
 */
public class Initializer {

    public static void main(String[] args) {
        
        LookAndFeelHandler.ativarNimbus();

        File dbProperties = new File(System.getProperty("user.dir") + "\\src\\Resources\\dbconnection.properties");

        if (!Functions.getInstance().createDirIfDbPropertiesDirNotExists() || !dbProperties.exists()) {

            ConexaoComBancoSQL conexaoComBancoSQL = new ConexaoComBancoSQL();
            conexaoComBancoSQL.setVisible(true);

        } else {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        }
    }
}
