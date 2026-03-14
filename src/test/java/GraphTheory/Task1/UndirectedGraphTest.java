package GraphTheory.Task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UndirectedGraph Tests")
class UndirectedGraphTest {

    private UndirectedGraph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new UndirectedGraph<>();
    }

    // ─── addVertex ────────────────────────────────────────────────────────────

    @Test
    @DisplayName("addVertex(v1, v2) – thêm cạnh hai chiều")
    void testAddVertex_bidirectional() {
        graph.addVertex(1, 2);
        // 1 -> 2  và  2 -> 1
        assertTrue(graph.adjacencyList.get(1).contains(2));
        assertTrue(graph.adjacencyList.get(2).contains(1));
    }

    @Test
    @DisplayName("addVertex(v1, v2) – tự tạo đỉnh nếu chưa tồn tại")
    void testAddVertex_createsVertices() {
        graph.addVertex(5, 9);
        assertTrue(graph.adjacencyList.containsKey(5));
        assertTrue(graph.adjacencyList.containsKey(9));
    }

    @Test
    @DisplayName("addVertex(v1, v2, true) – tạo khuyên (self-loop) tại v1")
    void testAddVertex_selfLoop() {
        graph.addVertex(1, 1, true);
        assertTrue(graph.adjacencyList.get(1).contains(1),
                "Phải có khuyên tại đỉnh 1");
    }

    // ─── removeVertex ─────────────────────────────────────────────────────────

    @Test
    @DisplayName("removeVertex – xoá đỉnh và tất cả cạnh liên quan")
    void testRemoveVertex() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
        graph.removeVertex(1);

        assertFalse(graph.adjacencyList.containsKey(1));
        assertFalse(graph.adjacencyList.get(2).contains(1));
        assertFalse(graph.adjacencyList.get(3).contains(1));
    }

    @Test
    @DisplayName("removeVertex – ném ngoại lệ khi đỉnh không tồn tại")
    void testRemoveVertex_notFound() {
        assertThrows(IllegalArgumentException.class, () -> graph.removeVertex(99));
    }

    // ─── containsLoop ─────────────────────────────────────────────────────────

    @Test
    @DisplayName("containsLoop – false khi không có khuyên")
    void testContainsLoop_false() {
        graph.addVertex(1, 2);
        graph.addVertex(2, 3);
        assertFalse(graph.containsLoop());
    }

    @Test
    @DisplayName("containsLoop – true khi có khuyên")
    void testContainsLoop_true() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 1, true);   // self-loop tại 1
        assertTrue(graph.containsLoop());
    }

    // ─── countVertexLevels ────────────────────────────────────────────────────

    @Test
    @DisplayName("countVertexLevels – bậc đúng trong đồ thị đơn")
    void testCountVertexLevels_simple() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
        // đỉnh 1 kề với 2 và 3  ->  bậc = 2
        assertEquals(2, graph.countVertexLevels(1));
    }

    @Test
    @DisplayName("countVertexLevels – khuyên đóng góp 2 vào bậc")
    void testCountVertexLevels_loop() {
        graph.addVertex(1, 1, true);
        // khuyên -> bậc = 2
        assertEquals(2, graph.countVertexLevels(1));
    }

    @Test
    @DisplayName("countVertexLevels – ném ngoại lệ khi đỉnh không tồn tại")
    void testCountVertexLevels_notFound() {
        assertThrows(IllegalArgumentException.class, () -> graph.countVertexLevels(42));
    }

    // ─── countEdges ───────────────────────────────────────────────────────────

    @Test
    @DisplayName("countEdges – đếm đúng số cạnh K4")
    void testCountEdges_K4() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
        graph.addVertex(1, 4);
        graph.addVertex(2, 3);
        graph.addVertex(2, 4);
        graph.addVertex(3, 4);
        // K4 có 6 cạnh
        assertEquals(6, graph.countEdges());
    }

    @Test
    @DisplayName("countEdges – đồ thị rỗng (chưa có cạnh)")
    void testCountEdges_empty() {
        assertEquals(0, graph.countEdges());
    }

    // ─── isComplete ───────────────────────────────────────────────────────────

    @Test
    @DisplayName("isComplete – K4 là đồ thị đầy đủ")
    void testIsComplete_K4() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
        graph.addVertex(1, 4);
        graph.addVertex(2, 3);
        graph.addVertex(2, 4);
        graph.addVertex(3, 4);
        assertTrue(graph.isComplete());
    }

    @Test
    @DisplayName("isComplete – false khi thiếu cạnh")
    void testIsComplete_false() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
        // thiếu cạnh (2,3)
        assertFalse(graph.isComplete());
    }

    // ─── getType ──────────────────────────────────────────────────────────────

    @Test
    @DisplayName("getType – SIMPLE_GRAPH khi không có khuyên / song song")
    void testGetType_simple() {
        graph.addVertex(1, 2);
        graph.addVertex(2, 3);
        assertEquals(GraphType.SIMPLE_GRAPH, graph.getType());
    }

    @Test
    @DisplayName("getType – PSEUDO_GRAPH khi có khuyên")
    void testGetType_pseudo() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 1, true);
        assertEquals(GraphType.PSEUDO_GRAPH, graph.getType());
    }

    @Test
    @DisplayName("getType – MULTI_GRAPH khi có cạnh song song")
    void testGetType_multi() {
        graph.addVertex(1, 2);
        graph.addVertex(1, 2);   // cạnh song song
        assertEquals(GraphType.MULTI_GRAPH, graph.getType());
    }

    // ─── toString ─────────────────────────────────────────────────────────────

    @Test
    @DisplayName("toString – không null và không rỗng sau khi thêm cạnh")
    void testToString_notEmpty() {
        graph.addVertex(1, 2);
        String result = graph.toString();
        assertNotNull(result);
        assertFalse(result.isBlank());
    }
}

