/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.awt.Point;
import java.awt.Robot;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
interface MouseMove {

    void move() throws Exception;

    default void move(Point origin, Point target) throws Exception {
        double dx = (target.getX() - origin.getX()) / MouseUtils.MOVE_TIMES;
        double dy = (target.getY() - origin.getY()) / MouseUtils.MOVE_TIMES;
        double dt = 1;
        for (int step = 1; step < MouseUtils.MOVE_TIMES; step++) {
            Thread.sleep((int) dt);
            int x = ((int) (origin.getX() + dx * step));
            int y = ((int) (origin.getY() + dy * step));
            move(new Point(x, y));
        }
    }

    default void move(Point target) throws Exception {
        Robot robot = MouseRobot.getInstance();
        robot.mouseMove(target.x, target.y);
    }
}
