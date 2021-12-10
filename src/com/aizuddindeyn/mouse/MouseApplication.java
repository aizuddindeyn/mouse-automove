/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MouseApplication {

    public static void main(String[] args) {
        MouseUtils.log("Starting application");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MouseInstance.getInstance().stop();
            MouseUtils.log("Stopping application");
        }));

        MouseInstance.getInstance().start();

        while (true) {
            try {
                int key = System.in.read();
                // Type 'p' to pause or resume
                if (key == 112) {
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
