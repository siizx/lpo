public class StoppableTimerClass extends TimerClass implements StoppableTimer {
    private boolean stopped;
    private int seconds; //@ invariant: 0<=seconds<=59;
    private int minutes; //@ invariant: 0<=minutes<=60 && (minutes<60 || seconds==0);

    public boolean stopped() { return this.stopped; }
    public void stop() { this.stopped = true; }
    public void restart() { this.stopped = false; }
    @Override public boolean isRunning() { // redefined
        return super.isRunning() && !this.stopped();
    }
    @Override public int reset(int minutes) { // redefined this.restart();
        return super.reset(minutes); }

    public StoppableTimerClass tick() {
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

    public static void main(String[] args){
        StoppableTimerClass st = new StoppableTimerClass();
        st.reset(1);
        assert st.getTime() == 60;
        System.out.println("st.getTime: " + st.getTime());
        st.stop();
        assert !st.isRunning();
        st.tick();
        System.out.println("st.isRunning: " + st.isRunning());
        assert st.getTime() == 60; st.restart();
        st.tick();
        System.out.println("st.getTime: " + st.getTime());
        assert st.isRunning(); assert st.getTime() == 59;
    }
}