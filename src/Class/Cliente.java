package Class;

import java.io.Serializable;

public class Cliente extends Usuario implements InterfacePessoa, Serializable {

    int idCliente;
    String usuario;
    String senha;
    float saldo;

    public Cliente(int idCliente, String usuario, String senha, float saldo, String nome, int diaNasc, int mesNasc, int anoNasc, String email, String cpf, String genero) {
        super(nome, diaNasc, mesNasc, anoNasc, email, cpf, genero);
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.senha = senha;
        this.saldo = saldo;
    }

    @Override
    public void criaUsuario() {

    }

}
