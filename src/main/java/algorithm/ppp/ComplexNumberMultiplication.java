package algorithm.ppp;

import java.util.ArrayList;
import java.util.List;

public class ComplexNumberMultiplication {

	public static void main(String[] args) {
		ComplexNumberMultiplication complexNumberMultiplication = new ComplexNumberMultiplication();
		String res=complexNumberMultiplication.complexNumberMultiply("1+-1i", "1+-1i");
		System.out.printf("123");
	}

	public String complexNumberMultiply(String a, String b) {
		String[] aArr = a.split("[+]");
		String[] bArr = b.split("[+]");
		List<String> multiplyRef = new ArrayList<String>();
		for (int i = 0; i < aArr.length; i++) {
			for (int j = 0; j < bArr.length; j++) {
				multiplyRef.add(multiply(aArr[i], bArr[j]));
			}
		}
		return plus(multiplyRef);
	}

	private int getWeight(String str) {
		boolean hasI = str.indexOf("i") != -1;
		if (hasI) {
			return Integer.parseInt(str.substring(0, str.length() - 1));
		} else {
			return Integer.parseInt(str);
		}
	}

	private String multiply(String a, String b) {
		boolean aHasI = a.indexOf("i") != -1;
		boolean bHasI = b.indexOf("i") != -1;
		int weightA = getWeight(a);
		int weightB = getWeight(b);
		if (aHasI && bHasI) {
			//两个都有i
			int newWeight = weightA * weightB * -1;
			return String.valueOf(newWeight);
		} else if (aHasI || bHasI) {
			//其中一个有
			int newWeight = weightA * weightB;
			return String.valueOf(newWeight) + "i";
		} else {
			//都没有
			return String.valueOf(weightA * weightB);
		}
	}

	private String plus(List<String> a) {
		int weight = 0;
		int weightWithI = 0;
		for (int i = 0; i < a.size(); i++) {
			String currentVal = a.get(i);
			if (a.get(i).indexOf("i") != -1) {
				int currentWeight = Integer.parseInt(currentVal.substring(0, a.get(i).length() - 1));
				weightWithI += currentWeight;
			} else {

				weight += Integer.parseInt(a.get(i));
			}
		}
		return String.valueOf(weight) + "+" + String.valueOf(weightWithI) + "i";
	}
}
