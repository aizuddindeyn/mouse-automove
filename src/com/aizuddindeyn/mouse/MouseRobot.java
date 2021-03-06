/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
class MouseRobot {

    private static volatile Robot instance;

    static void init() throws AWTException {
        if (instance == null) {
            synchronized (MouseRobot.class) {
                if (instance == null) {
                    instance = new Robot();
                }
            }
        }
    }

    static Robot getInstance() throws AWTException {
        init();
        return instance;
    }
}
