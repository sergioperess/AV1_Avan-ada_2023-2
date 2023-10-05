package sim.traci4j.src.java.it.polito.appeal.traci;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private ClientSocket clientSocket;// Socket do cliente - para conectar ao servidor(socket do servidor)
    private static String SERVER_ADRESS = "127.0.0.1"; // Configuração do endereço - endereço do IP local
    private Scanner scanner;
    private Server server;

    public Client() {
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException { // indica que pode havar um erro do tipo IOException(entrada e saida)
        clientSocket = new ClientSocket(new Socket(SERVER_ADRESS, server.getPort()));

        System.out.println("Cliente conectado ao server" + SERVER_ADRESS + ":" + server.getPort());
        messageLoop();
    }

    // Método que ficara em um loop que enviará mensagens para o servidor até
    private void messageLoop() throws IOException {
        String msg;
        do {

            System.out.print("Digite uma mensagem (sair para sair): ");
            msg = scanner.nextLine();
            clientSocket.sendMsg(msg);

        } while (!msg.equalsIgnoreCase("sair"));// usado para n ter diferença de letra mai e minusc

    }

    public String getAdress() {
        return SERVER_ADRESS;
    }

    public void iniciaClient() {
        // tratamento de exceção para o cliente
        try {
            Client client = new Client();
            client.start();
        } catch (Exception e) {
            System.out.println("erro ao iniciar o cliente" + e.getMessage()); // menssagem de erro
        }

    }
}
