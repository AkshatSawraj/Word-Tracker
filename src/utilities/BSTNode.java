package utilities;

import java.io.Serializable;


/**
 * @author 835489,563621
 * This class is used to create a node that contains data of generic type E
**/

public class BSTNode<E> implements Serializable{

	 public E key;
	 public BSTNode<E> left;
	public BSTNode<E> right;
/**
 * This is constructor for the class
 * @param item
 */
	public BSTNode(E item) {
		key = item;
		left = right = null;
	
	}
	/**
	 * 
	 * @return returns left node
	 */
	public BSTNode<E> getLeft() {
		return left;
		
	}
	/**
	 * 
	 * @return returns right node
	 */
	public BSTNode<E> getRight() {
		return right;
		
	}
	/**
	 * 
	 * @return returns key data
	 */
	public E getKey() {
		return key;
		
	}
	public void setKey(E key) {
		this.key = key;
	}
	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}
	public void setRight(BSTNode<E> right) {
		this.right = right;
	}

	
	
}
