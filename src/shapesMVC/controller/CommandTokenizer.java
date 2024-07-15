package shapesMVC.controller;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class CommandTokenizer {
    private StreamTokenizer tokenizer;

    public CommandTokenizer(String input) {
        tokenizer = new StreamTokenizer(new StringReader(input));
        tokenizer.quoteChar('"');
        tokenizer.ordinaryChar('/');
        tokenizer.wordChars('_', '_');
    }

    public int nextToken() throws IOException {
        return tokenizer.nextToken();
    }

    public String getString() {
        return tokenizer.sval;
    }

    public double getNumber() {
        return tokenizer.nval;
    }

    public int getTokenType() {
        return tokenizer.ttype;
    }
}
