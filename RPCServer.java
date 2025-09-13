
import java.io.*;
import java.net.*;

public class RPCServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is running...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {


                    String request = in.readLine();
                    int number = Integer.parseInt(request);
                    int result = factorial(number);
                    out.println(result);

                } catch (IOException e) {
                }
            }

        } catch (IOException e) {
        }
    }

    private static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
