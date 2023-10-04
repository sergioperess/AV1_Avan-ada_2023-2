package sim.traci4j.src.java.it.polito.appeal.traci;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FuelStation {

    // Quantas threads podem passar pelo semaforo ao mesmo tempo
    private static final Semaphore SEMAFORO = new Semaphore(2);

    // Threads em cache, vai criando as Threads conforme o necessario
    ExecutorService executor = Executors.newCachedThreadPool();

    Runnable r1 = () -> {
        String nome = Thread.currentThread().getName();
        int usuario = new Random().nextInt(10000);

        aquire();
        System.out.println("O usuário: " + usuario + " entrou aqui usando a Thread " + nome);

        sleep();
        notify();

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ja foi feito a tarefa e pode dar o espaço para outro que deseja fazer
        SEMAFORO.release();
    };

    Runnable r2 = () -> {
        String nome = Thread.currentThread().getName();
        int usuario = new Random().nextInt(10000);

        aquire();
        System.out.println("O usuário: " + usuario + " entrou aqui usando a Thread " + nome);

        sleep();
        notify();

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ja foi feito a tarefa e pode dar o espaço para outro que deseja fazer
        SEMAFORO.release();
    };

    // Método para passar pelo semaforo
    private static void aquire() {
        try {
            // Ao chamar o mértodo acquire, ele vai tentar passar pelo semáforo e desse modo
            // será permitido passar o numero desejado
            SEMAFORO.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    // Espera de 2 minutos
    private static void sleep() {
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
