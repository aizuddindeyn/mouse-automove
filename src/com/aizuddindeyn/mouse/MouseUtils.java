/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MouseUtils {

    public static final int DELAY_TIMES_MIN = 15;

    public static final int DELAY_TIMES_MAX = 60;

    public static final int MOVE_TIMES = 1000;

    public static final int EDGE_PIXEL = 100;

    public static final int RANDOM_STEP_MIN = 3;

    public static final int RANDOM_STEP_MAX = 10;

    public static final int EDGE_ROUND_MAX = 3;

    static final long EXECUTOR_DELAY = 100L;

    private MouseUtils() {
        // Utils class
    }

    public static Dimension getScreenResolution() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        return new Dimension(width, height);
    }

    public static Point getMouseLocation() {
        return MouseInfo.getPointerInfo().getLocation();
    }


    public static int generateIntervalSeconds(int minimum, int maximum) {
        return minimum + MouseRandom.getSecureRandom().nextInt(maximum + 1);
    }

    public static void log(String message) {
        System.out.println();
        System.out.println(message);
    }

    public static void logErr(String err) {
        System.err.println();
        System.err.println(err);
    }
}
