import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.net.InetAddress.getLocalHost;

public class Main {
    static int port = 8080;
    static String hostname = "localhost";

    public static void main(String[] args) {
        try {
            InetAddress localhost = getLocalHost();
            System.out.println(localhost.getHostAddress());

            Socket s = new Socket(hostname, port);

            System.out.println("connected");

            Scanner in = new Scanner(System.in);

            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            while(true) {
                String line = in.nextLine();
                output.writeBytes(line+"\n");
                System.out.println("You sent string " + line);
            }


        } catch (IOException e) {
            System.out.println(e);
        }

    }
}