

public class OneLineBridge {
    public static void main(String[] args) throws InterruptedException{
        Bridge bridge = new Bridge();

        Vehicle_Thread vt1 = new Vehicle_Thread("westbound", bridge);
        Vehicle_Thread vt2 = new Vehicle_Thread("eastbound", bridge);

        vt1.start();
        vt1.sleep(500);
        vt2.start();
        vt1.sleep(500);
        try
        {
            vt1.exitBrige();
            vt1.join();
            vt2.exitBrige();
            vt2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}

class Bridge {
    public  void runningOnBridge(String direction) {
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("Vehicle is running from " + direction);
    }

}

class Vehicle_Thread extends Thread {
    private String direction;
    Bridge bridge;

    Vehicle_Thread(String direction, Bridge bridge) {
        this.direction = direction;
        this.bridge = bridge;
    }

    public synchronized void run() {
        bridge.runningOnBridge(direction);
    }

    public synchronized void exitBrige() {
        System.out.println("The vehicle from " + direction + " is exiting the bridge.");
    }
}
