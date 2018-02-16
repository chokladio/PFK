package bst;

import bst.BinarySearchTree.BinaryNode;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {

	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(5);
		bst.add(3);
		bst.add(1);
		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(7);
		bst.add(10);
		bst.add(11);
		bst.add(12);
		bst.add(13);
		bst.add(14);
		bst.printTree();

		 BSTVisualizer window = new BSTVisualizer("BinaryTree", 800, 600);
		 window.drawTree(bst);

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
			root = new BinaryNode<E>(x);
			size++;
			return true;
		} else {
			return addRec(root, x);
		}
	}

	private boolean addRec(BinaryNode<E> curNode, E x) {
		if (x.compareTo(root.element) < 0) {
			if (curNode.left == null) {
				curNode.left = new BinaryNode<E>(x);
				return true;
			}
			return addRec(curNode.left, x);
		} else if (x.compareTo(root.element) > 0) {
			if (curNode.right == null) {
				curNode.right = new BinaryNode<E>(x);
				return true;
			}
			return addRec(curNode.right, x);
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
		return (heightRec(root));

	}

	private int heightRec(BinaryNode<E> node) { // treewalker
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(heightRec(node.left), heightRec(node.right));
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
		inOrder(root);
	}

	private void inOrder(BinaryNode<E> bn) {
		if (bn != null) {
			inOrder(bn.left);
			System.out.println(bn.element.toString());
			inOrder(bn.right);
		}

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
