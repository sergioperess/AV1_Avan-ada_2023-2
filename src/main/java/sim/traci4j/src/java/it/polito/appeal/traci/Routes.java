package sim.traci4j.src.java.it.polito.appeal.traci;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Routes {
    private ArrayList<Route> rotas;
    private SumoTraciConnection sumo;

    public Routes(SumoTraciConnection _sumo) {
        this.sumo = _sumo;
    }

    public ArrayList<Route> getAllRoutes() {
        try {
            Map<String, Route> routeMap = sumo.getRouteRepository().getAll();
            Collection<Route> route = sumo.getRouteRepository().getAll().values();
            rotas = new ArrayList<>(route);
            return rotas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
