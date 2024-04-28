public class Funcionario extends Thread{
    private final String nomeFuncionario;
    private final Conta contaSalario;
    private final Conta contaInvestimento;
    private final static double salarioFuncionario = 1400;

    public Funcionario(String nomeFuncionario, Conta contaSalario, Conta contaInvestimento) {
        this.nomeFuncionario = nomeFuncionario;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    public Funcionario(Loja loja) {
        this.nomeFuncionario = "";
        this.contaSalario = null;
        this.contaInvestimento = null;
    }

    @Override
    public void run() {
        contaSalario.depositar(1400);
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
