package sim.traci4j.src.java.it.polito.appeal.traci;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Banco banco = new Banco();

        ArrayList<Conta> contas = new ArrayList<>();

        Conta conta = new Conta(1000);

        contas.add(conta);

        ArrayList<Driver> clientes = new ArrayList<>();

        clientes.add(new Driver(
                "Paulo da Silva", banco, contas.get(0)));

        clientes.add(new Driver(
                "Maur�cio da Silva", banco, contas.get(0)));
        clientes.add(new Driver(
                "Fernando da Silva", banco, contas.get(0)));

        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).start();
        }
    }
}
