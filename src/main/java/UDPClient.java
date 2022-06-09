import java.io.IOException;
import java.net.*;

public class UDPClient {
    private DatagramSocket socket;
    private InetAddress address;
    private int _port;

    private byte[] buf;

    public UDPClient(int port) {
        try {
            _port = port;
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        }
        catch(SocketException soe) {
            System.out.println(soe);
        }
        catch (UnknownHostException uhe) {
            System.out.println(uhe);
        }
    }

    public String sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, address, _port);
        try {
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            // Commenting out the echo back from server since we don't need to get an echo.
//            socket.receive(packet);
//            String received = new String(
//                    packet.getData(), 0, packet.getLength());
            String received = "";
            return received;
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        return null;
    }

    public void close() {
        socket.close();
    }
}
