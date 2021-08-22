package DAO;

import Class.Administrador;
import Class.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class eSportBettingDAO {

    private String url;
    private String usuario;
    private String senha;
    private Connection con;

    public eSportBettingDAO() {
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        senha = "IRa@@123dd";
    }

    private static eSportBettingDAO INSTANCE;

    public static eSportBettingDAO getInstance() {
        if (INSTANCE == null) {
            synchronized (eSportBettingDAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new eSportBettingDAO();
                }
            }
        }
        return INSTANCE;
    }

    public boolean verificaConexao() {
        try {
            if (con == null) {
                return false;
            } else if (con.isClosed()) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public void iniciarConexao() {
        try {
            if (!verificaConexao()) {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, usuario, senha);
                System.out.println("Conexão estabelecida com sucesso." + "\n");
            } else {
                System.out.println("A conexão já está estabelecida." + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int adicionarClienteDAO(Cliente cliente) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();

            String query = "insert into cliente values (default,'"
                    + cliente.getUsuario()
                    + "','" + cliente.getSenha()
                    + "',0,'" + cliente.getNome()
                    + "','" + cliente.getDataNascimento()
                    + "','" + cliente.getEmail() + "','"
                    + cliente.getCpf() + "','"
                    + cliente.getGenero().toUpperCase() + "');";

            int res = statement.executeUpdate(query);

            con.close();

            return res;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    public int adicionarAdminDAO(Administrador admin) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();

            String query = "insert into administrador values (default,'"
                    + admin.getUsuario()
                    + "','" + admin.getSenha()
                    + "','" + admin.getNome()
                    + "','" + admin.getDataNascimento()
                    + "','" + admin.getEmail() + "','"
                    + admin.getCpf() + "','"
                    + admin.getGenero().toUpperCase() + "');";

            int res = statement.executeUpdate(query);

            con.close();

            return res;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    public String verificarLoginDAO(String usuario, String senha, String tipoUsuario) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();
            String query = "";
            String result = null;

            if (tipoUsuario == "Cliente") {
                query = "select nome from cliente "
                        + "where usuario = '" + usuario + "' and senha = '" + senha + "';";
            } else {
                query = "select nome from administrador "
                        + "where usuario = '" + usuario + "' and senha = '" + senha + "';";
            }

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                result = res.getString("nome");
            }

            con.close();

            return result;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Cliente returnParametrosCliente(String usuario, String senha) {
        try {

            iniciarConexao();
            Cliente cliente = null;
            Statement statement = con.createStatement();

            String query = "select usuario, senha, saldo, nome, datanascimento, email, cpf, genero from cliente "
                    + "where usuario = '" + usuario + "' and senha = '" + senha + "';";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                cliente = new Cliente(res.getString("usuario"),
                        res.getString("senha"),
                        res.getFloat("saldo"),
                        res.getString("nome"),
                        res.getString("datanascimento"),
                        res.getString("email"),
                        res.getString("cpf"),
                        res.getString("genero"));
            }

            con.close();

            return cliente;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Administrador returnParametrosAdministrador(String usuario, String senha) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();
            Administrador admin = null;

            String query = "select usuario, senha, nome, datanascimento, email, cpf, genero from administrador "
                    + "where usuario = '" + usuario + "' and senha = '" + senha + "';";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                admin = new Administrador(res.getString("usuario"),
                        res.getString("senha"),
                        res.getString("nome"),
                        res.getString("datanascimento"),
                        res.getString("email"),
                        res.getString("cpf"),
                        res.getString("genero"));
            }

            con.close();

            return admin;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public float retornaSaldoCliente(String usuario) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();
            float result = 0;

            String query = "select saldo from cliente "
                    + "where usuario = '" + usuario + "';";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                result = res.getFloat("saldo");
            }

            con.close();

            return result;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public float alteraSaldoCliente(String usuario, float valor) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();
            float result = 0;

            String query = "update cliente set saldo =" + valor
                    + " where usuario = '" + usuario + "';";

            int res = statement.executeUpdate(query);

            con.close();

            return res;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }
}
