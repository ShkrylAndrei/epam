package shkryl.task5.handler;

import shkryl.task5.util.CommandArgs;
import shkryl.task5.util.ParseCommand;

public class Delete implements HandlerCommand {
    @Override
    public String handler(String command) {
        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca  = parseCommand.parsePrintDeleteCommand(command);
        return null;
    }
}
