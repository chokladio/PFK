package binarytree;

public class BinaryTree<E> {
	private Node<E> root;

	/** Skapar ett tomt träd. */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Skriver ut innehållet i de noder som är större än eller lika med min och
	 * mindre än eller lika med max i växande ordning.
	 */
	public void printPart(E min, E max) {
		printPart(root, min, max);
	}

	private void printPart(Node<E> n, E min, E max) {
	if (n != null) {
	if (n.element.compareTo(min) > 0) { // vänster subträd kan ha
	// element i rätt intervall
	printPart(n.left, min, max);
	}
	if (n.element.compareTo(min) >= 0 &&
	n.element.compareTo(max) <= 0) { // min<=n.element<=max, skriv ut
	System.out.println(n.element);
	}
	if (n.element.compareTo(max) < 0) { // höger subträd kan ha
	// element i rätt intervall
	printPart(n.right, min, max);
	}
	}
	}

	/**
	 * Skapar ett binärt träd med innehållet data i roten och med leftTree som
	 * vänster underträd och rightTree som höger underträd.
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}

	/** Skriver ut trädets noder i inorder. */
	public void printInorder() {
		printInorder(root);
	}

	private void printInorder(Node<E> n) {
		// Fyll i egen kod
	}

	private static class Node<E> {
		private E element;
		private Node<E> left;
		private Node<E> right;

		public Node(E data) {
			this.element = data;
			left = right = null;
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

	public static void main(String[] args) {
		BinaryTree<String> empty = new BinaryTree<String>();
		empty.printInorder();

		BinaryTree<String> tmp = new BinaryTree<String>("d", null, null);
		BinaryTree<String> left = new BinaryTree<String>("b", null, tmp);
		tmp = new BinaryTree<String>("e", null, null);
		BinaryTree<String> right = new BinaryTree<String>("c", tmp, null);
		BinaryTree<String> tree = new BinaryTree<String>("a", left, right);
		tree.printInorder();
	}

}
