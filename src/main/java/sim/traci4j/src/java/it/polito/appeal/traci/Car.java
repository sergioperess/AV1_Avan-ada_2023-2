package sim.traci4j.src.java.it.polito.appeal.traci;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Car extends Vehicle {

    private static DataInputStream dis;
    private static DataOutputStream dos;
    private static String Id;

    public Car() {

        super(dis, dos, Id, null, null);

    }
}
