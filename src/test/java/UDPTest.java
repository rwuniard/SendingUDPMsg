import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class UDPTest {
    UDPClient client;

    @BeforeEach
    public void setup(){
        new UDPServer(4445).start();
        client = new UDPClient(4445);
    }

    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        assertEquals("hello server", echo);
        echo = client.sendEcho("server is working");
        System.out.println(echo);
        assertFalse(echo.equals("hello server"));
    }

    @AfterEach
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}
