import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryCacheChallenge {

    private static class CacheEntry<V> {
        private final V value;
        private final long createdAt;

        public CacheEntry(V value) {
            this.value = value;
            this.createdAt = System.currentTimeMillis();
        }

        public boolean isExpired(long ttlMillis) {
            return (System.currentTimeMillis() - createdAt) > ttlMillis;
        }

        public V getValue() { return value; }
    }

    public static class SimpleCache<K, V> {
        private final Map<K, CacheEntry<V>> store = new ConcurrentHashMap<>();
        private final long ttlMillis;

        public SimpleCache(long ttlMillis) {
            this.ttlMillis = ttlMillis;
        }

        public void put(K key, V value) {
            store.put(key, new CacheEntry<>(value));
        }

        public Optional<V> get(K key) {
            CacheEntry<V> entry = store.get(key);

            if (entry == null) {
                return Optional.empty();
            }

            if (entry.isExpired(ttlMillis)) {
                store.remove(key);
                return Optional.empty();
            }

            return Optional.of(entry.getValue());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleCache<String, String> sessionCache = new SimpleCache<>(1000);

        System.out.println("--- Saving User Session Data ---");
        sessionCache.put("user_101", "Token_ABCXYZ_999");

        Optional<String> immediateCheck = sessionCache.get("user_101");
        System.out.println("Immediate fetch: " + immediateCheck.orElse("Expired/Not Found"));

        System.out.println("\nSleeping for 1200ms...");
        Thread.sleep(1200);

        Optional<String> delayedCheck = sessionCache.get("user_101");
        System.out.println("Fetch after delay: " + delayedCheck.orElse("Expired/Not Found"));
    }
}