public class Cliente implements Runnable {
    private final Conta conta;
    private final Loja[] lojas;
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
                    System.out.println("Cliente comprou R$ " + valorCompra + " na loja" + loja);
                } else {
                    System.out.println("Cliente com saldo insuficiente para comprar R$ " + valorCompra + " na loja" + loja);
                }
                compraIndex = (compraIndex + 1) % compras.length;
            }
            try {
                Thread.sleep(5000); // Simula a compra a cada 5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        new Thread(this).start();
    }
}
