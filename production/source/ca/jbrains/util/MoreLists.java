package ca.jbrains.util;

import java.util.List;

public class MoreLists {
	public static <T> List<T> chomp(List<T> list) {
		return list.subList(0, list.size() - 1);
	}
}