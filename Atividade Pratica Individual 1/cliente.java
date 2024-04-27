public class Cliente extends Thread {
    private final Conta conta;
    private final Loja[] lojas = new Loja[2];
    private final double[] compras = { 100, 200 };
    private int compraIndex = 0;

    public Cliente(Conta conta, Loja[] lojas) {
        this.conta = conta;
        this.lojas = lojas;
    }

    @Override
    public void run() {
        while (true) {
            double valorCompra = compras[compraIndex];
            Loja loja = lojas[compraIndex % lojas.length];
            synchronized (loja) {
                if (conta.getSaldo() >= valorCompra) {
                    conta.debitar(valorCompra);
                    loja.receberPagamento(valorCompra);
                    System.out.println("Cliente comprou na loja " + loja);
                } else {
                    System.out.println("Cliente sem saldo para comprar na loja " + loja);
                }
                compraIndex = (compraIndex + 1) % compras.length;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}