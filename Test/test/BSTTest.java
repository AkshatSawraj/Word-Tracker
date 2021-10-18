
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Comparator.WordComparator;
import adts.BSTreeADT;
import exceptions.TreeException;
import utilities.*;

class BSTTest {
	private BSTReferencedBased<Word> tree;
	private int lineNumberSample = 0;

	@BeforeEach
	void setUp() throws Exception {
		int lineNumberSample = 0;
		Comparator<Word> comparator = new WordComparator();
		this.tree = new BSTReferencedBased<Word>(comparator);
		this.tree.add(new Word("b", lineNumberSample));
		this.tree.add(new Word("a", lineNumberSample));
		this.tree.add(new Word("c", lineNumberSample));
		this.tree.add(new Word("e", lineNumberSample));
		this.tree.add(new Word("f", lineNumberSample));

	}

	@AfterEach
	void tearDown() throws Exception {
		this.tree.clear();
	}

	@Test
	void testAdd() throws TreeException {
		assertEquals(this.tree.add(new Word("g", lineNumberSample)), true);
		assertEquals(this.tree.add(new Word("h", lineNumberSample)), true);
		assertEquals(this.tree.add(new Word("i", lineNumberSample)), true);
		assertEquals(this.tree.size(), 8);
	}

	@Test
	void testGetRoot() {

		try {
			assertEquals(tree.getRootData().getWord(), "b");
		} catch (TreeException e) {

			e.printStackTrace();
		}

	}

	@Test
	void testHeight() {
		assertEquals(tree.getHeight(), 4);
	}

	@Test
	void testIsEmpty() {
		assertEquals(tree.isEmpty(), false);
	}

	@Test
	void testContains() {

		try {
			assertEquals(tree.contains(new Word("e", lineNumberSample)), true);
		} catch (TreeException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testclear() {
		tree.clear();
		assertEquals(tree.size(), 0);
	}

	@Test
	void testGetEntry() {
		try {
			assertEquals(tree.getEntry(new Word("e", lineNumberSample)).getWord(), "e");
		} catch (TreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testInorderIterator() {

		Iterator<Word> inorder = this.tree.inorderIterator();
		assertEquals(inorder.next().getWord(), "a");
		assertEquals(inorder.next().getWord(), "b");
		assertEquals(inorder.next().getWord(), "c");
		assertEquals(inorder.next().getWord(), "e");
		assertEquals(inorder.next().getWord(), "f");

	}
	@Test
	void testPreorderIterator() {
		Iterator<Word> preorder = this.tree.preorderIterator();
		assertEquals(preorder.next().getWord(), "b");
		assertEquals(preorder.next().getWord(), "a");
		assertEquals(preorder.next().getWord(), "c");
		assertEquals(preorder.next().getWord(), "e");
		assertEquals(preorder.next().getWord(), "f");

	}

	@Test
	void testPostorderIterator() {
		Iterator<Word> postOrder = this.tree.postorderIterator();
		assertEquals(postOrder.next().getWord(), "a");
		assertEquals(postOrder.next().getWord(), "f");
		assertEquals(postOrder.next().getWord(), "e");
		assertEquals(postOrder.next().getWord(), "c");
		assertEquals(postOrder.next().getWord(), "b");

	}

}
