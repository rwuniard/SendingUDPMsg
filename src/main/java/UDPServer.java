import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer extends Thread {
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    public UDPServer() {
        try {
            socket = new DatagramSocket(4445);
        }
        catch (SocketException soe) {
            System.out.println(soe);
        }
    }

    public void run() {
        running = true;
        try{
            while (running) {
                DatagramPacket packet
                        = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received
                        = new String(packet.getData(), 0, packet.getLength());

                if (received.equals("end")) {
                    running = false;
                    continue;
                }
                socket.send(packet);
            }
            socket.close();
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
}
