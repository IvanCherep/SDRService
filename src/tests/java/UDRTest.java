import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UDRTest {
    @Test
    void testAddIncomingCall() {
        UDR udr = new UDR("79998887766");
        udr.addIncomingCall(100);
        assertEquals(100, udr.getIncomingCall().getTotalTime());
    }

    @Test
    void testAddOutgoingCall() {
        UDR udr = new UDR("79998887766");
        udr.addOutgoingCall(200);
        assertEquals(200, udr.getOutgoingCall().getTotalTime());
    }
}