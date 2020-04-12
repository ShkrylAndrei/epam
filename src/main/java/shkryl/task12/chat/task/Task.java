package shkryl.task12.chat.task;

import shkryl.task12.chat.chat.Chat;

import java.util.concurrent.Callable;

public abstract class Task implements Callable<String> {
    protected Chat chat;

    public Task(Chat chat) {
        this.chat = chat;
    }
}
