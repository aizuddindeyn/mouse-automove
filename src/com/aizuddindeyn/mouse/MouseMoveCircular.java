/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.Dimension;
import java.awt.Point;

import static com.aizuddindeyn.mouse.MouseUtils.CIRCLE_ROUND_MAX;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
class MouseMoveCircular implements MouseMove {

    @Override
    public void move() throws Exception {
        Point original = MouseUtils.getMouseLocation();
        Dimension screen = MouseUtils.getScreenResolution();

        // Calculating best radius based on screen size
        int radiusOnHeight = screen.height / 3;
        int radiusOnWidth = screen.width / 3;
        int radius = Math.min(radiusOnHeight, radiusOnWidth);

        int round = MouseRandom.getSecureRandom().nextInt(CIRCLE_ROUND_MAX) + 1;

        int midX = (screen.width / 2) + 1;
        int midY = (screen.height / 2) + 1;
        Point center = new Point(midX, midY);

        move(original, center);

        Dimension firstPoint = calculateCircle(0, radius);
        move(center, new Point(center.x + firstPoint.width, center.y + firstPoint.height));

        for (int i = 1; i <= 360 * round; i++) {
            Thread.sleep(10);
            Dimension d = calculateCircle(i, radius);
            move(new Point(center.x + d.width, center.y + d.height));
        }

        move(MouseUtils.getMouseLocation(), center);
        move(center, original);
    }

    Dimension calculateCircle(int degree, int radius) {
        double rad = Math.toRadians(degree);
        double x = radius * (Math.cos(rad));
        double y = radius * (Math.sin(rad));

        return new Dimension((int) x, (int) y);
    }
}
