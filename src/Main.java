import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.net.InetAddress.getLocalHost;

public class Main {
    static int port = 8080;
    static String hostname = "18.204.213.255";

    static String test = """
            3#
            route:test;
            name:Alperen;
            surname:Bircak;
            """;

    public static void main(String[] args) {
        try {
            System.out.println(hostname + ':' + port);

            while (true) {
                Scanner input = new Scanner(System.in);
                try {
                    Socket s = new Socket(hostname, port);
                    System.out.println("Connection Established.");

                    DataOutputStream out = new DataOutputStream(s.getOutputStream());

                    out.writeBytes(test);


                    //System.out.println(s.isClosed());


                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String line = "";
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);

                    }



                    System.out.println("end...");
                    Thread.sleep(2000);
                } catch (ConnectException e) {
                    System.out.println("No connection trying again...");
                    Thread.sleep(2000);
                }

            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}