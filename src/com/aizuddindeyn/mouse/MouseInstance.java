/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
class MouseInstance {

    private static final MouseInstance INSTANCE = new MouseInstance();

    private static final Map<Integer, MouseMove> MOVE_MAP = new HashMap<>();

    private Timer timer;

    private boolean started = false;

    static {
        MOVE_MAP.put(1, new MouseMoveRandom());
        MOVE_MAP.put(2, new MouseMoveEdge());
    }

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
            int type = MouseRandom.getSecureRandom().nextInt(MOVE_MAP.size()) + 1;
            MouseMove move = MOVE_MAP.get(type);
            if (move != null) {
                move.move();
            }

        } catch (Exception ex) {
            MouseUtils.logErr(ex.getMessage());
        }
    }

    synchronized boolean isStarted() {
        return started;
    }
}
