package DAO;

import Model.Administrador;
import Model.Cliente;
import Model.PesquisaSatisfacaoObject;
import Util.PropertiesHandler;
import Util.ReturnClienteDataDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class eSportBettingDAO {

    private String url;
    private String usuario;
    private String senha;
    private Connection con;

    PropertiesHandler propertiesHandler = new PropertiesHandler();

    public eSportBettingDAO() {
    }

    private static eSportBettingDAO INSTANCE;

    /**
     * Método por gerenciar o Singleton do objeto DAO.
     *
     * @return retorna uma nova instância, caso não existe. Se existir, retorna
     * a existente.
     */
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

    /**
     * Método por verificar se uma conexão com o banco de dados já existe.
     *
     * @return retorna true caso já exista uma conexão aberta. False para uma
     * conexão inexistente
     */
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

    /**
     * Método por iniciar uma conexão com o banco de dados.
     *
     */
    public void iniciarConexao() {
        try {
            if (!verificaConexao()) {
                ArrayList<String> dbParams = propertiesHandler.getParamsDBConnectionProperties();
                url = dbParams.get(0);
                usuario = dbParams.get(1);
                senha = dbParams.get(2);

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

    public boolean realizarConexaoTeste(String banco, int porta, String usuario, String senha) {
        try {
            if (!verificaConexao()) {

                String url = "jdbc:postgresql://localhost:" + porta + "/" + banco;

                Class.forName("org.postgresql.Driver");

                con = DriverManager.getConnection(url, usuario, senha);

                con.close();

                JOptionPane.showMessageDialog(null, "Conexão de teste com o banco de dados realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                return true;

            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve um problema na conexão. Verifique seus dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Método por adicionar um cliente no banco de dados.
     *
     * @param cliente objeto Cliente criado a partir do JFrame do cadastro de
     * Cliente.
     *
     * @return retorna um inteiro, sendo o valor 0 para sucesso e 1 para erro.
     */
    public int adicionarClienteDAO(Cliente cliente) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();

            String query = "insert into cliente values (default,'"
                    + cliente.getUsuario()
                    + "','" + cliente.getSenha()
                    + "',10,'" + cliente.getNome()
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

    /**
     * Método por adicionar um administrador no banco de dados.
     *
     * @param admin objeto Cliente criado a partir do JFrame do cadastro de
     * Cliente.
     *
     * @return retorna um inteiro, sendo o valor 0 para sucesso e 1 para erro.
     */
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

    /**
     * Método por verificar qual o tipo de login que será utilizado, seja
     * cliente ou admin, e por fim, realiza a captura do nome do usuário
     * informado. Verificamos principalmente se o usuário existe no banco de
     * dados.
     *
     * @param usuario usuario informado na tela de login.
     * @param senha senha informada na tela de login.
     * @param tipoUsuario tipo de usuário selecionado na tela de login.
     * @return retorna um inteiro, sendo o valor 0 para sucesso e 1 para erro.
     */
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

    /**
     * Método responsável por retornar todos os parâmetros do cliente informado
     * na tela de login, após a verificação da existência do mesmo.
     *
     *
     * @param usuario usuario informado na tela de login.
     *
     * @param senha senha informada na tela de login.
     *
     * @return retorna um objeto do tipo cliente, através das informações do
     * banco de dados.
     */
    public Cliente returnParametrosCliente(String usuario, String senha) {
        try {

            iniciarConexao();
            Cliente cliente = null;
            Statement statement = con.createStatement();

            String query = "select usuario, senha, saldo, nome, datanascimento, email, cpf, genero from cliente "
                    + "where usuario = '" + usuario + "' and senha = '" + senha + "';";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                cliente = new Cliente(
                        res.getString("usuario"),
                        res.getString("senha"),
                        res.getFloat("saldo"),
                        res.getString("nome"),
                        res.getString("datanascimento"),
                        res.getString("email"),
                        res.getString("cpf"),
                        res.getString("genero")
                );
            }

            con.close();

            return cliente;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Método responsável por retornar todos os parâmetros do administrador
     * informado na tela de login, após a verificação da existência do mesmo.
     *
     *
     * @param usuario usuario informado na tela de login.
     *
     * @param senha senha informada na tela de login.
     *
     * @return retorna um objeto do tipo cliente, através das informações do
     * banco de dados.
     */
    public Administrador returnParametrosAdministrador(String usuario, String senha) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();
            Administrador admin = null;

            String query = "select usuario, senha, nome, datanascimento, email, cpf, genero from administrador "
                    + "where usuario = '" + usuario + "' and senha = '" + senha + "';";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                admin = new Administrador(
                        res.getString("usuario"),
                        res.getString("senha"),
                        res.getString("nome"),
                        res.getString("datanascimento"),
                        res.getString("email"),
                        res.getString("cpf"),
                        res.getString("genero")
                );
            }

            con.close();

            return admin;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Método por retornar o saldo atual do cliente logado atualmente.
     *
     *
     * @param usuario usuario atual logado.
     *
     * @return retorna o saldo do usuario atual.
     */
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

    /**
     * Método por retornar todos os dados relacionados a seus ganhos e perca no
     * sistema.
     *
     *
     * @param usuario usuario logado atualmente.
     *
     * @return retorna ArrayList com todos os ganhos e percas do cliente.
     */
    public ArrayList<ReturnClienteDataDB> retornaDadosClienteRelatorio(String usuario) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();
            ReturnClienteDataDB returnCliente = null;
            String query = null;

            if (usuario.isEmpty()) {
                query = "select usuario, substring(cast(data_hora as varchar), 0, 20) as data_hora, saldoantigo, novosaldo from auditacliente order by data_hora asc";

            } else {
                query = "select usuario, substring(cast(data_hora as varchar), 0, 20) as data_hora, saldoantigo, novosaldo from auditacliente where usuario = '"
                        + usuario + "' and operacao = 'UPDATE';";
            }

            ResultSet res = statement.executeQuery(query);
            ArrayList<ReturnClienteDataDB> dadosCliente = new ArrayList<>();

            while (res.next()) {
                returnCliente = new ReturnClienteDataDB(
                        res.getString("usuario"),
                        res.getString("data_hora"),
                        res.getFloat("saldoantigo"),
                        res.getFloat("novosaldo")
                );

                dadosCliente.add(returnCliente);
            }

            con.close();

            return dadosCliente;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Método por retornar todos os dados de todos os clientes cadastrados no
     * banco de dados.
     *
     *
     *
     * @return retorna um ArrayList com todos os dados de todos os clientes.
     */
    public ArrayList<ReturnClienteDataDB> retornaTodosOsDadosClientesRelatorio() {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();
            ReturnClienteDataDB returnCliente = null;

            String query = "select usuario, substring(cast(data_hora as varchar), 0, 20) as data_hora, saldoantigo, novosaldo from auditacliente order by data_hora asc;";

            ResultSet res = statement.executeQuery(query);
            ArrayList<ReturnClienteDataDB> dadosCliente = new ArrayList<ReturnClienteDataDB>();

            while (res.next()) {
                returnCliente = new ReturnClienteDataDB(
                        res.getString("usuario"),
                        res.getString("data_hora"),
                        res.getFloat("saldoantigo"),
                        res.getFloat("novosaldo")
                );

                dadosCliente.add(returnCliente);
            }

            con.close();

            return dadosCliente;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public int inserePesquisaSatisfacao(String usuario, PesquisaSatisfacaoObject pesquisaSatisfacaoObject) {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();

            String query = "insert into pesquisasatisfacao(select retornaIdCliente('" + usuario + "'), "
                    + pesquisaSatisfacaoObject.getPontosPergunta1() + ", " + pesquisaSatisfacaoObject.getPontosPergunta2()
                    + ", " + pesquisaSatisfacaoObject.getPontosPergunta3() + ", "
                    + pesquisaSatisfacaoObject.getPontosPergunta4() + ", " + pesquisaSatisfacaoObject.getPontosPergunta5() + ");";

            int res = statement.executeUpdate(query);

            con.close();

            return 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    public int returnQtdRegistrosPesquisaSatisfacao() {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();

            String query = "select count(*) as qtdpesquisas from pesquisasatisfacao;";

            ResultSet res = statement.executeQuery(query);

            con.close();

            while (res.next()) {
                return res.getInt("qtdpesquisas");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    public PesquisaSatisfacaoObject returnDadosPesquisaSatisfacao() {
        try {

            iniciarConexao();

            Statement statement = con.createStatement();

            String query = "select sum(pontospergunta1) as somapontos1, sum(pontospergunta2)as somapontos2, sum(pontospergunta3)as somapontos3, "
                    + "sum(pontospergunta4) as somapontos4, sum(pontospergunta5) as somapontos5 from pesquisasatisfacao;";

            ResultSet res = statement.executeQuery(query);

            PesquisaSatisfacaoObject pso = null;

            while (res.next()) {
                pso = new PesquisaSatisfacaoObject(
                        res.getInt("somapontos1"),
                        res.getInt("somapontos2"),
                        res.getInt("somapontos3"),
                        res.getInt("somapontos4"),
                        res.getInt("somapontos5")
                );
            }

            con.close();

            return pso;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
