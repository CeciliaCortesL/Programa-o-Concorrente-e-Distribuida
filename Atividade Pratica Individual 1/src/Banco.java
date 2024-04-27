import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final Lock lock= new ReentrantLock();

    public synchronized void transferir(Conta origem, Conta destino, double valorDaCompra) {
        lock.lock();
        try{
            if (origem.getSaldo() >= valorDaCompra) {
                origem.sacar(valorDaCompra);
                destino.depositar(valorDaCompra);
                System.out.println("Valor transferência: R$ " + valorDaCompra + " Conta origem: " + origem.getNomeConta() + " Conta destino: " + destino.getNomeConta());
            }
            else{
                System.out.println("Saldo insuficiente. Conta: " + origem.getNomeConta());
            }
        } finally {
            lock.unlock();
        }
    }

    public void exibirSaldosFinais(Conta[] contas){
        System.out.println("Saldo das contas: ");
        for (Conta conta : contas) {
            System.out.println("Conta: " + conta.getNomeConta() + " Saldo R$: " + conta.getSaldo());
        }
    }
}
