package shapesMVC.controller;

import command.Command;
import command.CommandHandler;
import command.HistoryCommandHandler;

public class CommandInterpreter {
    private CommandHandler commandHandler;
    private HistoryCommandHandler historyHandler;

    public CommandInterpreter(CommandHandler handler) {
        this.commandHandler = handler;
        this.historyHandler = new HistoryCommandHandler();
    }

    public void executeCommand(String input) {
        CommandParser parser = new CommandParser();
        Command command = parser.parse(input);
        historyHandler.handle(command);
    }

    public void undo() {
        historyHandler.undo();
    }

    public void redo() {
        historyHandler.redo();
    }
}
