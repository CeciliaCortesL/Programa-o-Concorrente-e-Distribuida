import java.util.Random;

public class Cliente extends Thread {

    private final String nomeCliente;
    private final Conta contaCliente;
    private final Loja[] lojas;
    private final Banco banco;
    private final Random random = new Random();

    public Cliente(String nomeCliente, Conta conta, Loja[] lojas, Banco banco) {
        this.nomeCliente = nomeCliente;
        this.contaCliente = conta;
        this.lojas = lojas;
        this.banco = banco;
    }

    @Override
    public void run() {
        while (contaCliente.getSaldo() > 0) {
            Loja loja = lojas[(int) (Math.random() * lojas.length)];
            double valorCompra = Math.random() < 0.5 ? 100 : 200;

            synchronized (loja) {
                if (contaCliente.getSaldo()>= valorCompra) {
                    banco.transferir(contaCliente, loja.getContaLoja(), valorCompra);
                    System.out.println("Cliente: " + nomeCliente + " - Loja: " + loja.getNomeLoja() + " - Compra: R$ " + valorCompra);
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
