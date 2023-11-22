public class AnotherTimerClass {
    // total time (in seconds) is seconds+60*minutes
    static private boolean debug = true;
    private int seconds;//@ invariant: 0<=seconds<=59;
    private int minutes;//@ invariant: 0<=minutes<=60 && (minutes<60 || seconds==0);

    public boolean isRunning() {
        // completare
        return this.getTime() > 0;
    }

    public int getTime() {
        // completare
        return (this.seconds + this.minutes *60);
    }

    public void tick() {
        // completare
        if(this.isRunning()){
            this.seconds--;
            if(this.seconds < 0){
                this.seconds = 59;
                this.minutes--;
            }

        }
    }

    public int reset(int minutes) {
        // completare
        if(minutes < 0 || minutes > 60)
            throw new IllegalArgumentException();
        int prevTime = this.getTime();
        this.seconds = 0;
        this.minutes = minutes;
        return prevTime;
    }

    public static void main(String[] args) {

        AnotherTimerClass t1 = new AnotherTimerClass();
        t1.reset(1);            // t1 reset to 1 minute
        if(debug) System.out.println("t1 dopo il reset(1): " + t1.getTime());
        int seconds = 0;
        while (t1.isRunning()) {
            t1.tick();           // one second per tick
            seconds++;
            if(debug) System.out.println("Passed seconds: " + seconds + "   t1.getTime(): " + t1.getTime());
        }
        if(debug) System.out.println("t1.getTime(): " + t1.getTime());
        assert seconds == 60;   // expected to hold
        assert !t1.isRunning(); // expected to hold
    }
}