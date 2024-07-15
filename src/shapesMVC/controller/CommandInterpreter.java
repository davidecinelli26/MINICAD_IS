package shapesMVC.controller;

import command.Command;
import command.CommandHandler;
import command.HistoryCommandHandler;
import shapesMVC.view.GraphicObjectPanel;

public class CommandInterpreter {
    private CommandHandler commandHandler;
    private HistoryCommandHandler historyHandler;
    private GraphicObjectPanel panel;

    public CommandInterpreter(CommandHandler handler, GraphicObjectPanel panel) {
        this.commandHandler = handler;
        this.historyHandler = new HistoryCommandHandler();
        this.panel = panel;
    }

    public void executeCommand(String input) {
        System.out.println(input);
        CommandParser parser = new CommandParser(panel);
        Command command = parser.parse(input);
        commandHandler.handle(command);
    }

    public void undo() {
        historyHandler.undo();
    }

    public void redo() {
        historyHandler.redo();
    }
}
