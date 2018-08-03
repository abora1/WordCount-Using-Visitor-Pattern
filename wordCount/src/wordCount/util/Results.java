package wordCount.util;

import java.util.ArrayList;

public class Results {
	public ArrayList<String> resList = new ArrayList<String>();
	// add strings to the ArrayList
	private static Results resultI;

	public static Results Instance() {
		if (resultI == null) {
			resultI = new Results();
		}
		return resultI;
	}

	// This method stores all the results in an array list and then writes them
	// to file or STDDISPLAY
	public void storeNewResult(String s) {
		resList.add(s);
	}
}
