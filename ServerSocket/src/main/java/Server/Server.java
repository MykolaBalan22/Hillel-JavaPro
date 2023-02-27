package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket basePort = new ServerSocket(8081);
            Socket client = basePort.accept();
            BufferedWriter dataToClient = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader dataToServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            if (client.isConnected()) dataToClient.write("Hello!!!");
            String receivedLine = dataToServer.readLine();
            Pattern russSymbols = Pattern.compile("[ыэёЭ]+");
            Matcher finder = russSymbols.matcher(receivedLine);
            if (finder.find()) {
                dataToClient.write("Що таке паляниця ?");
                String answer = dataToServer.readLine();
                if (answer.equals("Хліб")) {
                    dataToClient.write(LocalDateTime.now().toString());
                    dataToClient.write("На все добре !!!");
                }
            }
            client.close();
            dataToServer.close();
            dataToClient.close();
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong !");
        }
    }
}
