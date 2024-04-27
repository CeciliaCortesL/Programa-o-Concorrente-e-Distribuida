import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private double saldo;
    private final Lock lock = new ReentrantLock();

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitar(double valor) {
        lock.lock();
        try {
            saldo -= valor;
            System.out.println("Valor debitado da conta: R$ " + valor);
            System.out.println("Saldo atual da conta: R$ " + saldo);
        } finally {
            lock.unlock();
        }
    }

    public void creditar(double valor) {
        lock.lock();
        try {
            saldo += valor;
            System.out.println("Valor creditado da conta: R$ " + valor);
            System.out.println("Saldo atual da conta: R$ " + saldo);
        } finally {
            lock.unlock();
        }
    }
}