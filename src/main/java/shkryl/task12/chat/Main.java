package shkryl.task12.chat;

import shkryl.task12.chat.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.startChat();
    }
}
