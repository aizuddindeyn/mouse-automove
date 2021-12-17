/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.io.Console;
import java.util.Scanner;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MousePrompt {

    private static final Console CONSOLE = System.console();

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final MousePrompt INSTANCE = new MousePrompt();

    private MousePrompt() {
        // Singleton
    }

    static Console getConsole() {
        return CONSOLE;
    }

    static Scanner getScanner() {
        return SCANNER;
    }

    static MousePrompt getInstance() {
        return INSTANCE;
    }

    public boolean prompt(String message) {
        MouseUtils.log("");
        String input = readInput(message);

        return isValidInput(input);
    }

    private String readInput(String message) {
        String input;
        if (CONSOLE != null) {
            input = CONSOLE.readLine(message);
            MouseUtils.log("");
        } else {
            MouseUtils.log(message);
            input = SCANNER.next();
        }

        return input;
    }

    private boolean isValidInput(String input) {
        return isNonEmptyInput(input) && matchInput(input);
    }

    private boolean isNonEmptyInput(String input) {
        return input != null && !input.isEmpty();
    }

    private boolean matchInput(String input) {
        boolean result = false;

        if (input.matches("[p]")) {
            result = true;
        } else if (input.matches("[e]")) {
            Runtime.getRuntime().exit(0);
        }

        return result;
    }
}
