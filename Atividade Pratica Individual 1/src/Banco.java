import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final Lock lock= new ReentrantLock();

    public synchronized void transferir(Conta origem, Conta destino, double valorCompra) {
        lock.lock();
        try{
            if (origem.getSaldo() >= valorCompra) {
                origem.sacar(valorCompra);
                destino.depositar(valorCompra);
                System.out.println("Conta Origem: " + origem.getNomeConta() + " - Conta destino: " + destino.getNomeConta() +  " - Valor transferência: R$ " + valorCompra);
            }
            else{
                System.out.println("Saldo insuficiente. Conta: " + origem.getNomeConta());
            }
        } finally {
            lock.unlock();
        }
    }

    public void exibirSaldos(Conta[] contas) {
        System.out.println("==========================================================================");
        System.out.println("===                       Saldo das contas:                            ===");
        System.out.println("==========================================================================");
        for (Conta conta : contas) {
            System.out.println("Conta: " + conta.getNomeConta() + " - Saldo R$: " + conta.getSaldo());
        }
    }
}
