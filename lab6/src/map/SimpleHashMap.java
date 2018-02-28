package map;

import javafx.application.Application;

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

	public static void main(String[] args) { // MAIN
		SimpleHashMap<Integer, Integer> shm = new SimpleHashMap<>(10);
		shm.put(12, 12);
		shm.put(11, 11);
		shm.put(-32, -32);
		shm.put(2, 2);
		shm.put(-1, -1);
		shm.put(-2, -2);
		
		shm.put(15, 15);
		shm.put(15, 12);
	
		
		
		System.out.println(shm.show());
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Entry<K, V> e : table) {
			sb.append(i);
			while (e != null) {
				sb.append("\t");
				sb.append(e.getKey() + " = " + e.getValue());
				e = e.next;
			}
			sb.append("\n");
			i++;
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

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	private int index(K key) {
		return Math.abs(key.hashCode()) % capacity; // googlade
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> e = table[index];
		while (e != null) {
			if (e.getKey().equals(key))
				break;
			e = e.next;
		}
		return e == null ? null : e;
	}

	@Override
	public V put(K arg0, V arg1) {
		int ind = index(arg0);

		if (table[ind] == null) {
			table[ind] = new Entry<K, V>(arg0, arg1);
		} else {
			Entry<K, V> e = find(ind, arg0);
			if (e != null) {
				V oldVal = e.getValue();
				e.setValue(arg1);
				return oldVal;
			}
			e = table[ind];
			while (e.next != null) {
				e = e.next;
			}
			e.next = new Entry<K, V>(arg0, arg1);
		}
		size++;
		if (size > capacity * loadFactor) {
			capacity *= 2;
			rehash();
		}
		return null;
	}

	private void rehash() {
		capacity += capacity;
		Entry<K, V>[] tempT = table;
		table = (Entry<K, V>[]) new Entry[capacity];
		size = 0;
		for (Entry<K, V> e : tempT) {
			while (e != null) {
				put(e.getKey(), e.getValue());
				e = e.next;
			}

		}
	}

	@Override
	public V remove(Object arg0) {

		return null;
	}

	@Override
	public int size() {
		return this.size;
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
