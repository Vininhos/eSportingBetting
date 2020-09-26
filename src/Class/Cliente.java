package Class;

public class Cliente extends Usuario implements InterfacePessoa{

    int id;

    public Cliente(String nome, int diaNasc, int mesNasc, int anoNasc, String email, String cpf, String genero) {
        super(nome, diaNasc, mesNasc, anoNasc, email, cpf, genero);
    }

    @Override
    public void criaUsuario() {
        
    }

}
