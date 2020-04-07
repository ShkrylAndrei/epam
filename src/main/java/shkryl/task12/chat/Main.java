package shkryl.task12.chat;

import shkryl.task12.chat.service.Service;


public class Main {
    //Количество Writer
    private static final int countWriter = 5;
    //Количество Reader
    private static final int countReader = 5;
    //Количество Updater
    private static final int countUpdater = 3;


    public static void main(String[] args) {
        Service service = new Service();
        service.startChat();



    }
}
