public class Loja {
    private final Conta conta;
    private final double salarioFuncionario = 1400;

    public Loja(double saldoInicial) {
        this.conta = new Conta(saldoInicial);
    }

    public void pagarFuncionario() {
        if (conta.getSaldo() >= salarioFuncionario) {
            conta.debitar(salarioFuncionario);
            System.out.println("Funcionário pago: R$ " + salarioFuncionario);
            System.out.println("Saldo atual da conta da loja: R$ " + conta.getSaldo());
        } else {
            System.out.println("Saldo insuficiente para pagar o funcionário!");
        }
    }

    public void receberPagamento(double valor) {
        conta.creditar(valor);
    }    
}