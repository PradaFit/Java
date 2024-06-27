
/**
 *
 * @author PradaFit
 * @version 1.0
 *
 */
import java.io.BufferedReader; // For reading input streams
import java.io.InputStreamReader; // Also for reading input streams
import java.io.PrintWriter; // For writing output streams
import java.net.ServerSocket; // Server-side socket connections
import java.net.Socket; // Also client-side socket connections
import java.util.Scanner; // Reading user input

public class Theint {

    public static void main(String[] args) {
        // Using try-with-resources to ensure Scanner is closed after use
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompts user
            System.out.print("Select Port: ");
            int port = scanner.nextInt();

            // Ensuring ServerSocket is closed after use
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Listening on port " + port); // Informs the user is listening on the chosen port

                while (true) {
                    // Using try-with-resources to ensure client Socket, PrintWriter, and BufferedReader are closed after use
                    try (Socket clientSocket = serverSocket.accept(); PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        // Right above, accepts the client connection, PrintWriter to send responses to the client, and BufferedReader to read client input

                        System.out.println("Connection established with " + clientSocket.getInetAddress().getHostAddress());
                        // Right above informs the user that the connection is established

                        String inputLine; // Variable to store client input
                        // Reading client input line by line
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println("Received: " + inputLine);
                            // Echo the received message back to the client
                            out.println("Echo: " + inputLine);

                            // Break the loop if the client sends "exit"
                            if ("exit".equalsIgnoreCase(inputLine)) {
                                break;
                            }
                        }
                    } catch (Exception e) {
                        // Handling exceptions related to client connections
                        System.out.println("Error in client connection: " + e.getMessage());
                    }
                }
            } catch (Exception e) {
                // Handling exceptions related to the server
                System.out.println("Error in server: " + e.getMessage());
            }
        }
    }
}
