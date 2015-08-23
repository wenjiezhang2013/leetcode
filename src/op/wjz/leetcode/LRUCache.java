package op.wjz.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	LinkedHashMap<Integer, Integer> cache;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else
			return -1;

	}

	public void set(int key, int value) {
		cache.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);

		System.err.println(cache.get(1));

		System.err.println(cache);

	}
}