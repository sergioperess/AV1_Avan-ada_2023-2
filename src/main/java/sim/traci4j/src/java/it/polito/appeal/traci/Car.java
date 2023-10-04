package sim.traci4j.src.java.it.polito.appeal.traci;

import java.awt.geom.Point2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import io.sim.DrivingData;

public class Car extends Vehicle {

    private static DataInputStream dis;
    private static DataOutputStream dos;
    private static String IdAuto;

    private ArrayList<Vehicle> veiculos;

    private String idCar;

    private double co2Emission;
    private double fuelTank;
    private double fuelPrice;
    private String DriverId;
    private SumoTraciConnection sumo;
    private ArrayList<DrivingData> drivingRepport;
    private boolean on_off;

    public Car(boolean _on_off, double _fuelPrice, String _DriverId, SumoTraciConnection _sumo, double _co2Emission) {

        super(dis, dos, IdAuto, null, null);

        idCar = IdAuto;
        fuelTank = 10.0;

        this.on_off = _on_off;
        this.co2Emission = _co2Emission;
        this.fuelPrice = _fuelPrice;
        this.DriverId = _DriverId;
        this.sumo = _sumo;
        this.drivingRepport = new ArrayList<DrivingData>();
    }

    private void run() {
        Thread t1 = new Thread(() -> {
            while (this.on_off) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Método para retornar todos os veiculos
    public ArrayList<Vehicle> getAllVehicles() {
        try {
            Collection<Vehicle> vehicles = sumo.getVehicleRepository().getAll().values();
            veiculos = new ArrayList<>(vehicles);
            return veiculos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para procurar um veiculo
    public Vehicle getVehicle(ArrayList<Vehicle> veiculos, String idCar) {
        Vehicle res = veiculos.get(0);

        if (veiculos.isEmpty()) {
            return null;
        } else {
            for (Vehicle v : veiculos) {
                if (idCar == v.getID()) {
                    res = v;
                }
            }
        }

        return res;
    }

    // Método para setar o gasto de combustivel
    public double setFuelTank(String idCar) {
        try {
            double aux = getFuelConsumption();
            aux = fuelTank - aux;
            fuelTank = aux;

            return aux;
        } catch (Exception e) {
            e.printStackTrace();
            return fuelTank;
        }

    }

    // Método para abastecer o veiculo
    public boolean pararAbastecer() {
        boolean aux = false;
        if (fuelTank == 3.00) {
            aux = true;
            return aux;
        }
        return aux;
    }

    // Método para achar as coodenadas 2D
    public Point2D getCoordenadas(String idCar) throws IOException {
        Point2D sumoPosition2D;
        try {
            sumoPosition2D = getPosition();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return sumoPosition2D;
    }

}
