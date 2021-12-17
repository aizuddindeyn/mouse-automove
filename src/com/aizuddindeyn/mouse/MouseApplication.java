/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.AWTException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MouseApplication {

    private static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        MouseUtils.log("Starting application");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MouseInstance.getInstance().stop();
            MousePrompt.getScanner().close();
            EXECUTOR.shutdown();
            MouseUtils.log("Stopping application");
        }));

        try {
            MouseRobot.init();
        } catch (AWTException ex) {
            MouseUtils.logErr("Failed to initialize robot: " + ex.getMessage());
            Runtime.getRuntime().exit(1);
        }

        MouseInstance.getInstance().start();

        EXECUTOR.schedule(new MouseRunnable(EXECUTOR), MouseUtils.EXECUTOR_DELAY, TimeUnit.MILLISECONDS);
    }

    static void startStop(boolean started) {
        if (started) {
            MouseInstance.getInstance().stop();
        } else {
            MouseInstance.getInstance().start();
        }
    }
}
