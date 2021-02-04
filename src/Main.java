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
        FileInputStream fileInputStream;
        try {
            datagramSocket = new DatagramSocket();
            inetAddress = InetAddress.getLocalHost();
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer;

            byte[] buf = new byte[1024];
            try {
                for (int readNum; (readNum = fileInputStream.read(buf)) != -1;) {
                    byteArrayOutputStream.write(buf, 0, readNum); //no doubt here is 0
                    //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                    System.out.println("read " + readNum + " bytes,");
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            buffer = byteArrayOutputStream.toByteArray();
            DatagramPacket datagramPacket1 = new DatagramPacket(buffer, buffer.length, inetAddress, 8080);
            try {
                datagramSocket.send(datagramPacket1);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SocketException | UnknownHostException | FileNotFoundException e) {
            e.printStackTrace();
        }
        assert datagramSocket != null;
        datagramSocket.close();
    }
}
