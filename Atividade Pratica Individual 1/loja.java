import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Loja {
    private final conta conta;
    private final double salarioFuncionario = 1400;

    public Loja(double saldoInicial) {
        this.conta = new conta(saldoInicial);
    }

    public void pagarFuncionario() {
        if (conta.getSaldo() >= salarioFuncionario) {
            conta.debitar(salarioFuncionario);
            System.out.println("Funcionário pago: R$ " + salarioFuncionario);
        }
    }

    public void receberPagamento(double valor) {
        conta.creditar(valor);
    }
}