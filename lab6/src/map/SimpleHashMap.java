package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K, V>[] table;
	int size;
	int capacity;
	double loadFactor;

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
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		this.size = 0;
		this.table = (Entry<K, V>[]) new Entry[capacity];
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		for (Entry<K, V> e : table) {
			sb.append(e.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public V get(Object arg0) {
		K key = (K) arg0;
		Entry<K, V> e = find(index(key), key);
		if (e != null)
			return e.getValue();
		return null;
	}

	private int index(K key) {
		return Math.abs(key.hashCode()) % capacity; // googlade
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> e = table[index];
		return e != null ? e : null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public V put(K arg0, V arg1) {
		if (find(index(arg0), arg0) != null) {
			return find(index(arg0), arg0).val;
		}

		Entry<K, V> e = new Entry(arg0, arg1);
		size++;
		return null;
	}
	
	private rehash() {
		
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
