public class TimerClass {
    private int time;

    public boolean isRunning() {
        return this.getTime() > 0;
    }

    public int getTime() {
        return this.time;
    }

    public void tick() {
        if (this.isRunning())
            this.time--;
    }

    public int reset(int minutes) {
        if (minutes < 0 || minutes > 60)
            throw new IllegalArgumentException();
        int prevTime = this.getTime();
        this.time = minutes * 60;
        return prevTime;
    }

    public static void main(String[] args) {
        TimerClass t1 = new TimerClass();
        t1.reset(1);
        System.out.println("Timer 1 time after reset: " + t1.getTime());
        t1.tick();
        System.out.println("Timer 1 time after tick: " + t1.getTime());

        TimerClass t2 = new TimerClass();
        t2.reset(2);
        System.out.println("Timer 2 time after reset: " + t2.getTime());
        t2.tick();
        System.out.println("Timer 2 time after tick: " + t2.getTime());

        int seconds = 0;
        while (t1.isRunning()) {
            t1.tick();
            seconds++;
        }

        TimerClass t3 = null;
        // qua se gioco con i diversi possibili output, vediamo il comportamento del programma
        assert seconds != 60;
        assert !t1.isRunning();
        //assert t3.isRunning();
        // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "TimerClass.isRunning()" because "<local4>" is null
    }
}