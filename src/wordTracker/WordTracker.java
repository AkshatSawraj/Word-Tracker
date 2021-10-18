package wordTracker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Comparator.WordComparator;
import exceptions.TreeException;
import utilities.BSTReferencedBased;
import utilities.Iterator;
import utilities.Word;

public class WordTracker {

	/**
	 * @author Altamish Lalani
	 * @author 835489,563621
	 *
	 *         App called Word Tracker
	 *
	 *         An input file is passed through and each individual word is tracked
	 *         with information.
	 *
	 *         1 BST "Dictionary": Unique Word - filename - line occurrence
	 *         Dictionary {variety[(fileA.txt, 2),(fileB.txt, 1), (fileC.txt, 215)
	 *         ],used[(fileA.txt, 4)],sample[(fileB.txt, 7)]}
	 *
	 *         Version 1.0
	 */

//******************** DOUBLE CHECK STATIC<PRIVATE<VARS
	// Vars & Objects

	int lineNumber;
	String file;
	String currentFileLine;
	String singleWordString;
	FileInputStream fis;
	Scanner wordScanner;
	Word inputWord;
	utilities.Iterator<Word> list;

//*********ADD BST TREE HERE
	BSTReferencedBased<Word> dictionary = new BSTReferencedBased<>(new WordComparator());

	// Read Text File(s) V1.0 with 1 file, V2.0 Multiple files

	public WordTracker(String filePath) throws TreeException {
		lineNumber = 0;
		file = filePath;

		try {
			fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			Scanner fileLine = new Scanner(fis);

			while (fileLine.hasNextLine()) {
				currentFileLine = fileLine.nextLine();
				lineNumber++;

				// Track each occurrence of a word with it's filename and the line. { Using
				// isUnique() }
				isUnique();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//Report information back to the user (-pf , -pl, -po) (Idea --- Call 3 methods that print the correct log type)
		/*
		 * TO BE COMPLETED
		 */
	}

	public WordTracker(String filePath, BSTReferencedBased<Word> tree) throws TreeException {
		lineNumber = 0;
		this.file = filePath;
		dictionary = tree;
		try {
			fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			Scanner fileLine = new Scanner(fis);

			while (fileLine.hasNextLine()) {
				currentFileLine = fileLine.nextLine();
				lineNumber++;

				// Track each occurrence of a word with it's filename and the line. { Using
				// isUnique() }
				isUnique();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//Report information back to the user (-pf , -pl, -po) (Idea --- Call 3 methods that print the correct log type)
		/*
		 * TO BE COMPLETED
		 */
	}

	public void isUnique() {
		// Convert all words in a single line, to an array of words.
		String[] words = currentFileLine.split("\\W+");
		for (String word : words) {
			/*
			 * 1) Is empty, add first word. 2) Else iterate to check BSTree if Word exists,
			 * append info as needed. Else new word in dictionary.
			 */
			boolean wordNotFound = false;
			inputWord = new Word(word, lineNumber);
			inputWord.setFilenameString(file);

			if (dictionary.isEmpty()) {
				dictionary.add(inputWord);
			} else {
				list = dictionary.preorderIterator();

////***************Dictionary Properties

				while (list.hasNext()) {
					Word currentWord = list.next();
					if (currentWord.getWord().equals(word)) {

						currentWord.addLineNumber(lineNumber);

						// Add code here
					} else {
						wordNotFound = true;
					}
				}
				if (wordNotFound) {
					dictionary.add(new Word(word, lineNumber));
				}
			}
		}

	}

	public BSTReferencedBased<Word> getTree() {

		return this.dictionary;
	}

	@Override
	public String toString() {
		return "WordTracker{" + "lineNumber=" + lineNumber + ", file='" + file + '\'' + ", currentFileLine='"
				+ currentFileLine + '\'' + ", fis=" + fis + '}';
	}

}
