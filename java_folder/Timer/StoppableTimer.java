public interface StoppableTimer {
    public boolean stopped();

    public void stop();

    public void restart();

    public boolean isRunning();

    public int reset(int minutes);

    public int getTime();
}
