package sim.traci4j.src.java.it.polito.appeal.traci;

import it.polito.appeal.traci.SumoTraciConnection;

import sim.traci4j.src.java.it.polito.appeal.traci.Route;

import de.tudresden.sumo.cmd.Vehicle;

import java.util.ArrayList;
import java.util.Collection;

public class Routes extends SumoTraciConnection {
    private ArrayList<Route> rotas = new ArrayList();

    public Routes() {
        super("sumo-gui", "map2/map3.sumo.cfg");
    }

    public ArrayList<Route> getAllRoutes() {
        try {
            // Collection<Route> route = sumo.getRouteRepository().getAll().values();
            return rotas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
