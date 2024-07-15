package test;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Inserisci i comandi (digitare 'exit' per uscire):");

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            interpreter.executeCommand(input);
        }

        scanner.close();
    }
}
