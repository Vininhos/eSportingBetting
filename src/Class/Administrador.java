package Class;

public class Administrador extends Usuario implements InterfacePessoa{

    int id;

    public Administrador(String nome, int diaNasc, int mesNasc, int anoNasc, String email, String cpf, String genero) {
        super(nome, diaNasc, mesNasc, anoNasc, email, cpf, genero);
    }
    


    @Override
    public void criaUsuario() {
        
    }

}
