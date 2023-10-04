package sim.traci4j.src.java.it.polito.appeal.traci;

public class Banco {
    public boolean saque(Conta _conta, double _valor) {
        // synchronized (_conta) {

        if (_conta.getSaldo() < _valor) {
            System.out.println("Saldo insuficiente.");
            return false;
        }

        _conta.setSaldo(_conta.getSaldo() - _valor);

        return true;
        // }
    }
}
