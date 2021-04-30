
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;


public class Car implements Runnable{
    private static AtomicBoolean win = new AtomicBoolean(true);
    private CyclicBarrier cb;
//    private ArrayBlockingQueue finished;
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb/*, finished*/) {
        this.cb = cb;
//        this.finished = finished;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
//        finished.put(this);
        cb.await();
        if(win.getAndSet(false)){
            System.out.println(name + " Win " + Thread.currentThread().getName());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
