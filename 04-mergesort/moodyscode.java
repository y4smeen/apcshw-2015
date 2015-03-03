import java.lang.Math.*;

public class StemSells() {
	public StemSells() {
	}

	// EFC == expected family contribution
	// AGI == annual gross income per family
	public double EFC(double AGI, String schoolType) {
		double y = 0;

		if (schoolType == "public") {
			y = 589.01 * Math.pow(AGI, 0.341);
		}
		else if (schoolType == "private") {
			y = 280.12 * Math.pow(AGI, 0.341);
		}
		else if (schoolType == "community") {
			y = 151.42 * Math.pow(AGI, 0.341);
		}

		return y;
	}

	public static void main(String[] args) {
		StemSells s = new StemSells();
	}
}
