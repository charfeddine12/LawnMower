package org.mow.it.now.model.mower;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.mow.it.now.model.enumeration.CardinalDirection;
import org.mow.it.now.model.enumeration.Instruction;

import java.util.Queue;
import java.util.Random;

/**
 * @author BENMOHAMED Charfeddine
 * @name Mower
 * @date 03/11/2022
 */
public class Mower {

    /**
     * The x coordinate of the mower
     */
    @Getter
    @Setter
    private int positionX;
    /**
     * The y coordinate of the mower
     */
    @Getter
    @Setter
    private int positionY;
    /**
     * The direction of the mower
     */
    @Getter
    @Setter
    private CardinalDirection direction;
    /**
     * The id of the mower
     */
    @Getter
    private final int ref;
    /**
     * The Instruction sequence
     */
    @Getter

    @NonNull
    private Queue<Instruction> instructionSequence;

    public Mower(int positionX, int positionY, CardinalDirection direction, Queue<Instruction> instructionSequence) {
        this.ref = new Random().nextInt(1200) + 1;
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.instructionSequence = instructionSequence;
    }

    @Override
    public String toString() {
        return "Mower "
                + "ref= " + ref
                + " positionX= " + positionX
                + " positionY= " + positionY
                + " direction= " + direction ;

    }

}
