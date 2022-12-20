import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.net.InetAddress.getLocalHost;

public class Main {
    static int port = 8080;
    static String hostname = "localhost"; //18.204.213.255

    static String test5 = """
            2#
            route:game.close;
            game_id:91bb5698-de0a-4753-b488-16896a1a6f1b;
            """;
    static String test4 = """
            2#
            route:game.state;
            game_id:91bb5698-de0a-4753-b488-16896a1a6f1b;
            """;
    static String test3 = """
            3#
            route:game.enter;
            key:ODFA;
            player_id:a73c5407-980c-439e-82cc-04ea6c0fa369;
            """;
    static String test2 = """
            2#
            route:game.start;
            player_id:a73c5407-980c-439e-82cc-04ea6c0fa369;
            """;
    static String test1 = """
            2#
            route:player.add;
            name:Alperen;
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

                    out.writeBytes(test5);


                    //System.out.println(s.isClosed());


                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String line = "";
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);

                    }



                    System.out.println("end...");
                    break;
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