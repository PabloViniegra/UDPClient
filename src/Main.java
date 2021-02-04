import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatagramSocket datagramSocket = null;
        InetAddress inetAddress;
        try {
            datagramSocket = new DatagramSocket();
            inetAddress = InetAddress.getLocalHost();
            String userInput = "";

            byte[] buffer;
            while (!userInput.equals("*")) {
                System.out.print("Introduce un texto:");
                userInput = sc.nextLine();
                buffer = userInput.getBytes(StandardCharsets.UTF_8);
                DatagramPacket datagramPacket1 = new DatagramPacket(buffer, buffer.length,inetAddress,8080);
                try {
                    datagramSocket.send(datagramPacket1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
        assert datagramSocket != null;
        datagramSocket.close();
    }
}
