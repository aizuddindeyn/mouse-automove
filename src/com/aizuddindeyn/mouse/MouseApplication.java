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
            MousePrompt.getInstance().shutdown();
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
                boolean started = MouseInstance.getInstance().isStarted();
                String status = (started) ? "started" : "paused";
                String action = (started) ? "pause" : "resume";
                String message =
                        MessageFormat.format("App {0}. Press ''p'' and ''Enter'' to {1} (''e'' to exit): ",
                                status, action);
                boolean valid = MousePrompt.getInstance().prompt(message);
                if (valid) {
                    startStop(started);
                }

            } catch (Exception ex) {
                MouseUtils.logErr(ex.getMessage());
            }
        }
    }

    private static void startStop(boolean started) {
        if (started) {
            MouseInstance.getInstance().stop();
        } else {
            MouseInstance.getInstance().start();
        }
    }
}
