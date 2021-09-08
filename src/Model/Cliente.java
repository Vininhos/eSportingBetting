package Model;

public class Cliente extends Usuario implements InterfacePessoa {

    String usuario;
    String senha;
    float saldo;

    public Cliente(String usuario, String senha, String nome,
            String dataNascimento, String email, String cpf, String genero) {
        super(nome, dataNascimento, email, cpf, genero);
        this.usuario = usuario;
        this.senha = senha;
    }

    public Cliente(String usuario, String senha, float saldo, String nome,
            String dataNascimento, String email, String cpf, String genero) {
        super(nome, dataNascimento, email, cpf, genero);
        this.usuario = usuario;
        this.senha = senha;
        this.saldo = saldo;
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
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
        return "usuario=" + usuario + ", senha=" + senha + '}';
    }
}
