package binarysearchtree;

import binarytree.BinaryTree.Node;

public class BinarySearchTree<E extends Comparable<? super E>> {
	private Node<E> root;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		return false;
	}

	private void printPart(Node<E> n, E min, E max) {
		if (n != null) {
			if (n.element.compareTo(min) > 0) { // vänster subträd kan ha
				// element i rätt intervall
				printPart(n.left, min, max);
			}
			if (n.element.compareTo(min) >= 0 && n.element.compareTo(max) <= 0) { // min<=n.element<=max, skriv ut
				System.out.println(n.element);
			}
			if (n.element.compareTo(max) < 0) { // höger subträd kan ha
				// element i rätt intervall
				printPart(n.right, min, max);
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	public void buildString(Node<E> n, StringBuilder sb) {
		if (n != null) {
			buildString(n.left, sb);
			sb.append(n.element.toString());
			sb.append('\n');
			buildString(n.right, sb);
		}
	}

	private static class Node<E extends Comparable<? super E>> {
		private E element;
		private Node<E> left;
		private Node<E> right;

		private Node(E element) {
			this.element = element;
		}
	}

}
