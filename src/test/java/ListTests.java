import com.ll.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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
    @DisplayName("리스트에 요소 추가 후 포함 여부 확인")
    void testContains() {
        list.add("Element1");
        list.add("Element2");
        assertThat(list.contains("Element1")).isEqualTo(true);
        assertThat(list.contains("Element3")).isEqualTo(false);
    }

    @Test
    @DisplayName("리스트의 요소 인덱스 찾기")
    void testIndexOf() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element1");
        assertThat(list.indexOf("Element1")).isEqualTo(0);
        assertThat(list.indexOf("Element3")).isEqualTo(-1);
    }

    @Test
    @DisplayName("리스트 초기화")
    void testClear() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.clear();
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    @DisplayName("리스트 길이 지정, 길이 보다 많은 요소 추가 후 체크")
    void testAdd2() {
        list = new MyArrayList<>(20);
        IntStream.range(0, 100)
                .forEach(e -> list.add("사과 %d".formatted(e)));

        assertThat(list.size()).isEqualTo(100);
        assertThat(list.indexOf("사과 5")).isEqualTo(5);
        assertThat(list.indexOf("사과 100")).isEqualTo(-1);
    }

    @Test
    @DisplayName("리스트에 다른 요소 추가")
    void testAdd3() {
        MyArrayList<Boolean> list = new MyArrayList<>();

        list.add(true);
        list.add(false);
        list.add(true);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.indexOf(false)).isEqualTo(1);
    }

    @Test
    @DisplayName("리스트 중간에 인덱스로 요소 집어넣기")
    void testAddAtIndex() {
        list.add("사과1");
        list.add("사과2");
        list.add(1, "사과3");

        assertThat(list.get(1)).isEqualTo("사과3");
    }
}
