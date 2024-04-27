public class Funcionario {
    private final Loja loja;
    private final Conta salarioConta;
    private final Conta investimentoConta;

    public Funcionario(Loja loja) {
        this.loja = loja;
        this.salarioConta = new Conta(0);
        this.investimentoConta = new Conta(0);
    }

    @Override
    public void run() {
        while (true) {
            loja.pagarFuncionario();
            double salario = 1400;
            salarioConta.creditar(salario);
            double valorInvestimento = salario * 0.2;
            salarioConta.debitar(valorInvestimento);
            investimentoConta.creditar(valorInvestimento);
            try {
                Thread.sleep(1000); // Simula o pagamento a cada segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }    
}
