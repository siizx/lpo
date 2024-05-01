package demos.lect31;

public interface Timer {

	boolean isRunning();

	int getTime();

	void tick();

	int reset(int minutes);
}
