
import com.ll.MyHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HashMapTests {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void testPut() {
        map.put("Key1", 1);
        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    void testGet() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.get("Key1")).isEqualTo(1);
        assertThat(map.get("Key2")).isEqualTo(2);
    }

    @Test
    void testRemove() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.remove("Key1");
        map.remove("Key3");
        assertThat(map.size()).isEqualTo(1);
    }
//
//    @Test
//    void testSize() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        map.put("Key3", 3);
//        assertEquals(3, map.size());
//    }

    //    @Test
//    void testPutReplace() {
//        map.put("Key1", 1);
//        map.put("Key1", 2);
//        assertThat(map.size()).isEqualTo(1);
//    }
//
//    @Test
//    void testContainsKey() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        assertTrue(map.containsKey("Key1"));
//        assertFalse(map.containsKey("Key3"));
//    }
//
//    @Test
//    void testContainsValue() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        assertTrue(map.containsValue(1));
//        assertFalse(map.containsValue(3));
//    }
//
//    @Test
//    void testClear() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        map.put("Key3", 3);
//        map.clear();
//        assertEquals(0, map.size());
//        assertTrue(map.isEmpty());
//    }
}