package shkryl.task12.chat.task;

import shkryl.task12.chat.chat.Chat;

public class ReaderTask extends Task {

    public ReaderTask(Chat chat) {
        super(chat);
    }

    @Override
    public String call() throws Exception {
        return chat.readSms();
    }
}
