package sim.traci4j.src.java.it.polito.appeal.traci;

import java.sql.Timestamp;

public class BotPayment extends Thread {

    private Driver driver;
    private Timestamp timestamp;
    private static double pagamento = 3.25;

    public BotPayment() {
        // Exemplo
        timestamp = new Timestamp(System.currentTimeMillis() * 1000);
    }

    public void pagamentos() {
        double pag;
        pag = pagamento;
    }
}
