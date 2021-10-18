package utilities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.sound.sampled.Line;
import javax.swing.PopupFactory;
/**
 * This class is used to create Word object to store the information in the form of word object.
 * It keep track of occurrence of word and the line number.
 * @author 835489,563621
 *
 */
public class Word implements Serializable{
	
	private String word="";
	private String filenameString="";
	private int occurance = 0;
	private ArrayList<Integer> lineNumber =new ArrayList<Integer>();
	
	
	
	public String getFilenameString() {
		return filenameString;
	}
	public void setFilenameString(String filenameString) {
		this.filenameString = filenameString;
	}
	public String getWord() {
		return word;
	}
	public Word(String word,int newLineInfo) {
		this.word = word;
		addLineNumber(newLineInfo);
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getOccurance() {
		return occurance;
	}
	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
	public ArrayList<Integer> getLineNumber() {
		return lineNumber;
	}
	public void addLineNumber(int number) {
		this.lineNumber.add(number);
		this.occurance++;
	}
	public void setLineNumber(ArrayList<Integer> lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
	public String toPF() {
		
		return  word + " can be found on file textfile.txt"  ;
	}
	public String toPL() {
		
		return  "The word "+ word + " appears on line numbers " + lineNumber + " on the file textfile.txt"  ;
	}
	public String toPO() {
		
		return  word + " has occuranced " + occurance + " times in the file textfile.txt on line numbers " + lineNumber ;
	}
	
	
	
	
	@Override
	public String toString() {
		return word + " has occuranced " + occurance + " times, and it appears on line numbers " + lineNumber ;
	}
	
	
}
