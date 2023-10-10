package sim.traci4j.src.java.it.polito.appeal.traci;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Simula lavras = new Simula();

        lavras.start();

        Scanner entrada = new Scanner(System.in);

        int opcao;

        do {
            opcao = exibirMenu();

            if (opcao == 1) {

            } else if (opcao == 2) {

            } else if (opcao == 9) {
                System.out.println("Sair");
                System.out.println("Até mais.");
            } else {
                System.out.println("Digite novamente!");
            }

        } while (opcao != 9);
    }

    // Método para criar um menu de opções.
    private static int exibirMenu() {
        System.out.println("\n");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transfêrencia");
        System.out.println("6 - Listar contas");
        System.out.println("7 - Remover conta");
        System.out.println("8 - Filtrar contas");
        System.out.println("9 - Sair");

        System.out.println("\nDigite a opção desejada: ");

        // Objeto da classe Scanner para pedir a entrada do usuário
        Scanner entrada = new Scanner(System.in);
        // Pede entrada pro usuário
        int opcao = entrada.nextInt();
        // Retorna a entrada
        return opcao;
    }

}
