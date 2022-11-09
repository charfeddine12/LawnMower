package org.mow.it.now.model.mower;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mow.it.now.config.Constants;
import org.mow.it.now.model.enumeration.CardinalDirection;
import org.mow.it.now.model.enumeration.Instruction;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MowerTest {

    @ParameterizedTest
    @ValueSource(strings = "1 2 N,GAGA")
    @DisplayName("Test the mower creator with source [1 2 N,GAGA]")
    void should_create_a_first_mower(final String input) {
        // given
        String[] source = input.split("\\s*,\\s*");
        final int expectedX = 1;
        final int expectedY = 2;
        final CardinalDirection expectedDirection = CardinalDirection.N;
        final Queue<Instruction> expectedInstruction = new LinkedList<>(Arrays.asList(
                Instruction.G,
                Instruction.A,
                Instruction.G,
                Instruction.A)
        );

        // when
        String[] mowerCharacteristic = source[0].split(Constants.WHITE_SPACE_SEPARATOR);
        Mower mower = new Mower(
                Integer.parseInt(mowerCharacteristic[0]),
                Integer.parseInt(mowerCharacteristic[1]),
                CardinalDirection.valueOf(mowerCharacteristic[2]),
                new LinkedList<>(Arrays.asList(Instruction.G, Instruction.A, Instruction.G, Instruction.A))
        );

        // then
        assertTrue(mower.getRef() > 0 && mower.getRef() < 1202);
        assertEquals(expectedX, mower.getPositionX());
        assertEquals(expectedY, mower.getPositionY());
        assertEquals(expectedDirection, mower.getDirection());
        assertEquals(expectedInstruction, mower.getInstructionSequence());
    }
}