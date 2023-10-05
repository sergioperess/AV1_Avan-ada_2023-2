package sim.traci4j.src.java.it.polito.appeal.traci;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private static int PORT = 12345; // numero da porta(está como publico para podermos utilizar no chat cliente)
    private ServerSocket serverSocket;

    // Método para instanciar o serverSocket (Inicia o servidor - socket)
    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT); // Inicia o servidor com o numero da porta
        clientConnectLoop();
    }

    // Método para aguardar as conexões dos clientes
    private void clientConnectLoop() throws IOException {
        while (true) {// Executa infinitamente
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            new Thread(() -> clientMessageLoop(clientSocket)).start();
        }
    }

    // Método para loop de mensagens
    public void clientMessageLoop(ClientSocket clientSocket) {
        String msg;
        // garante que o socket seja fechado
        try {
            while ((msg = clientSocket.getMessage()) != null) {
                // Caso a mensagem for diferente de sair, o cliente continua mandando mensagem
                if (!"sair".equalsIgnoreCase(msg)) {
                    System.out.println("Mensagem recebida do cliente: " + msg + " - do endereço: "
                            + clientSocket.getRemoteSocketAdress());
                } else {
                    return;
                }
            }
        } finally {
            clientSocket.close();
        }
    }

    public int getPort() {
        return PORT;
    }

    public void iniciaServer() {
        // Tratamento para exceção de erro de entrada e saída
        try {
            Server server = new Server(); // Instanciando o servidor
            server.start(); // Iniciando o servidor
        } catch (IOException e) {
            System.out.print("Erro ao iniciar o servidor" + e.getMessage()); // mensagem de erro
        }
    }
}
