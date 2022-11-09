package org.mow.it.now.model.enumeration;

import lombok.AllArgsConstructor;

/**
 * Possible mower moves (G, D, A)
 *
 * @author BENMOHAMED Charfeddine
 * @name Move
 * @date 03/11/2022
 */

@AllArgsConstructor
public enum Instruction {
    G("G"), D("D"), A("A");

    private final String action;
}
