package Algorithm.ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/3/16.
 */
public class PhoneNumber17 {

	public static void main(String[] args) {
		PhoneNumber17 phoneNumber17 = new PhoneNumber17();
		List<String> res = phoneNumber17.letterCombinations("27");
	}

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<>();
		}
		Map<Integer, Character> startMap = new HashMap<>();
		char[] letters = {'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
		return search(new ArrayList<>(), "", digits.split(""), 0, letters);
	}

	public List<String> search(List<String> record, String recorStr, String[] digits, int index,
		char[] letters) {
		if (recorStr.length() == digits.length) {
			record.add(recorStr);
			return record;
		}
		int limit = 3;
		if (digits[index].equals("7") || digits[index].equals("9")) {
			limit = 4;
		}
		for (int i = 0; i < limit; i++) {
			recorStr += (char) (letters[Integer.parseInt(digits[index]) - 2] + i);
			search(record, recorStr, digits, index + 1, letters);
			recorStr = recorStr.substring(0, recorStr.length() - 1);
		}
		return record;
	}
}
