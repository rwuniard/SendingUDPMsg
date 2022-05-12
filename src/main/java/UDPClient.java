import java.io.IOException;
import java.net.*;

public class UDPClient {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public UDPClient() {
        try {
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
                = new DatagramPacket(buf, buf.length, address, 4445);
        try {
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(
                    packet.getData(), 0, packet.getLength());
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
