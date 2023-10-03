package sim.traci4j.src.java.it.polito.appeal.traci;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import it.polito.appeal.traci.SumoTraciConnection;
import de.tudresden.sumo.cmd.Vehicle;

public class Simula extends Thread {
    private SumoTraciConnection sumo;
    private int numVeiculos;

    public Simula() {

    }

    public void run() {

        String z = "sumo-gui";
        String a = "map2/map3.sumo.cfg";

        // Sumo connection
        this.sumo = new SumoTraciConnection(z, a);
        sumo.addOption("start", "1"); // auto-run on GUI show
        sumo.addOption("quit-on-end", "1"); // auto-close on end

        try {
            sumo.runServer(12346);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int numVeiculos() {
        try {
            Collection<Vehicle> vehicles = sumo.getVehicleRepository().getAll().values();
            numVeiculos = vehicles.size();
            return numVeiculos;
        } catch (Exception e) {
            e. printStackTrace();
        }

    }

}
