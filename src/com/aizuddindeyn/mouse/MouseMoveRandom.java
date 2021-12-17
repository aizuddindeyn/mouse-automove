/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.Dimension;
import java.awt.Point;

import static com.aizuddindeyn.mouse.MouseUtils.RANDOM_STEP_MAX;
import static com.aizuddindeyn.mouse.MouseUtils.RANDOM_STEP_MIN;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MouseMoveRandom implements MouseMove {

    @Override
    public void move() throws Exception {
        Point p = MouseUtils.getMouseLocation();

        Dimension screen = MouseUtils.getScreenResolution();

        int step = RANDOM_STEP_MIN +
                (MouseRandom.getSecureRandom().nextInt(RANDOM_STEP_MAX - RANDOM_STEP_MIN) + 1);

        int x = p.x;
        int y = p.y;
        for (int times = 1; times <= step; times++) {
            int x2, y2;
            do {
                x2 = MouseRandom.getSecureRandom().nextInt(screen.width);
                y2 = MouseRandom.getSecureRandom().nextInt(screen.height);
            } while (x2 == x && y2 == y);

            moveMouse(new Point(x, y), new Point(x2, y2));
            x = x2;
            y = y2;
        }
    }
}
