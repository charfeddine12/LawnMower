package org.mow.it.now.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mow.it.now.config.Constants;
import org.mow.it.now.model.enumeration.CardinalDirection;
import org.mow.it.now.model.enumeration.Instruction;
import org.mow.it.now.model.lawn.Rectangle;
import org.mow.it.now.model.mower.Mower;
import org.mow.it.now.service.impl.MowerCreatorImpl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MowerCreatorImplTest {

    MowerCreatorImpl mowerCreator = new MowerCreatorImpl(new Rectangle(5, 5));

    @Nested
    @DisplayName("Test the mower creator with passed tests")
    class TestFunctional {
        @ParameterizedTest
        @ValueSource(strings = "1 2 N,GAGAGAGAA")
        @DisplayName("Test the mower creator with source [1 2 N,GAGAGAGAA]")
        void should_create_a_first_mower(final String input) {
            // given
            String[] source = input.split("\\s*,\\s*");
            final int expectedX = 1;
            final int expectedY = 3;
            final CardinalDirection expectedDirection = CardinalDirection.N;
            final Queue<Instruction> expectedInstruction = new LinkedList<>(Arrays.asList(Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A));

            // when
            Mower mower = mowerCreator.createMower(source);

            // then
            assertEquals(mowerCreator.getRectangle().getGrid()[expectedX][expectedY], mower.getRef());
            assertEquals(expectedX, mower.getPositionX());
            assertEquals(expectedY, mower.getPositionY());
            assertEquals(expectedDirection, mower.getDirection());
            assertEquals(expectedInstruction, mower.getInstructionSequence());
        }

        @ParameterizedTest
        @ValueSource(strings = "3 3 E,AADAADADDA")
        @DisplayName("Test the mower creator with source [3 3 E,AADAADADDA]")
        void should_create_a_second_mower(final String input) {
            // given
            String[] source = input.split("\\s*,\\s*");
            final int expectedX = 5;
            final int expectedY = 1;
            final CardinalDirection expectedDirection = CardinalDirection.E;
            final Queue<Instruction> expectedInstruction = new LinkedList<>(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A));

            // when
            Mower mower = mowerCreator.createMower(source);

            // then
            assertEquals(mowerCreator.getRectangle().getGrid()[expectedX][expectedY], mower.getRef());
            assertEquals(expectedX, mower.getPositionX());
            assertEquals(expectedY, mower.getPositionY());
            assertEquals(expectedDirection, mower.getDirection());
            assertEquals(expectedInstruction, mower.getInstructionSequence());
        }

        @ParameterizedTest
        @ValueSource(strings = "5 1 E, AADAADADDA")
        @DisplayName("Test the mower creator with a cardinality that occupied [5 1 E, AADAADADDA]")
        void should_not_place_a_mower_in_a_occupied_grid(final String input) {
            // given
            String[] source = input.split("\\s*,\\s*");
            final int expectedX = 5;
            final int expectedY = 1;
            final CardinalDirection expectedDirection = CardinalDirection.E;
            final Queue<Instruction> expectedInstruction = new LinkedList<>(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A));
            mowerCreator.getRectangle().getGrid()[expectedX][expectedY] = 100;
            // when
            Mower mower = mowerCreator.createMower(source);

            // then
            assertNotEquals(mowerCreator.getRectangle().getGrid()[expectedX][expectedY], mower.getRef());
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
        @ValueSource(strings = {"5 5 H, AGADA"})
        @DisplayName("Test the mower creator exception MowerCreatorException with a direction illegal H")
        void should_throw_exception_when_creating_a_mower_with_direction_h(final String input) {
            // given
            String[] sources = input.split("\\s*,\\s*");
            final String expectedMessage = "Mower info parse error: expected X Y Direction {N, S, W, E}, actual " + sources[0];

            // then
            assertThatThrownBy(() -> mowerCreator.createMower(sources))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(expectedMessage);
        }

        @ParameterizedTest
        @ValueSource(strings = {"6 6 E, AADAADADDA"})
        @DisplayName("Test the mower creator exception MowerCreatorException with a cardinality out of bounds")
        void should_throw_exception_when_creating_a_mower_out_of_bounds(final String input) {
            //given
            String[] source = input.split("\\s*,\\s*");
            final String expectedMessage = "Mower out of bounds of the lawn, the mower cardinality must be less than "
                    + mowerCreator.getRectangle().getWidth()
                    + ","
                    + mowerCreator.getRectangle().getHeight();

            // then
            assertThatThrownBy(() -> mowerCreator.createMower(source)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(expectedMessage);
        }
    }
}