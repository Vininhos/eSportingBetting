package Class;

/**
 *
 * @author vinni
 */
public class ReturnClienteDataDB {

    private String data_hora;
    private float saldoAntigo;
    private float novoSaldo;

    public ReturnClienteDataDB(String data_hora, float saldoAntigo, float novoSaldo) {
        this.data_hora = data_hora;
        this.saldoAntigo = saldoAntigo;
        this.novoSaldo = novoSaldo;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public float getSaldoAntigo() {
        return saldoAntigo;
    }

    public void setSaldoAntigo(float saldoAntigo) {
        this.saldoAntigo = saldoAntigo;
    }

    public float getNovoSaldo() {
        return novoSaldo;
    }

    public void setNovoSaldo(float novoSaldo) {
        this.novoSaldo = novoSaldo;
    }

}
