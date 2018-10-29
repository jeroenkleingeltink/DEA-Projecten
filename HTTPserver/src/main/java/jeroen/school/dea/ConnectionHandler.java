package jeroen.school.dea;

import java.nio.charset.StandardCharsets;
import java.io.*;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    private Socket socket;
    private String webPage;
    private String header;
    private ClassLoader classLoader;

    private static final String HTTP_HEADER = "HTTP/1.1 200 OK\n" +
            "Date: Mon, 27 Aug 2018 14:08:55 +0200\n" +
            "HttpServer: Simple DEA Webserver\n" +
            "Content-Length: 106\n" +
            "Content-Type: text/html\n";

    private static final String HTTP_BODY = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<h1>Hi DEA folks!</h1>\n" +
            "<p>This is a simple line in html.</p>\n" +
            "</body>\n" +
            "</html>\n" +
            "\n";

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
        this.classLoader = Thread.currentThread().getContextClassLoader();
    }

    public void handle() {
        try {
            webPage = readContentFromFile();

            header = getHeader();

            System.out.println("SWAG!");

            BufferedReader inputStreamReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));

            BufferedWriter outputStreamWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.US_ASCII));

            String requestLine;

            while ((requestLine = inputStreamReader.readLine()) != null) {
                System.out.println(requestLine);

                if (lineMarksEndOfRequest(requestLine)) {
                    writeResponseMessage(outputStreamWriter);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readContentFromFile() throws IOException {
        InputStream is = classLoader.getResourceAsStream("index.html");
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String newLine;

        while((newLine = streamReader.readLine()) != null) {
            sb.append(newLine);
        }

        streamReader.close();

        return sb.toString();
    }

    private String getHeader() {
        return "HTTP/1.1 200 OK\n" +
                "Date: Mon, 27 Aug 2018 14:08:55 +0200\n" +
                "HttpServer: Simple DEA Webserver\n" +
                "Content-Length:" + webPage.length() + "\n" +
                "Content-Type: text/html\n";
    }

    private void writeResponseMessage(BufferedWriter outputStreamWriter) {
        try {
            outputStreamWriter.write(header);
            outputStreamWriter.newLine();
            outputStreamWriter.write(webPage);
            outputStreamWriter.newLine();
            outputStreamWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println(Thread.currentThread().getId() + ": Is nu dood.");
    }

    private boolean lineMarksEndOfRequest(String requestLine) {
        return requestLine.isEmpty();
    }

    @Override
    public void run() {
        handle();
    }
}