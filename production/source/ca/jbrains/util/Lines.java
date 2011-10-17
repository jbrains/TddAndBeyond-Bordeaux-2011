package ca.jbrains.util;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class Lines {
	public static List<String> parseChompingFinalBlankLine(
			String multilineString) {

		return MoreLists.chomp(Lists.newArrayList(Splitter.on("\n").split(
				multilineString)));
	}
}