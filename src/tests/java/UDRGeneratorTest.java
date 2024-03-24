import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UDRGeneratorTest {
    @Test
    void testGenerateUDR() {
        // Предположим, что есть CDR файл с данными
        // Тестируем, что генерация UDR проходит успешно без исключений
        assertDoesNotThrow(() -> UDRGenerator.generateUDR());
    }
}