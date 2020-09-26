package Class;

public class Cliente extends Usuario implements InterfacePessoa{

    int idCliente;
    String usuario;
    String senha;
    float saldo;

    public Cliente(String nome, int diaNasc, int mesNasc, int anoNasc, String email, String cpf, String genero) {
        super(nome, diaNasc, mesNasc, anoNasc, email, cpf, genero);
    }

    @Override
    public void criaUsuario() {
        
    }

}
