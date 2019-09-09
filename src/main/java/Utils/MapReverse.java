package Utils;

public class MapReverse {

	public static void main(String[] args) {
		String hex = getMapId(123123);
		Long res = getId("000017f");
	}

	public static String getMapId(long userId) {
		return new StringBuilder(Long.toHexString(userId)).reverse().toString();
	}

	public static Long getId(String MapId) {
		String hexStr = (new StringBuilder(MapId)).reverse().toString();
		return Long.parseLong(hexStr, 16);

	}

}
