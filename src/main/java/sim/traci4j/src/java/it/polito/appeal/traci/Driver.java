package sim.traci4j.src.java.it.polito.appeal.traci;

import java.util.ArrayList;

public class Driver extends Thread {

    private Company company;
    private Car carro;
    private static double preçoGasolina = 5.87;
    private ArrayList<Routes> proximasRotas;
    private ArrayList<Routes> execucaoRotas;

    private Banco banco;
    private Conta conta;
    private double valor = 200; // saques de R$ 200,00
    private double saques = 0;

    public Driver(Company _company, Car _carro) {
        this.company = _company;
        this.carro = _carro;
        this.proximasRotas = new ArrayList<Routes>();
        this.execucaoRotas = new ArrayList<Routes>();

    }

    // Método para testar se os drivers fizeram suas rotas
    public boolean testaRota() {
        boolean aux = false;
        if (execucaoRotas.size() == 9) {
            aux = true;
        }

        return aux;
    }

    @SuppressWarnings("static-access")
    public void run() {
        double total = 0;
        while (this.banco.saque(this.conta, this.valor)) {
            try {
                total = total + this.valor;
                this.saques = this.saques + this.valor;
                System.out.println(this.getName() + " sacou R$ " + this.valor
                        + ". Saldo total �: R$ " + this.conta.getSaldo());

                System.out.println("Total de saques por: " + this.getName() + ": R$ " + this.saques);

                this.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
