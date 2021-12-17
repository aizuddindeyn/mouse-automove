/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.AWTException;
import java.text.MessageFormat;
import java.util.Scanner;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MouseApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        MouseUtils.log("Starting application");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MouseInstance.getInstance().stop();
            SCANNER.close();
            MouseUtils.log("Stopping application");
        }));

        try {
            MouseRobot.init();
        } catch (AWTException ex) {
            MouseUtils.logErr("Failed to initialize robot: " + ex.getMessage());
            Runtime.getRuntime().exit(1);
        }

        MouseInstance.getInstance().start();

        while (true) {
            try {
                String status = (MouseInstance.getInstance().isStarted()) ? "started" : "paused";
                String action = (MouseInstance.getInstance().isStarted()) ? "pause" : "resume";
                System.out.println();
                System.out.print(MessageFormat.format("App {0}. Press 'p' and Enter to {1}: ", status, action));
                String input = SCANNER.next();
                // Type 'p' to pause or resume
                if ((input != null && !input.isEmpty()) && 'p' == input.charAt(0)) {
                    if (MouseInstance.getInstance().isStarted()) {
                        MouseInstance.getInstance().stop();
                    } else {
                        MouseInstance.getInstance().start();
                    }
                }

            } catch (Exception ex) {
                MouseUtils.logErr(ex.getMessage());
            }
        }
    }
}
