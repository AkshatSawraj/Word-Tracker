package appDriver;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.io.ObjectInputStream;

import exceptions.TreeException;
import utilities.*;
import wordTracker.*;

/**
 * 
 * @author 835489,563621
 *
 *         Title: Tracker By: Akshat S, Altamish L Description: Tracker is a
 *         program that can read .txt files and scan through every word for
 *         unique information. Our program uses a Binary Tree data structure to
 *         store such information, and output findings into the repository.txt
 *         file found in your /res folder.
 *
 */

public class Run {

	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		BSTReferencedBased<Word> tree = null;
		WordTracker test1 = null;

		String filepath = args[0];

		File f = new File("./res/repository.ser");
		if (f.exists()) {
			FileInputStream read = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(read);
			tree = (BSTReferencedBased<Word>) ois.readObject();

		}
		if (tree != null) {
			try {

				test1 = new WordTracker(filepath, tree);

				@SuppressWarnings("unused")
				SaveWordTracker s1 = new SaveWordTracker(test1);

				System.out.println(test1);
			} catch (TreeException e) {
				// File not found
				System.out.println("File not found");
				e.printStackTrace();
			}
		} else {

			try {
				test1 = new WordTracker(filepath);

				@SuppressWarnings("unused")
				SaveWordTracker s1 = new SaveWordTracker(test1);

				System.out.println(test1);
			} catch (TreeException e) {
				// File not found
				System.out.println("File not found");
				e.printStackTrace();
			}
		}

		for (String arg : args) {
			if (arg.startsWith("-")) {
				if ((arg.charAt(1) == 'P' || arg.charAt(1) == 'p') && (arg.charAt(2) == 'F' || arg.charAt(2) == 'f')) {

					System.out.println("-pf working");

					utilities.Iterator<Word> it = test1.getTree().inorderIterator();
					while (it.hasNext()) {

						Word wordObjWord = it.next();
						System.out.println(wordObjWord.toPF());

					}

				}

				else if ((arg.charAt(1) == 'P' || arg.charAt(1) == 'p')
						&& (arg.charAt(2) == 'L' || arg.charAt(2) == 'l')) {
					System.out.println("-pl working");

					utilities.Iterator<Word> it = test1.getTree().inorderIterator();
					while (it.hasNext()) {

						Word wordObjWord = it.next();

						System.out.println(wordObjWord.toPL());

					}
				}

				else if ((arg.charAt(1) == 'P' || arg.charAt(1) == 'p')
						&& (arg.charAt(2) == 'O' || arg.charAt(2) == 'o')) {
					System.out.println("-po working");

					utilities.Iterator<Word> it = test1.getTree().inorderIterator();
					while (it.hasNext()) {

						Word wordObjWord = it.next();
						System.out.println(wordObjWord.toPO());

					}

				} else if ((arg.charAt(1) == 'F' || arg.charAt(1) == 'f')) {
					System.out.println("-file redirect working");

				}
			}
		}

	}

}
