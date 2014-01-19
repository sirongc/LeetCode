package second_round;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

public class LRUCache {
	class Node {
		Node prev;
		Node next;
		SimpleEntry<Integer, Integer> entry;
	}

	private Node head = null;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private int capacity = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			// refresh the list
			detach(n);
			attach(n);
			return n.entry.getValue();
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			// update the value
			Node n = map.get(key);
			n.entry.setValue(value);
			// refresh the list
			detach(n);
			attach(n);
		} else {
			// add a new node
			if (map.size() < capacity) {
				Node n = new Node();
				n.entry = new SimpleEntry<Integer, Integer>(key, value);
				attach(n);
				map.put(key, n);
			}
			// add a new node and remove the last node
			else {
				// add a new node
				Node n = new Node();
				n.entry = new SimpleEntry<Integer, Integer>(key, value);
				attach(n);
				map.put(key, n);
				// remove the last node
				Node last = head.prev;
				detach(last);
				map.remove(last.entry.getKey());
			}
		}
	}

	// detach the given node from the list
	private void detach(Node n) {
		if (n == head) head = n.next;
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}

	// attach the given node to the beginning of the list
	private void attach(Node n) {
		if (head != null) {
			n.prev = head.prev;
			head.prev.next = n;
			n.next = head;
			head.prev = n;
			head = n;
		} else {
			head = n;
			head.next = n;
			head.prev = n;
		}
	}
}