package first_round;
import java.util.LinkedList;
import java.util.Queue;


public class LRUCache {
	public static void main(String[] args){
	//	Queue x = new Queue();
		LRUCache lru = new LRUCache(3);
		lru.set(1, 2);
		lru.set(2, 4);
		lru.set(3, 6);	
		lru.get(2);
		lru.get(1);
		
		lru.set(4, 8);
		
		int[][] c = lru.cache;
		
		for(int i = 0; i < c.length; i++){
			System.out.println(c[i][0]);
		}
	}
	
	public int[][] cache;
	private final int noKey = Integer.MIN_VALUE;
	private int size = 0;
	
    public LRUCache(int capacity) {
        cache = new int[capacity][2];
        for(int i = 0; i < capacity; i++){
        	cache[i][0] = noKey;
        	cache[i][1] = -1;
        }
    }
    
    public int get(int key) {
        for(int i = 0; i < cache.length; i++){
        	if(cache[i][0] == key){
        		move(cache, i);
        		return cache[i][1];
        	}
        }
    	return -1;
    }
    
    private void move(int[][] cache, int j) {
		int tempKey = cache[j][0];
		int tempValue = cache[j][1];
		for(int i = j-1; i >= 0 ; i--){
			cache[i+1][0] = cache[i][0];
			cache[i+1][1] = cache[i][1];
		}
		cache[0][0] = tempKey;
		cache[0][1] = tempValue;
	}

	public void set(int key, int value) {
        for(int i = 0; i < size; i++){
    	    if(cache[i][0] == key){
    		    cache[i][1] = value;
    		    move(cache, i);
    		    return;
    	    }
        }
        
        if (size < cache.length) {
        	move(cache, size++);
        } else{
        	move(cache, cache.length-1);
        }
    	cache[0][0] = key;
    	cache[0][1] = value;
    }

}

