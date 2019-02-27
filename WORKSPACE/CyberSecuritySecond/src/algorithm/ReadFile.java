package algorithm;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	List<String> lines = new ArrayList<String>();
	String line;
	int lineNumber = 0;

	protected List<String> byLine(File file) throws IOException {

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		System.out.println("in read");

		while ((line = bufferedReader.readLine()) != null) {

			lines.add(line);
		}

		bufferedReader.close();

		return lines;
	}
}