package com.ss.ch.domain;

/**
 * Created by Serhii Starovoit on 2/28/2017  in  6:38 PM .
 */
public enum StarRating {
    NO_STARS(0), ONE_STARS(1), TWO_STARS(2), THREE_STARS(3), FOUR_STARS(4), FIVE_STARS(5);

    private int description;

    private StarRating(int description) {
        this.description = description;
    }
    public int getDescription() {
        return description;
    }

}