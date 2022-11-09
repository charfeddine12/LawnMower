package org.mow.it.now.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mow.it.now.config.Constants;
import org.mow.it.now.model.enumeration.CardinalDirection;
import org.mow.it.now.model.enumeration.Instruction;
import org.mow.it.now.model.mower.Mower;
import org.mow.it.now.service.impl.MowerConverterImpl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerConverterTest {


    MowerConverter mowerConverter = new MowerConverterImpl();


    @Nested
    @DisplayName("Test the mower creator with passed tests")
    class TestFunctional {

        @ParameterizedTest
        @ValueSource(strings = {"1 2 N, GAGAGAGAA"})
        @DisplayName("Test the mower creator with source [1 2 N,GAGAGAGAA]")
        void should_create_a_first_mower(final String input) {
            // given
            String[] sources = input.split("\\s*,\\s*");
            final String[] initializers = sources[0].split(Constants.WHITE_SPACE_SEPARATOR);
            final String instructions = sources[1];
            final int expectedX = 1;
            final int expectedY = 2;
            final CardinalDirection expectedDirection = CardinalDirection.N;
            final Queue<Instruction> expectedInstruction = new LinkedList<>(Arrays.asList(Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A));

            // when
            Mower mower = mowerConverter.convert(initializers, instructions);

            // then
            assertEquals(expectedX, mower.getPositionX());
            assertEquals(expectedY, mower.getPositionY());
            assertEquals(expectedDirection, mower.getDirection());
            assertEquals(expectedInstruction, mower.getInstructionSequence());
        }

        @ParameterizedTest
        @ValueSource(strings = {"3 3 E, AADAADADDA"})
        @DisplayName("Test the mower creator with source [3 3 E,AADAADADDA]")
        void should_create_a_second_mower(final String input) {
            // given
            String[] sources = input.split("\\s*,\\s*");
            final String[] initializers = sources[0].split(Constants.WHITE_SPACE_SEPARATOR);
            final String instructions = sources[1];
            final int expectedX = 3;
            final int expectedY = 3;
            final CardinalDirection expectedDirection = CardinalDirection.E;
            final Queue<Instruction> expectedInstruction = new LinkedList<>(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A));

            // when
            Mower mower = mowerConverter.convert(initializers, instructions);

            // then
            assertEquals(expectedX, mower.getPositionX());
            assertEquals(expectedY, mower.getPositionY());
            assertEquals(expectedDirection, mower.getDirection());
            assertEquals(expectedInstruction, mower.getInstructionSequence());
        }
    }

    @Nested
    @DisplayName("Test the mower creator exceptions")
    class TestExceptions {
        
        @ParameterizedTest
        @ValueSource(strings = {"5 5 N, TEST"})
        @DisplayName("Test the mower creator exception MowerCreatorException with a illegal instructions")
        void should_throw_exception_when_creating_a_mower_with_width_zero(final String input) {
            //given
            String[] sources = input.split("\\s*,\\s*");
            final String[] initializers = sources[0].split(Constants.WHITE_SPACE_SEPARATOR);
            final String instructions = sources[1];
            final String expectedMessage = "Mower instructions info parse error: expected D, G, A, actual ";

            // then
            assertThatThrownBy(() -> mowerConverter.convert(initializers, instructions))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(expectedMessage);
        }
    }
}