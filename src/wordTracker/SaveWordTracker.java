package wordTracker;

import java.io.*;
/**
 * To save a repository, this class checks the directory and creates a 
 * serialized file for our program to save as a checkpoint for BSTree info, and to retrieve file Word Tracker information.
 * 
 * @author 835489,563621
 *
 */
public class SaveWordTracker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3557356540276558386L;

	public SaveWordTracker(WordTracker wordObj) {

		try {
			File file = new File("./res/repository.ser");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fileSendOut = new FileOutputStream(file);

			ObjectOutputStream objOutStream = new ObjectOutputStream(fileSendOut);

			objOutStream.writeObject(wordObj.getTree());

			objOutStream.close();
			fileSendOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
