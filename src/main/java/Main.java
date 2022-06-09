public class Main {
    public static void main(String args[]) {
        System.out.println("This is main!");

        UDPClient client = new UDPClient(8125);
        int i = 10;
        while (i>0) {
            client.sendEcho("shoehub.test:1|c");
            System.out.println("sending msg");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            i--;
        }
    }
}
