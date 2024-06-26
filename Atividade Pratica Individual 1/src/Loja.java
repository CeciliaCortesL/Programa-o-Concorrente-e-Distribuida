public class Loja {
    private final String nomeLoja;
    private final Conta contaLoja;
    private final Funcionario[] funcionarios;


    public Loja(String nomeLoja, Conta contaLoja, Funcionario[] funcionarios) {
        this.nomeLoja = nomeLoja;
        this.contaLoja = contaLoja;
        this.funcionarios = funcionarios;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public Conta getContaLoja() {
        return contaLoja;
    }

    public void pagarFuncionarios() {
        System.out.println("==========================================================================");
        System.out.println("===               Pagamento dos funcionários da loja: " + nomeLoja + "           ===");
        System.out.println("==========================================================================");
        synchronized(contaLoja){
            for (Funcionario funcionario : funcionarios) {
                if (contaLoja.getSaldo() >= Funcionario.getSalario()) {
                    contaLoja.depositar(Funcionario.getSalario());
                    System.out.println("Funcionário: " + funcionario.getNome() + " - Loja: " + nomeLoja + " - Salário recebido: R$ " + Funcionario.getSalario());
                }
            }
        }
    }
}
