package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;

	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {

	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) { // om tom, skapa root
			root.element = x;
			return true;
		} else {
			return addRec(root, x);
		}
	}

	private boolean addRec(BinaryNode curNode, E x) {
		if (x.equals(curNode.element)) {
			System.out.print("Du angav samma värde som roten");
			return false;
		} else if (x.compareTo(root.element) < 0) {
			if (curNode.left == null) {
				curNode.left.element = x;
				return true;
			} else
				addRec(curNode.left, x);
		} else if (x.compareTo(root.element) > 0) {
			if (curNode.right == null) {
				curNode.right.element = x;
				return true;
			} else
				addRec(curNode.right, x);
		}
		System.out.println("nåt hände");
		return false;
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return (walker(root));

	}

	private int walker(BinaryNode<E> node) { // treewalker
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(walker(node.left), walker(node.right));
		}
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {

	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1 (the
	 * first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		return 0;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in the
	 * array a are assumed to be in ascending order. Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

}
