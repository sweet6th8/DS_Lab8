package lab8_map;

import java.io.FileNotFoundException;

public class TestMyWordCountApp {
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp m = new MyWordCountApp();
		m.loadData();
//		System.out.println(m.getMap());
//		System.out.println(m.countUnique());
//		m.printWordCounts();
		m.printWordCountsAlphabet();
		
	}

}
