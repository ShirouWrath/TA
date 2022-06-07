package shiro.streaming.system;

public class Processor extends Thread {
    long sleepSeconds;

    public Processor prime(long sleepSeconds){
        this.sleepSeconds = sleepSeconds;
        return this;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(sleepSeconds * 1000);
                work();
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void work() {
        //MADE TO BE OVERRIDEN
    }
}
