public class SistemaBancario {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        Conta contaL1 = new Conta("Conta Corrente", 0);
        Conta contaL2 = new Conta("Poupança", 0);

        Funcionario funcionario1L1 = new Funcionario("Ana Luisa", contaL1, null);
        Funcionario funcionario2L1 = new Funcionario("Pedro Curi", contaL1, null);
        Funcionario funcionario1L2 = new Funcionario("Luiz Felipe", contaL2, null);
        Funcionario funcionario2L2 = new Funcionario("Gabriela Ferreira", contaL2, null);

        Loja L1 = new Loja("Renner", contaL1, new Funcionario[]{funcionario1L1, funcionario1L2});
        Loja L2 = new Loja("Shopee", contaL2, new Funcionario[]{funcionario2L1, funcionario2L2});

        Conta contaF1 = new Conta("Ana Luisa: BRB", 0);
        Conta contaF2 = new Conta("Pedro Curi: BB", 0);
        Conta contaF3 = new Conta("Luiz Felipe: Itaú", 0);
        Conta contaF4 = new Conta("Gabriela Ferreira: Santander", 0);

        Conta contaI1 = new Conta("Ana Luisa: Conta Corrente", 0);
        Conta contaI2 = new Conta("Pedro Curi: Conta Corrente", 0);
        Conta contaI3 = new Conta("Luiz Felipe: Poupança", 0);
        Conta contaI4 = new Conta("Gabriela Ferreira: Poupança", 0);

        Conta contaC1 = new Conta("Gabriela Santos: Banco do Brasil", 1000);
        Conta contaC2 = new Conta("João da Cunha: Bradesco", 1000);
        Conta contaC3 = new Conta("Isabela Coelho: Bradesco", 1000);
        Conta contaC4 = new Conta("Paulo Amaral: Itaú", 1000);
        Conta contaC5 = new Conta("Rodrigo Cabral: BRB", 1000);

        Cliente cliente1 = new Cliente("Gebriela Santos", contaC1, new Loja[]{L1, L2}, banco);
        Cliente cliente2 = new Cliente("João da Cunha", contaC2, new Loja[]{L1, L2}, banco);
        Cliente cliente3 = new Cliente("Isabela Coelho", contaC3, new Loja[]{L1, L2}, banco);
        Cliente cliente4 = new Cliente("Paulo Amaral", contaC4, new Loja[]{L1, L2}, banco);
        Cliente cliente5 = new Cliente("Rodrigo Cabral", contaC5, new Loja[]{L1, L2}, banco);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        L1.pagarFuncionarios();
        L2.pagarFuncionarios();


        Conta[] contas = {contaC1, contaC2, contaC3, contaC4, contaC5, contaF1, contaF2, contaF3, contaF4, contaI1, contaI2, contaI3, contaI4, contaL1, contaL2};
        banco.exibirSaldosFinais(contas);
    }
}
