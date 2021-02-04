import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        InetAddress inetAddress;
        File file = new File("hola.txt");
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            datagramSocket = new DatagramSocket();
            inetAddress = InetAddress.getLocalHost();
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(new Message("Hola soy tu padre"));
            byte[] buffer=byteArrayOutputStream.toByteArray();
            DatagramPacket datagramPacket1 = new DatagramPacket(buffer, buffer.length, inetAddress, 8080);
            try {
                datagramSocket.send(datagramPacket1);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SocketException | UnknownHostException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert datagramSocket != null;
        datagramSocket.close();
    }
}
