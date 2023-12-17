public class TimerClass {
    // total time (in seconds) is seconds+60*minutes
    protected int seconds;//@ invariant: 0<=seconds<=59;
    protected int minutes;//@ invariant: 0<=minutes<=60 && (minutes<60 || seconds==0);

    public boolean isRunning() {
        // completare
        return this.getTime() > 0;
    }

    public int getTime() {
        // completare
        return (this.seconds + this.minutes * 60);
    }

    public TimerClass tick() {
        // completare
        if (this.isRunning()) {
            this.seconds--;
            if (this.seconds < 0) {
                this.seconds = 59;
                this.minutes--;
            }
        }
        return this;
    }

    public int reset(int minutes) {
        // completare
        if (minutes < 0 || minutes > 60)
            throw new IllegalArgumentException();
        int prevTime = this.getTime();
        this.seconds = 0;
        this.minutes = minutes;
        return prevTime;
    }

}