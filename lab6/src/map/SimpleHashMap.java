package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K, V>[] table;
	int size;
	int cap;
	double loadF;

	/**
	 * Constructs an empty hashmap with the default initial capacity (16) and the default load factor (0.75).
	 */
	public SimpleHashMap() {
		this(16);
	}

	/**
	 * Constructs an empty hashmap with the specified initial capacity and the default load factor (0.75).
	 */
	public SimpleHashMap(int capacity) {
		this(capacity, 0.75);
	}

	/**
	 * Constructs an empty hashmap with the specified initial capacity and specified load factor.
	 */
	public SimpleHashMap(int capacity, double loadFactor) {
		this.cap = capacity;
		this.loadF = loadFactor;
		this.size = 0;
		this.table = (Entry<K, V>[]) new Entry[capacity];
	}

	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public V put(K arg0, V arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size();
	}

	private class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V val;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.val = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return val;
		}

		@Override
		public V setValue(V value) {
			this.val = value;
			return val;
		}

		@Override
		public String toString() {
			return key + "=" + val;
		}

	}
}
