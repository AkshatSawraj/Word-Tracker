package Comparator;

import java.io.Serializable;
import java.util.Comparator;

import utilities.Word;
/**
 * 
 * @author 835489,563621
 * 
 * Used to compare word objects.
 *
 */
public class WordComparator implements Comparator<Word>, Serializable {

	@Override
	public int compare(Word o1, Word o2) {
		
		
		if (o1.getWord().compareTo(o2.getWord()) < 0) {
			return -1;
			
		} else if (o1.getWord().compareTo(o2.getWord()) > 0) {
			return 1;
		}
		return 0;
		
	}

	

}
