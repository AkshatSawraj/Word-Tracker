package utilities;

import adts.BSTreeADT;
import exceptions.TreeException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
/**
 * This class implements the BSTree ADT and constructs the algorithm for the binary search tree with all the useful methods
 * 
 * @author 835489, 563621
 *
 * @param <E>
 */
public class BSTReferencedBased<E> implements BSTreeADT<E> {
	public BSTNode<E> root;
	int size;
	Comparator<E> compare;

	public BSTReferencedBased(Comparator<E> c) {
		super();
		compare = c;
		this.root = null;
		this.size = 0;
	}

	@Override
	public E getRootData() throws TreeException {
		if (this.root == null) {
			throw new TreeException("Root node is null");
		}
		return this.root.getKey();

	}

	@Override
	public int getHeight() {

		int height = depth(this.root);
		return height;

	}

	private int depth(BSTNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			int leftDepth = depth(node.getLeft());
			int rightDepth = depth(node.getRight());

			if (leftDepth > rightDepth) {
				return (leftDepth + 1);

			} else {
				return (rightDepth + 1);
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public void clear() {

		this.root = null;
		size = 0;
	}

	@Override
	public boolean contains(E entry) throws TreeException {
		if (inorderIterator().hasNext()) {
			inorderIterator().next().equals(entry);
			return true;
		}
		return false;
	}

	@Override
	public E getEntry(E entry) throws TreeException {
		if (contains(entry)) {
			return entry;
		}
		throw new TreeException("No Entry Found!");
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException {

		this.root = insert(this.root, newEntry);
		size++;
		return true;

	}

	private BSTNode<E> insert(BSTNode<E> root, E key) {
		if (root == null) {
			root = new BSTNode<E>(key);
			return root;
		}
		if (this.compare.compare((E) key, (E) root.getKey()) == -1) {
			root.left = insert(root.left, key);

		} else if (this.compare.compare((E) key, (E) root.getKey()) == 1) {
			root.right = insert(root.right, key);

		}
		return root;

	}

	@Override
	public Iterator<E> inorderIterator() {
		ArrayList<E> res = new ArrayList<>();
		if (root == null) {
			ArrayIterator<E> iter = new ArrayIterator<E>(res);
			return iter;
		}
		Stack<BSTNode<E>> stack = new Stack<>();
		BSTNode<E> curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.getKey());
			curr = curr.right;
		}
		
		ArrayIterator<E> iter = new ArrayIterator<E>(res);
		return iter;
	}

	@Override
	public Iterator<E> preorderIterator() {
		ArrayList<E> list = new ArrayList<>();
		if (root == null) {
			ArrayIterator<E> iter = new ArrayIterator<E>(list);
			return iter;
		}
		Stack<BSTNode<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BSTNode<E> current = stack.pop();
			list.add(current.getKey());
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
		
		ArrayIterator<E> iter = new ArrayIterator<E>(list);
		return iter;
	}

	@Override
	public Iterator<E> postorderIterator() {
		ArrayList<E> list = new ArrayList<>();
        if(root == null) {
        	ArrayIterator<E> iter = new ArrayIterator<E>(list);
			return iter;
        } 
        Stack<BSTNode<E>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	BSTNode<E> curr = stack.pop();
            list.add(0,curr.getKey());
            if(curr.left!=null) {
              stack.push(curr.left);
            }
            if(curr.right!=null) {
               stack.push(curr.right); 
            }
        }
        ArrayIterator<E> iter = new ArrayIterator<E>(list);
		return iter;
	}

}
