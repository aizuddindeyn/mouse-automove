/*
 * Owned by aizuddindeyn
 * Visit https://gitlab.com/group-bear/mouse-automation
 */
package com.aizuddindeyn.mouse;

import java.security.SecureRandom;

/**
 * @author aizuddindeyn
 * @date 11/7/2020
 */
public class MouseRandom {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private MouseRandom() {
        // Singleton
    }

    public static SecureRandom getSecureRandom() {
        return SECURE_RANDOM;
    }
}
