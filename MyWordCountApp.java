package lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/lab8_map/fit.txt";

	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public static String getFilename() {
		return fileName;
	}

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNext()) {
			String word = sc.next();
			map.compute(word, (key, val) -> val == null ? 1 : val + 1);
		}
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() throws FileNotFoundException {
		int count = 0;
		for (Integer i : map.values()) {
			if (i == 1) {
				count++;
			}
		}
		return count;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// cach 1:
//		Set<Map.Entry<String,Integer>> s = map.entrySet();
//		for (Map.Entry<String, Integer> it: s) {
//			if (it.getValue() == 1) {
//				System.out.print(it.getKey()+" ");
//			}
//		}
		// cach 2:
		for (String word : map.keySet()) {
			if (map.get(word) == 1) {
				System.out.print(word + " ");
			}
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() throws FileNotFoundException {

		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		treeMap.putAll(map);
		for (String word : treeMap.keySet()) {
			System.out.print(word + "=" + treeMap.get(word) + " ");
		}
	}
}
