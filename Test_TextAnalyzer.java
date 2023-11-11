package lab8_map;

import java.io.IOException;

public class Test_TextAnalyzer {
	public static void main(String[] args) throws IOException {
		TextAnalyzer analyzer = new TextAnalyzer();
		analyzer.load("src/lab8_map/short.txt");
		analyzer.displayWords();
		analyzer.displayText();
		System.out.println(analyzer.mostFrequentWord());
		
		
	}
}
