package algorithm.ppp;

public class LightSwitch {

	public static void main(String[] args) {
		LightSwitch lightSwitch = new LightSwitch();
		int res = lightSwitch.bulbSwitch(4);
	}

	public int bulbSwitch(int n) {
		if (n == 0) {
			return 0;
		}
		int i = 1;
		while (i * i <= n) {
			i++;
		}
		return i;
	}

}
