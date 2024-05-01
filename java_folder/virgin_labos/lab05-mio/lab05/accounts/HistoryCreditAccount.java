package lab05.accounts;

public class HistoryCreditAccount extends CreditAccount implements HistoryAccount {
	/*
	 * history > 0 means previous operation was deposit(history) history < 0 means
	 * previous operation was withdraw(-history) history == 0 means no previous
	 * operation
	 */
	private int history;

	// private object method to be used in undo() and redo()
	private int operation(int amount) {
		if (amount >= 0)
			return this.deposit(amount);
		return this.withdraw(-amount);
	}

	// check to be used in undo() and redo()
	protected int requireNonZeroHistory() {
		if (this.history == 0)
			throw new IllegalStateException("Operation history is empty");
		return this.history;
	}

	protected HistoryCreditAccount(int limit, int balance, Client owner) {
	    // completare
	}

	// factory methods

	public static HistoryCreditAccount newOfLimitBalance(int limit, int balance, Client owner) {
		return new HistoryCreditAccount(limit, balance, owner);
	}

	public static HistoryCreditAccount newOfBalance(int balance, Client owner) {
		return new HistoryCreditAccount(HistoryCreditAccount.defaultLimit, balance, owner);
	}

	// public object methods

	@Override
	public int deposit(int amount) {
	    // completare
	}

	@Override
	public int withdraw(int amount) {
	    // completare
	}

	public int undo() {
	    // completare
	}

	public int redo() {
	    // completare
	}
}
