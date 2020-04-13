package Algorithm.Utils;

import java.util.List;

public class MyNestedInteger implements NestedInteger {

	@Override
	public boolean isInteger() {
		return isInteger;
	}

	@Override
	public Integer getInteger() {
		return val;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}

	private boolean isInteger = false;
	private int val = 0;
	List<NestedInteger> list = null;

	public MyNestedInteger(int integer) {
		isInteger = true;
		val = integer;
	}

	public MyNestedInteger(List<NestedInteger> list) {
		this.list = list;
	}

}
