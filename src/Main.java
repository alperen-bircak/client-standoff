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
    static String hostname = "192.168.1.58";

    public static void main(String[] args) {
        try {



            while(true) {
                Scanner in = new Scanner(System.in);
                String line = in.nextLine();

                Socket s = new Socket(hostname, port);
                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                output.writeBytes(line+"\n");
                System.out.println("You sent string " + line);
                s.close();
            }


        } catch (IOException e) {
            System.out.println(e);
        }

    }
}