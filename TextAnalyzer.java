package lab8_map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int count = 1;
		while (true) {

			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (tokens.countTokens() == 0) {
					add(word, -count);
				} else {
					add(word, count);
				}

				count++;
			}

		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		ArrayList<Integer> list;
		if (map.containsKey(word)) {
			list = map.get(word);
			list.add(position);
		} else {
			list = new ArrayList<>();
			list.add(position);
		}
		map.put(word, list);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> sort = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		sort.putAll(map);
		for (Map.Entry<String, ArrayList<Integer>> word : sort.entrySet()) {
			System.out.println(word.getKey() + " " + word.getValue());
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		int count = 0;
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			count += entry.getValue().size();

		}
		String[] str = new String[count];
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			for (Integer index : entry.getValue()) {
				if (index < 0) {
					str[-index - 1] = entry.getKey() + "\n";

				} else {
					str[index - 1] = entry.getKey() + " ";

				}
			}
		}
		Arrays.stream(str).forEach(System.out::print);

	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		int max = 0;
		String result = "";
		for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {

			if (entry.getValue().size() > max) {
				max = entry.getValue().size();
				result = entry.getKey();
			}
		}

		return result;
	}

}
