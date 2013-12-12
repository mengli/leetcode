package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 */

public class LRUCache {

	public class CacheItem<T> {

		private T value;
		private BiListNode<T> listRef;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public CacheItem(T value, BiListNode<T> listRef) {
			this.value = value;
			this.setListRef(listRef);
		}

		public BiListNode<T> getListRef() {
			return listRef;
		}

		public void setListRef(BiListNode<T> listRef) {
			this.listRef = listRef;
		}
	}

	public class BiListNode<T> {

		private T value;
		private BiListNode<T> prev;
		private BiListNode<T> next;

		public BiListNode() {
		}

		public BiListNode(T value) {
			this.value = value;
		}

		public BiListNode<T> getPrev() {
			return prev;
		}

		public void setPrev(BiListNode<T> prev) {
			this.prev = prev;
		}

		public BiListNode<T> getNext() {
			return next;
		}

		public void setNext(BiListNode<T> next) {
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}
	}

	public class BidirectionalList<T> {
		private BiListNode<T> head = new BiListNode<T>();
		private BiListNode<T> tail = head;

		public BiListNode<T> insertTail(BiListNode<T> node) {
			tail.next = node;
			node.prev = tail;
			tail = node;
			return node;
		}

		public BiListNode<T> deleteTail() {
			if (head.next == null)
				return null;
			BiListNode<T> ret = tail;
			tail = tail.prev;
			tail.next = null;
			ret.prev = null;
			return ret;
		}

		public void insertHead(BiListNode<T> node) {
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
			node.prev = head;
		}

		public void delete(BiListNode<T> node) {
			if (head.next == null) return;
			if (node == head.next) {
				deleteHead();
				return;
			}
			if (node == tail) {
				deleteTail();
				return;
			}
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
		
		public BiListNode<T> deleteHead() {
			if (head.next == null)
				return null;
			BiListNode<T> ret = head.next;
			head.next = ret.next;
			ret.next.prev = head;
			ret.next = null;
			ret.prev = null;
			return ret;
		}
	}

	private Map<Integer, CacheItem<Integer>> cacheMap = new HashMap<Integer, CacheItem<Integer>>();
	private BidirectionalList<Integer> cacheList = new BidirectionalList<Integer>();
	private int cacheSize = 0;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		CacheItem<Integer> itm = cacheMap.get(key);
		if (itm == null) return -1;
		cacheList.delete(itm.listRef);
		cacheList.insertTail(itm.listRef);
		return itm.value.intValue();
	}

	public void set(int key, int value) {
		if (cacheSize == capacity) {
			BiListNode<Integer> removedKey = cacheList.deleteHead();
			cacheMap.remove(removedKey);
			if (removedKey != null) {
				cacheSize--;
			}
		}
		if (cacheSize < capacity) {
			BiListNode<Integer> n = cacheList.insertTail(new BiListNode<Integer>(key));
			cacheMap.put(key, new CacheItem<Integer>(value, n));
			cacheSize++;
		}
	}
	
	public void dump() {
		for (Integer k : cacheMap.keySet()) {
			System.out.println(k);
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		cache.get(2);
		cache.set(4, 1);
		cache.get(1);
		cache.get(2);
		//cache.set(4, 4);
		cache.dump();
	}
}
