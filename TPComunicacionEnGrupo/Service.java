import java.io.IOException;

public class Service {

    public static void sendMessage(String[] group) throws IOException {
        var message = "Mensaje";

        for (var i = 0; i < group.length; i++) {
            Service.sendMessageForOne(message, group[i]);
        }
    }

    public static void sendMessageForOne(String message, String ip) throws IOException {
        Udp.sendMessage(message, ip);
    }
}