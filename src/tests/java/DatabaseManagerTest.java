import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DatabaseManagerTest {
    @Test
    void testSaveTransaction() {
        assertDoesNotThrow(() -> DatabaseManager.saveTransaction("79998887766", System.currentTimeMillis(), System.currentTimeMillis() + 3600));
    }
}
