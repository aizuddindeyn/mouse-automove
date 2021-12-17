/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static com.aizuddindeyn.mouse.MouseUtils.EDGE_PIXEL;
import static com.aizuddindeyn.mouse.MouseUtils.EDGE_ROUND_MAX;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
class MouseMoveEdge implements MouseMove {

    @Override
    public void move() throws Exception {
        Point p = MouseUtils.getMouseLocation();

        Dimension screen = MouseUtils.getScreenResolution();

        int round = MouseRandom.getSecureRandom().nextInt(EDGE_ROUND_MAX) + 1;
        MouseUtils.log("Round: " + round);

        List<Point> targets = new ArrayList<>();
        for (int i = 1; i <= round; i++) {
            targets.add(new Point(EDGE_PIXEL, EDGE_PIXEL));
            targets.add(new Point(screen.width - EDGE_PIXEL, EDGE_PIXEL));
            targets.add(new Point(screen.width - EDGE_PIXEL, screen.height - EDGE_PIXEL));
            targets.add(new Point(EDGE_PIXEL, screen.height - EDGE_PIXEL));
        }
        targets.add(new Point(EDGE_PIXEL, EDGE_PIXEL));
        targets.add(p);

        Point current = p;
        for (Point target : targets) {
            moveMouse(current, target);
            current = target;
        }
    }
}
