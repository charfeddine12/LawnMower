package org.mow.it.now.model.enumeration;

import lombok.AllArgsConstructor;

/**
 * Possible mower directions (N,E,W,S)
 *
 * @author BENMOHAMED Charfeddine
 * @name CardinalDirection
 * @date 03/11/2022
 */

@AllArgsConstructor
public enum CardinalDirection {

    N("N") {
        public CardinalDirection rotateToLeft() {
            return W;
        }
        public CardinalDirection rotateToRight() {return E;}
    }, E("E") {
        public CardinalDirection rotateToLeft() {
            return N;
        }
        public CardinalDirection rotateToRight() {
            return S;
        }
    }, W("W") {
        public CardinalDirection rotateToLeft() {
            return S;
        }
        public CardinalDirection rotateToRight() {
            return N;
        }
    }, S("S") {
        public CardinalDirection rotateToLeft() {
            return E;
        }
        public CardinalDirection rotateToRight() {
            return W;
        }
    };

    private final String direction;


    /**
     * Rotate mower by 90 degrees to left
     */
    public abstract CardinalDirection rotateToLeft();

    /**
     * Rotate mower by 90 degrees to right
     */
    public abstract CardinalDirection rotateToRight();

}
