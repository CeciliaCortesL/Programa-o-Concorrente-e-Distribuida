public class Conta {
    private String tipoConta;
    private int saldo;

    public Conta(String tipoConta, int saldoInicial) {
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double valor) {
        saldo+=valor;
    }

    public synchronized void sacar(double valor) {
        saldo-=valor;
    }

    public String getNomeConta() {
        return tipoConta;
    }

    public int getSaldo() {
        return saldo;
    }
}
