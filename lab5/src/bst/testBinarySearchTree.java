package bst;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class testBinarySearchTree {
	BinarySearchTree<Integer> bst;

	@Before
	public void setUp() throws Exception {
		bst = new BinarySearchTree<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		bst = null;
	}

	/**
	 * Test Height()
	 */
	@Test
	public final void testHeight() {
		assertTrue(bst.height() == 0);
		bst.add(8);
		bst.add(10);
		bst.add(9);
		bst.add(2);
		bst.add(4);
		assert bst.height() == 3;
	}

	/**
	 * Test add()
	 */
	@Test
	public final void testAdd() {
		assertTrue(bst.add(3));
	}
	/**
	 * Test size()
	 */
	@Test
	public final void testSize() {
		assert bst.size() == 0;
		bst.add(8);
		bst.add(2);
		bst.add(9);
		bst.add(11);
		assert bst.size() == 4;
	}
	/**
	 * Test solve an empty sudoku
	 */
	@Test
	public final void testAddDouble() {
		bst.add(8);
		assert !bst.add(8);
	}

}
