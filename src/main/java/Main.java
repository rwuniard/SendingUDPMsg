import java.sql.Timestamp;
import java.util.Random;
public class Main {

    public static void main(String args[]) {
        System.out.println("This is main!");

        UDPClient client = new UDPClient(8125);
        int i = 1000;
        Random rand = new Random();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        while (i>0) {
//            System.out.println(timestamp);
            client.sendEcho("shoehub.test:1|c");
            client.sendEcho("shoehub.us.sales:" + rand.nextInt(10)+"|c");
            client.sendEcho("shoehub.us.payment.cash:"+ rand.nextInt(1000)+"|c");
            client.sendEcho("shoehub.us.payment.credit:" + rand.nextInt(1000) + "|c");
            client.sendEcho("shoehub.us.refunds:" + rand.nextInt(1000) + "|c");

            client.sendEcho("shoehub.ido.sales:" + rand.nextInt(10)+"|c");
            client.sendEcho("shoehub.ido.payment.cash:"+ rand.nextInt(1000)+"|c");
            client.sendEcho("shoehub.ido.payment.credit:" + rand.nextInt(1000) + "|c");
            client.sendEcho("shoehub.ido.refunds:" + rand.nextInt(1000) + "|c");
//            client.sendEcho("shoehub.us.mymetric 100 date " + timestamp + "|g");
            System.out.println("sending msg");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            i--;
        }
    }
}
