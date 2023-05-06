
import com.ll.MyHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("배열 자동 증가")
    void testPut2() {
        map.put("Key1",1);
        map.put("Key2",2);

        assertThat(map.put("Key2",3)).isEqualTo(2);
        assertThat(map.size()).isEqualTo(2);

        map.put("Key3",3);
        assertThat(map.size()).isEqualTo(3);
    }

    @Test
    void testRemove() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.remove("Key2")).isEqualTo(2);
        assertThat(map.remove("Key3")).isEqualTo(null);
        assertThat(map.size()).isEqualTo(1);
    }
}