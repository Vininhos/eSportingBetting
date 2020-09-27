package Class;

public class Administrador extends Usuario implements InterfacePessoa {

    int idAdmin;
    String usuario;
    String senha;

    public Administrador(int idAdmin, String usuario, String senha, String nome, int diaNasc, int mesNasc, int anoNasc, String email, String cpf, String genero) {
        super(nome, diaNasc, mesNasc, anoNasc, email, cpf, genero);
        this.idAdmin = idAdmin;
        this.usuario = usuario;
        this.senha = senha;
        this.cpf = cpf;
    }

    @Override
    public void criaUsuario() {

    }

}
