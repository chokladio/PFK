package bst;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

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
	 * Test solve an empty sudoku
	 */
	@Test
	public final void testHeight() {
		assertTrue(bst.height() == 0);
		assert bst.size() == 0;
		bst.add(8);
		assert bst.height() == 1;
		assert bst.size() == 1;

		assert !bst.add(8);
	}

}
