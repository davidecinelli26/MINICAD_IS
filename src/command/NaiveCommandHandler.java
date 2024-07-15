package command;

public class NaiveCommandHandler implements CommandHandler {

    @Override
    public void handle(Command command) {
        command.execute();
    }
}
