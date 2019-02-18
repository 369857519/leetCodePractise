package ppp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeysAndRooms {

//	Example 1:
//
//	Input: [[1],[2],[3],[]]
//	Output: true
//	Explanation:
//	We start in room 0, and pick up key 1.
//	We then go to room 1, and pick up key 2.
//	We then go to room 2, and pick up key 3.
//	We then go to room 3.  Since we were able to go to every room, we return true.
//	Example 2:
//
//	Input: [[1,3],[3,0,1],[2],[0]]
//	Output: false
//	Explanation: We can't enter the room with number 2.

	public static void main(String[] args) {
		KeysAndRooms keysAndRooms = new KeysAndRooms();
		List<List<Integer>> test = new ArrayList<>();
		test.add(new ArrayList<Integer>() {{
			add(1);
			add(3);
		}});
		test.add(new ArrayList<Integer>() {{
			add(3);
			add(0);
			add(1);
		}});
		test.add(new ArrayList<Integer>() {{
			add(2);
		}});
		test.add(new ArrayList<Integer>() {{
			add(0);
		}});
		System.out.println(keysAndRooms.canVisitAllRooms(test));
	}

	private Set<Integer> integerMap = new HashSet<>();

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		walkRoom(rooms, 0);
		return integerMap.size() == rooms.size();
	}

	public void walkRoom(List<List<Integer>> rooms, int currentIndex) {
		if (integerMap.contains(currentIndex)) {
			return;
		}
		List<Integer> currentKeys = rooms.get(currentIndex);
		integerMap.add(currentIndex);
		for (int i = 0; i < currentKeys.size(); i++) {
			walkRoom(rooms, currentKeys.get(i));
		}
	}
}
