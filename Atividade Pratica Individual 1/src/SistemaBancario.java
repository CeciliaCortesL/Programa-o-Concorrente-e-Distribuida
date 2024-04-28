public class SistemaBancario {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        Conta contaLoja1 = new Conta("Conta Corrente", 0);
        Conta contaLoja2 = new Conta("Poupança", 0);

        Conta contaFuncionario1 = new Conta("Ana Luisa", 0);
        Conta contaFuncionario2 = new Conta("Pedro Curi", 0);
        Conta contaFuncionario3 = new Conta("Luiz Felipe", 0);
        Conta contaFuncionario4 = new Conta("Gabriela Ferreira", 0);

        Conta contaInicial1 = new Conta("Ana Luisa: Conta Corrente", 0);
        Conta contaInicial2 = new Conta("Pedro Curi: Conta Corrente", 0);
        Conta contaInicial3 = new Conta("Luiz Felipe: Poupança", 0);
        Conta contaInicial4 = new Conta("Gabriela Ferreira: Poupança", 0);

        Conta contaCliente1 = new Conta("Gabriela Santos", 1000);
        Conta contaCliente2 = new Conta("João da Cunha", 1000);
        Conta contaCliente3 = new Conta("Isabela Coelho", 1000);
        Conta contaCliente4 = new Conta("Paulo Amaral", 1000);
        Conta contaCliente5 = new Conta("Rodrigo Cabral", 1000);

        Funcionario funcionario1Loja1 = new Funcionario("Ana Luisa", contaLoja1, null);
        Funcionario funcionario2Loja1 = new Funcionario("Pedro Curi", contaLoja1, null);
        Funcionario funcionario1Loja2 = new Funcionario("Luiz Felipe", contaLoja2, null);
        Funcionario funcionario2Loja2 = new Funcionario("Gabriela Ferreira", contaLoja2, null);

        Loja Loja1 = new Loja("Renner", contaLoja1, new Funcionario[]{funcionario1Loja1, funcionario1Loja2});
        Loja Loja2 = new Loja("Shopee", contaLoja2, new Funcionario[]{funcionario2Loja1, funcionario2Loja2});

        Cliente cliente1 = new Cliente("Gebriela Santos", contaCliente1, new Loja[]{Loja1, Loja2}, banco);
        Cliente cliente2 = new Cliente("João da Cunha", contaCliente2, new Loja[]{Loja1, Loja2}, banco);
        Cliente cliente3 = new Cliente("Isabela Coelho", contaCliente3, new Loja[]{Loja1, Loja2}, banco);
        Cliente cliente4 = new Cliente("Paulo Amaral", contaCliente4, new Loja[]{Loja1, Loja2}, banco);
        Cliente cliente5 = new Cliente("Rodrigo Cabral", contaCliente5, new Loja[]{Loja1, Loja2}, banco);

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

        Loja1.pagarFuncionarios();
        Loja2.pagarFuncionarios();

        Conta[] contas = {contaCliente1, contaCliente2, contaCliente3, contaCliente4, contaCliente5, contaFuncionario1, contaFuncionario2, contaFuncionario3, contaFuncionario4, contaInicial1, contaInicial2, contaInicial3, contaInicial4, contaLoja1, contaLoja2};
        banco.exibirSaldos(contas);
    }
}
