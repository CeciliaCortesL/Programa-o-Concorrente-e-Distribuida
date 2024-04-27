import java.util.Scanner;

public class SistemaBancario {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Conta[] contasClientes = new Conta[5];
        for (int i = 0; i < contasClientes.length; i++) {
            contasClientes[i] = new Conta(1000);
        }

        Loja[] lojas = new Loja[2];
        for (int i = 0; i < lojas.length; i++) {
            lojas[i] = new Loja(0);
        }

        Funcionario[] funcionarios = new Funcionario[4];
        for (int i = 0; i < funcionarios.length; i++) {
            funcionarios[i] = new Funcionario(lojas[i / 2]);
            funcionarios[i].start();
        }

        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(contasClientes[i], lojas);
            clientes[i].start();
        }

        String nomeBanco = "BRB";
        Banco banco = new Banco(nomeBanco);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Continuar no sistema");
            System.out.println("2. Sair do sistema");
            int escolha = scanner.nextInt();
            if (escolha == 2) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Continuando no sistema...");
            }
        }
    }   
}
