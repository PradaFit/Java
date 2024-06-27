/**
 * 
 * @author PradaFit
 * 
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Scan a range of ports on a given host
 * To check if they're open
 * Also uses multithreading to speed up the process
 *
 * @version 1.0
 */
public class PortScanner {

    private static final int THREAD_POOL_SIZE = 1000; // Increased # of threads for faster scanning
    private static final int TIMEOUT = 100; // Connection timeout in milliseconds

    /**
     * Scans a range of ports on a given host to check if they're open
     *
     * @param host The target host to scan
     * @param startPort The starting port # in the range
     * @param endPort The ending port # in the range
     */
    public static void scanPorts(String host, int startPort, int endPort) {
        System.out.println("Scanning ports on target: " + host);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        AtomicBoolean anyOpenPorts = new AtomicBoolean(false);

        for (int port = startPort; port <= endPort; port++) {
            final int currentPort = port;
            executorService.submit(() -> {
                try (Socket socket = new Socket()) {
                    socket.connect(new InetSocketAddress(host, currentPort), TIMEOUT);
                    System.out.println("Port " + currentPort + " is open");
                    anyOpenPorts.set(true);
                } catch (IOException e) {
                    // Port is closed or not reachable
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        if (!anyOpenPorts.get()) {
            System.out.println("No open ports found in the specified range.");
        }

        System.out.println("Scanning DONE, ya digg!");
    }

    /**
     * Method that reads user input and starts port scanning
     *
     * @param args cmd. line arg.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueScanning = true;

        while (continueScanning) {
            String host;
            int startPort;
            int endPort;
            boolean scanAllPorts;

            // Check if the user provided the req. args.
            if (args.length != 4) {
                System.out.println("Usage: java PortScanner <target> <startPort> <endPort> <all>");
                System.out.print("Enter target: ");
                host = scanner.nextLine();

                System.out.print("Enter start port: ");
                startPort = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter end port: ");
                endPort = Integer.parseInt(scanner.nextLine());

                System.out.print("Scan all ports (true/false): ");
                scanAllPorts = Boolean.parseBoolean(scanner.nextLine());

                if (scanAllPorts) {
                    startPort = 1;
                    endPort = 65535; // Highest TCP port number
                }
            } else {
                host = args[0];
                startPort = Integer.parseInt(args[1]);
                endPort = Integer.parseInt(args[2]);
                scanAllPorts = Boolean.parseBoolean(args[3]);

                if (scanAllPorts) {
                    startPort = 1;
                    endPort = 65535; // Highest TCP port number
                }
            }

            scanPorts(host, startPort, endPort);

            System.out.print("Do you want to scan a new target? (Yes/No): ");
            String response = scanner.nextLine();
            continueScanning = response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase("y") || response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes");
        }

        scanner.close();
        System.out.println("By: PradaFit");
    }
}
