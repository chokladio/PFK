package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {

	}

	public static void main(String[] args) throws InterruptedException {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		BSTVisualizer window = new BSTVisualizer("BinaryTree", 1800, 600); // GUI

		// System.out.println("size: " + bst.size + " Height:" + bst.height());
		// bst.add(7);bst.add(3);bst.add(1);bst.add(-10);
		// bst.add(8); // dubblett
		// bst.add(8); //
		// bst.add(9);bst.add(4);bst.add(18);bst.add(22);bst.add(-6);bst.add(6);
		// bst.add(11);bst.add(12);

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 200; i++) {
			list.add(new Integer(i));
		}
		Collections.shuffle(list);
		for (int i = 0; i < 40; i++) {
			bst.add(list.get(i));
		}

		bst.printTree();
		System.out.println();
		System.out.println("size: " + bst.size + " Height:" + bst.height() + "\n");
		System.out.println("Rebuilding in..");
		window.drawTree(bst);

		for (int i = 0; i < 5; i++) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(7 - i);
		}
		bst.rebuild();

		System.out.println("size: " + bst.size + " Height:" + bst.height());

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
		if (x.compareTo(curNode.element) < 0) {
			if (curNode.left == null) {
				curNode.left = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return addRec(curNode.left, x);
		} else if (x.compareTo(curNode.element) > 0) {
			if (curNode.right == null) {
				curNode.right = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return addRec(curNode.right, x);
		}
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
		if (node == null)
			return 0;
		else
			return 1 + Math.max(heightRec(node.left), heightRec(node.right));

	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
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
			System.out.print(bn.element + "|");
			inOrder(bn.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		toArray(root, a, 0);

		root = buildTree(a, 0, size() - 1);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a starting at a[index]. Returns the index of the last inserted element + 1 (the first empty position in
	 * a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n.left != null) // Vi bryr oss bara om ifall det finns en left eller inte. Finns ingen left så
			index = toArray(n.left, a, index);

		a[index] = n.element;
		index++;

		if (n.right != null)
			index = toArray(n.right, a, index);

		return index;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in the array a are assumed to be in ascending order. Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		int mid = (last + first) / 2;
		BinaryNode<E> node = new BinaryNode<>(a[mid]);

		if (mid - first > 0)// Finns någon till vänster?
			node.left = buildTree(a, first, mid - 1);
		if (mid - last < 0) // Finns någon till höger?
			node.right = buildTree(a, mid + 1, last);

		return node;
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
