package algorithm.Utils;

import java.util.ArrayList;

public class MapReverse {

	public static void main(String[] args) {
		String hex = getMapId(448045352);
		Long res = getId("000017f");
		new ArrayList<Integer>(){{{
			add(1);
		}}}.subList(0,1);
	}

	public static String getMapId(long userId) {
		return new StringBuilder(Long.toHexString(userId)).reverse().toString();
	}

	public static Long getId(String MapId) {
		String hexStr = (new StringBuilder(MapId)).reverse().toString();
		return Long.parseLong(hexStr, 16);

	}

}
