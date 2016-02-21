public class ATMCard {

	private int pin;
	private boolean valid;

	public ATMCard() {
	}

	public ATMCard(int pin, boolean valid) {
		super();
		this.pin = pin;
		this.valid = valid;
	}

	public int getPin() {
		return this.pin;
	}

	public boolean getValid() {
		return this.valid;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String toString() {
		return "Pin = " + this.pin;

	}
}