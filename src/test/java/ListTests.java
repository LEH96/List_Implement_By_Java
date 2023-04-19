
import com.ll.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTests {
    private MyArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    @DisplayName("리스트 크기 확인")
    void testSize() {
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("리스트에 요소 추가 후 크기 확인")
    void testAdd() {
        list.add("사과");
        list.add("포도");
        assertThat(list.size()).isEqualTo(2);
    }
//
//    @Test
//    void testRemove() {
//        list.add("Element1");
//        list.add("Element2");
//        list.add("Element3");
//        assertEquals("Element2", list.remove(1));
//        assertEquals(2, list.size());
//    }
//
//    @Test
//    void testGet() {
//        list.add("Element1");
//        list.add("Element2");
//        assertEquals("Element1", list.get(0));
//        assertEquals("Element2", list.get(1));
//    }
//
//    @Test
//    void testSize002() {
//        list.add("Element1");
//        list.add("Element2");
//        list.add("Element3");
//        assertEquals(3, list.size());
//    }
//
//    @Test
//    void testContains() {
//        list.add("Element1");
//        list.add("Element2");
//        assertTrue(list.contains("Element1"));
//        assertFalse(list.contains("Element3"));
//    }
//
//    @Test
//    void testIndexOf() {
//        list.add("Element1");
//        list.add("Element2");
//        list.add("Element1");
//        assertEquals(0, list.indexOf("Element1"));
//        assertEquals(1, list.indexOf("Element2"));
//        assertEquals(-1, list.indexOf("Element3"));
//    }
//
//    @Test
//    void testClear() {
//        list.add("Element1");
//        list.add("Element2");
//        list.add("Element3");
//        list.clear();
//        assertEquals(0, list.size());
//        assertTrue(list.isEmpty());
//    }
}
