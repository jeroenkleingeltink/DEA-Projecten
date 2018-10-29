package jeroen.school.dea;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Hello world!
 *
 */
public class HttpServer
{
    private int tcpPort;
    Thread serverThread;

    public HttpServer(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public static void main( String[] args )
    {
        new HttpServer(8383).startServer();
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(this.tcpPort)) {
            System.out.println("Server accepting requests on port " + tcpPort);
            while(true) {
                serverThread = new Thread(new ConnectionHandler(serverSocket.accept()));
                serverThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
