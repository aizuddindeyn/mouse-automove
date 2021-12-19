/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.util.Timer;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
class MouseInstance {

    private static final MouseInstance INSTANCE = new MouseInstance();

    private Timer timer;

    private boolean started = false;

    private MouseInstance() {
        // Singleton
    }

    static MouseInstance getInstance() {
        return INSTANCE;
    }

    synchronized void start() {
        timer = new Timer();
        MouseUtils.log("Timer started");

        started = true;
        timer.schedule(new MouseTask(timer, INSTANCE), 1500L);
    }

    synchronized void stop() {
        timer.cancel();
        started = false;
        MouseUtils.log("Timer stopped");
    }

    void execute() {
        try {
            int index = MouseRandom.getSecureRandom().nextInt(MouseMoveEnum.getEnumMap().size());
            MouseMoveEnum enums = MouseMoveEnum.values()[index];
            MouseMoveEnum.getEnumMap().get(enums).move();

        } catch (Exception ex) {
            MouseUtils.logErr(ex.getMessage());
        }
    }

    synchronized boolean isStarted() {
        return started;
    }
}
