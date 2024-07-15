package test;

import java.io.IOException;

public class Interpreter {
    public void executeCommand(String input) {
        Parser parser = new Parser(input);
        try {
            parser.parse();
        } catch (IOException e) {
            System.err.println("Error parsing command: " + e.getMessage());
        }
    }
}
