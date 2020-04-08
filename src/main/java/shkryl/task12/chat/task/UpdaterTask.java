package shkryl.task12.chat.task;

import shkryl.task12.chat.chat.Chat;

public class UpdaterTask extends Task {

    public UpdaterTask(Chat chat) {
        super(chat);
    }

    @Override
    public String call() throws Exception {
        return chat.updateSms();
    }
}
