package demos.lect31;

public class TimerClass implements Timer {
    private int time = 60;

    public TimerClass() {
    }

    public TimerClass(int minutes) {      // 'time' has value minutes * 60
        this.time = TimerClass.checkMinutes(minutes) * 60;
    }

    public TimerClass(Timer other) { // copy constructor
        this.time = other.getTime();
    }

    private static int checkMinutes(int minutes) {
        if (minutes < 0 || minutes > 60) throw new IllegalArgumentException("time must be in range [0,60]");
        return minutes;
    }

    public boolean isRunning() {
        return this.getTime() > 0;
    }

    public int getTime() { // 'this' is the target of the method
        return this.time;
    }

    public void tick() { // 'this' is the target of the method
        if (this.isRunning()) this.time--;
    }

    public int reset(int minutes) { // 'this' is the target of the method
        int prevTime = this.getTime();
        this.time = TimerClass.checkMinutes(minutes) * 60;
        return prevTime;
    }

}