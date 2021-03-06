package jtm.extra04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*-
 * 
 * This class represents string tokenizer exercise.
 */
public class StringTokenizerExercise {
	public List<Student> createFromFile(String filepath, String delimiter) {
		File students = new File(filepath);
		List<Student> list = new ArrayList<Student>();
		BufferedReader in;
		// TODO # 3 Implement method which reads data from file and creates
		// Student objects with that data. Each line from file contains data for
		// 1 Student object.
		// Add students to list and return the list. Assume that all passed data
		// and
		// files are correct and in proper form.
		// Advice: Explore StringTokenizer or String split options.
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] temp;
				temp = splitString(line, delimiter);
				Student tempStudent = new Student(Integer.parseInt(temp[0]), temp[1], temp[2],
						Integer.parseInt(temp[3]));
				list.add(tempStudent);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.print("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Problems with reading class");
			e.printStackTrace();
		}
		return list;
	}

	public String[] splitString(String text, String delimiter) {
		String[] list = null;
		// 1 Split passed text by given delimiter and return array with
		// split strings.
		// HINT: Use System.out.println to better understand split method's
		// functionality.
		list = text.split(delimiter);
		return list;
	}

	public List<String> tokenizeString(String text, String delimiter) {
		// 2 Tokenize passed text by given delimiter and return list with
		// tokenized strings.
		List<String> list = new ArrayList<>();
		StringTokenizer multiTokenizer = new StringTokenizer(text, delimiter);
		while (multiTokenizer.hasMoreTokens()) {
			list.add(multiTokenizer.nextToken());
		}
		return list;
	}

}
