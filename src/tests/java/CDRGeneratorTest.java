import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CDRGeneratorTest {
    @Test
    void testGenerateCDRFile() {
        String fileName = "test_cdr.txt";
        CDRGenerator.generateCDRFile(fileName);
        assertTrue(new File(fileName).exists());
    }
}