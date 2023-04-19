
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
    @DisplayName("초기 리스트 크기 확인")
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

    @Test
    @DisplayName("리스트에 요소 제거 후 크기 확인")
    void testRemove() {
        list.add("사과");
        list.add("포도");
        assertThat(list.remove(0)).isEqualTo("사과");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("리스트에 요소 가져오기")
    void testGet() {
        list.add("사과");
        list.add("포도");
        assertThat(list.get(1)).isEqualTo("포도");
    }

    @Test
    void testContains() {
        list.add("Element1");
        list.add("Element2");
        assertThat(list.contains("Element1")).isEqualTo(true);
        assertThat(list.contains("Element3")).isEqualTo(false);
    }

    @Test
    void testIndexOf() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element1");
        assertThat(list.indexOf("Element1")).isEqualTo(0);
        assertThat(list.indexOf("Element3")).isEqualTo(-1);
    }

    @Test
    void testClear() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.clear();
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isEqualTo(true);
    }
}
