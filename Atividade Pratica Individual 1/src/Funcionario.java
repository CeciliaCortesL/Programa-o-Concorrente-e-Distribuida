public class Funcionario extends Thread{
    private final String nomeFuncionario;
    private final Conta contaCorrente;
    private final Conta contaInvestimento;
    private final static double salarioFuncionario = 1400;

    public Funcionario(String nomeFuncionario, Conta contaCorrente, Conta contaInvestimento) {
        this.nomeFuncionario = nomeFuncionario;
        this.contaCorrente = contaCorrente;
        this.contaInvestimento = contaInvestimento;
    }

    public Funcionario(Loja loja) {
        this.nomeFuncionario = "";
        this.contaCorrente = null;
        this.contaInvestimento = null;
    }

    @Override
    public void run() {
        contaCorrente.depositar(1400);
        int valorInvestimento = (int) (salarioFuncionario * 0.2);
        contaInvestimento.depositar(valorInvestimento);
        System.out.println("Funcionário: " + nomeFuncionario + " - Salário recebido: R$ " + salarioFuncionario + " - Investimento: R$ " + valorInvestimento);
    }

    public String getNome() {
        return nomeFuncionario;
    }

    public static double getSalario() {
        return salarioFuncionario;
    }
}
