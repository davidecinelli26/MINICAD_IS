package command;

import java.util.LinkedList;

public class HistoryCommandHandler implements CommandHandler {

    private int maxHistoryLength = 100;

    private final LinkedList<Command> history = new LinkedList<>();

    private final LinkedList<Command> redoList = new LinkedList<>();

    public HistoryCommandHandler() {
        this(100);
    }

    public HistoryCommandHandler(int maxHistoryLength) {
        if (maxHistoryLength < 0)
            throw new IllegalArgumentException();
        this.maxHistoryLength = maxHistoryLength;
    }

    @Override
    public void handle(Command command) {
        if (command.execute()) {
            addToHistory(command);
        } else {
            history.clear();
        }
        if (!redoList.isEmpty())
            redoList.clear();
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            Command redoCommand = redoList.removeFirst();
            redoCommand.execute();
            history.addFirst(redoCommand);
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command undoCommand = history.removeFirst();
            undoCommand.undo();
            redoList.addFirst(undoCommand);
        }
    }

    private void addToHistory(Command command) {
        history.addFirst(command);
        if (history.size() > maxHistoryLength) {
            history.removeLast();
        }
    }
}