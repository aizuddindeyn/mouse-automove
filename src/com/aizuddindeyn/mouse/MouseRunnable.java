/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.text.MessageFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
class MouseRunnable implements Runnable {

    private final ScheduledExecutorService executor;

    MouseRunnable(ScheduledExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public void run() {
        boolean started = MouseInstance.getInstance().isStarted();
        String status = (started) ? "started" : "paused";
        String action = (started) ? "pause" : "resume";
        String message =
                MessageFormat.format("App {0}. Press ''p'' and ''Enter'' to {1} (''e'' to exit): ",
                        status, action);
        boolean valid = MousePrompt.getInstance().prompt(message);
        if (valid) {
            MouseApplication.startStop(started);
        }

        executor.schedule(new MouseRunnable(executor), MouseUtils.EXECUTOR_DELAY, TimeUnit.MILLISECONDS);
    }
}
