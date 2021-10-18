package utilities;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This class implements Iterator interface and is used to iterate through a list.
 *@author 835489,563621
 *
 * @param <E>
 */
public class ArrayIterator<E> implements Iterator<E> {

	private ArrayList<E> arrayList;
	private int position = 0;

	@SuppressWarnings("unchecked")
	public ArrayIterator(ArrayList<E> list) {
		this.arrayList = list;
	}

	@Override
	public boolean hasNext() {
		return (position < this.arrayList.size());
	}

	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		

		E item = this.arrayList.get(position);
		position++;
		return item;

	}

}
