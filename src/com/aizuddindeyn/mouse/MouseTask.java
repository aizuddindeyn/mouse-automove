/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.util.Timer;
import java.util.TimerTask;

import static com.aizuddindeyn.mouse.MouseUtils.DELAY_TIMES_MAX;
import static com.aizuddindeyn.mouse.MouseUtils.DELAY_TIMES_MIN;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MouseTask extends TimerTask {

    private final Timer timer;

    private final MouseInstance instance;

    public MouseTask(Timer timer, MouseInstance instance) {
        this.timer = timer;
        this.instance = instance;
    }

    @Override
    public void run() {
        instance.execute();
        setup();
    }

    private void setup() {
        int seconds = MouseUtils.generateIntervalSeconds(DELAY_TIMES_MIN, (DELAY_TIMES_MAX - DELAY_TIMES_MIN));
        MouseUtils.log("Next interval: " + seconds + "s");
        timer.schedule(new MouseTask(timer, instance), seconds * 1000L);
    }
}
