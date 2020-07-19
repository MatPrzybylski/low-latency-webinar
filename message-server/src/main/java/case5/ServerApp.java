package case5;

import case5.service.MessageService;

public class ServerApp {

    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        messageService.start();
    }
}
