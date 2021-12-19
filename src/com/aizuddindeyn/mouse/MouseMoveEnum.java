/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public enum MouseMoveEnum {

    RANDOM(new MouseMoveRandom()),

    EDGE(new MouseMoveEdge()),

    CIRCLE(new MouseMoveCircular()),
    ;

    private static final Map<MouseMoveEnum, MouseMove> ENUM_MAP = new EnumMap<>(MouseMoveEnum.class);

    private final MouseMove move;

    static {
        for (MouseMoveEnum e : MouseMoveEnum.values()) {
            ENUM_MAP.put(e, e.getMove());
        }
    }

    MouseMoveEnum(MouseMove move) {
        this.move = move;
    }

    MouseMove getMove() {
        return move;
    }

    static Map<MouseMoveEnum, MouseMove> getEnumMap() {
        return ENUM_MAP;
    }
}
