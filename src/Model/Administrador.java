package Model;

public class Administrador extends Usuario implements InterfacePessoa {

    String usuario;
    String senha;

    public Administrador(String usuario, String senha, String nome,
            String dataNascimento, String email, String cpf, String genero) {
        super(nome, dataNascimento, email, cpf, genero);
        this.usuario = usuario;
        this.senha = senha;
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String lerDados() {
        return toString();
    }

    @Override
    public String toString() {
        return "Administrador{" + ", usuario=" + usuario + ", senha=" + senha + '}';
    }

}
