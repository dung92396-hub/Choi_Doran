package ExtendsHashMap;

import java.util.HashMap;

public class HoangPhucMap<K, V> extends HashMap<K, V> {
    public void replaceKey(K oldKey, K newKey) {
        boolean k = this.containsKey(oldKey);
        if (k) {
            V value = this.get(oldKey);
            this.remove(oldKey);
            this.put(newKey, value);
        }
    }
}
