package algorithm.ppp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Heaters475 {

	public static void main(String[] args) {
		Heaters475 heaters475 = new Heaters475();
		heaters475.findRadius(new int[]{1, 5}, new int[]{2});
	}

	public int findRadius(int[] houses, int[] heaters) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < heaters.length; i++) {
			set.add(heaters[i]);
		}
		Arrays.sort(houses);
		Arrays.sort(heaters);
		//左距离
		int[] leftDistance = new int[houses.length];
		int lastHeaterIndex = 0;
		for (int i = 0; i < houses.length; i++) {
			//检查一下是不是左边最近的
			while (lastHeaterIndex + 1 < heaters.length
				&& heaters[lastHeaterIndex + 1] <= houses[i]) {
				lastHeaterIndex++;
			}
			int lastHeater = heaters[lastHeaterIndex];
			//记录距离
			if (houses[i] < lastHeater) {
				leftDistance[i] = Integer.MAX_VALUE;
			} else if (houses[i] == lastHeater) {
				leftDistance[i] = 0;
			} else {
				leftDistance[i] = houses[i] - lastHeater;
			}
		}
		//右距离
		int[] rightDistance = new int[houses.length];
		lastHeaterIndex = heaters.length - 1;
		for (int i = houses.length - 1; i >= 0; i--) {
			//检查一下是不是左边最近的
			while (lastHeaterIndex - 1 >= 0 && heaters[lastHeaterIndex - 1] >= houses[i]) {
				lastHeaterIndex--;
			}
			int lastHeater = heaters[lastHeaterIndex];
			//记录距离
			if (houses[i] > lastHeater) {
				rightDistance[i] = Integer.MAX_VALUE;
			} else if (houses[i] == lastHeater) {
				rightDistance[i] = 0;
			} else {
				rightDistance[i] = lastHeater - houses[i];
			}
		}
		int minRadius = 0;
		for (int i = 0; i < houses.length; i++) {
			int minDis = Math.min(leftDistance[i], rightDistance[i]);
			minRadius = Math.max(minRadius, minDis);
		}
		return minRadius;

	}
}
