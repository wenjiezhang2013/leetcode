package op.wjz.leetcode;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * Least Frequently Used
 * 
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example: <blockquote>
 * 
 * <pre>
 * LFUCache cache = new LFUCache(2);
 * cache.set(1, 1);
 * cache.set(2, 2);
 * cache.get(1); // returns 1
 * cache.set(3, 3); // evicts key 2
 * cache.get(2); // returns -1 (not found)
 * cache.get(3); // returns 3.
 * cache.set(4, 4); // evicts key 1.
 * cache.get(1); // returns -1 (not found)
 * cache.get(3); // returns 3
 * cache.get(4); // returns 4}
 * </pre>
 * 
 * </blockquote>
 * 
 * @author wenjiezhang
 *
 */
public class LFUCache {

	public static int counter = 0;

	@Override
	public String toString() {
		return "LFUCache [cache=" + cache + ", capacity=" + capacity + "]";
	}

	public TreeSet<Entity> cache;
	public HashMap<Integer, Entity> keyValue;
	int capacity;

	public LFUCache(int capacity) {
		this.capacity = capacity;

		Comparator<Entity> comparator = new Comparator<Entity>() {

			@Override
			public int compare(Entity o1, Entity o2) {
				int result = o2.count.compareTo(o1.count);

				if (result == 0) {
					result = o2.counter.compareTo(o1.counter);
					if (result == 0) {
						// System.out.println();
						// System.out.println("This - " + this);
						// System.out.println("O - " + o);
						// System.out.println();
					}
				}
				return result;
			}
		};

		cache = new TreeSet<>(comparator);
		keyValue = new HashMap<>();
	}

	public int get(int key) {
		if (keyValue.containsKey(key)) {
			Entity entity = keyValue.get(key);
			cache.remove(entity);
			entity.count++;
			entity.counter = LFUCache.counter++;
			cache.add(entity);
			return entity.value;
		} else {
			return -1;
		}

	}

	public void set(int key, int value) {
		if (this.capacity == 0)
			return;
		if (!keyValue.containsKey(key)) {
			if (keyValue.size() == capacity) {
				Entity entity = cache.last();
				keyValue.remove(entity.key);
				cache.remove(entity);
			}

			Entity entity = new Entity(key, 1, value);
			keyValue.put(key, entity);
			cache.add(entity);
		} else {
			Entity entity = keyValue.get(key);
			cache.remove(entity);
			entity.value = value;
			entity.counter = LFUCache.counter++;
			cache.add(entity);
		}

	}

	public static void main(String[] args) {
		// ["LFUCache","set","set","get","set","get","get","set","get","get","get"]
		// [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

		LFUCache cache = new LFUCache(2);
		cache.set(1, 1);
		System.out.println(cache);

		cache.set(2, 2);
		System.out.println(cache);

		System.out.println(cache.get(1));
		System.out.println(cache);

		cache.set(3, 3);
		System.out.println(cache);

		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.set(4, 4);
		System.out.println(cache);
		System.out.println(cache.get(1));
	}
}

class Entity {
	public final Integer key;
	public Integer count;
	public Integer counter;
	public int value;

	Entity(int key, int count, int value) {
		this.key = key;
		this.count = count;
		this.counter = LFUCache.counter++;
		this.value = value;
	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Entity)) {
			return false;
		}

		Entity other = (Entity) obj;
		return other.key.equals(this.key);
	}

	@Override
	public String toString() {
		return "Entity [key=" + key + ", count=" + count + ", counter=" + counter + "]";
	}

}