package Class;

/**
 *
 * @author vinni
 */
public class DBConnectionParams {

    private String nomeBanco;
    private int portaBanco;
    private String usuario;
    private String senha;

    public DBConnectionParams(String nomeBanco, int portaBanco, String usuario, String senha) {
        this.nomeBanco = nomeBanco;
        this.portaBanco = portaBanco;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String generateURL() {
        return "jdbc:postgresql://localhost:" + this.portaBanco + "/" + this.nomeBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

}
