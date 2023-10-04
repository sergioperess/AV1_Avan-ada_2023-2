package sim.traci4j.src.java.it.polito.appeal.traci;

public class Conta extends Thread {
    private int numero;
    private static int numeroConta = 1;
    private double saldo;
    private FuelStation posto;
    private Driver driver;
    private Company company;

    // Construtor para o posto
    public Conta(FuelStation _posto) {
        this.saldo = 0.0;
        this.posto = _posto;
        numero = numeroConta;
        numeroConta++;
    }

    // Construtor para o Driver
    public Conta(Driver _driver) {
        this.saldo = 0.0;
        this.driver = _driver;
        numero = numeroConta;
        numeroConta++;
    }

    // Construtor para a company
    public Conta(Company _company) {
        this.saldo = 0.0;
        this.company = _company;
        numero = numeroConta;
        numeroConta++;
    }

    // System.out.println("A conta foi criada. " + "Saldo inicial: R$ " +
    // this.saldo);

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método para retornar o número da conta
    public int getConta() {
        return numero;
    }

    // Método para validar transações
    public boolean saqueConta(double dinheiro) {
        if ((saldo - dinheiro) >= 0 && dinheiro >= 0) {
            saldo = saldo - dinheiro;
            return true;
        } else {
            return false;
        }
    }

    /*
     * public synchronized double getSaldo() {
     * return saldo;
     * }
     * 
     * public synchronized void setSaldo(double saldo) {
     * this.saldo = saldo;
     * }
     */
}
