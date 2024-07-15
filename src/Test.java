import command.CommandHandler;
import command.NaiveCommandHandler;
import shapesMVC.controller.CommandInterpreter;
import shapesMVC.model.CircleObject;
import shapesMVC.model.ImageObject;
import shapesMVC.model.RectangleObject;
import shapesMVC.view.*;

import javax.swing.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Progetto IS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);

        GraphicObjectPanel panel = GraphicObjectPanel.getInstance();
        frame.add(panel);
        CommandHandler commandHandler = new NaiveCommandHandler();
        CommandInterpreter interpreter = new CommandInterpreter(commandHandler, panel);

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Inserisci i comandi (digitare 'exit' per uscire):");
        GraphicObjectViewFactory.FACTORY.installView(CircleObject.class, new CircleObjectView());
        GraphicObjectViewFactory.FACTORY.installView(RectangleObject.class, new RectangleObjectView());
        GraphicObjectViewFactory.FACTORY.installView(ImageObject.class, new ImageObjectView());
        frame.setVisible(true);

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.equalsIgnoreCase("undo")) {
                interpreter.undo();
                continue;
            }

            if (input.equalsIgnoreCase("redo")) {
                interpreter.redo();
                continue;
            }

            interpreter.executeCommand(input);
        }

        scanner.close();
    }
}
