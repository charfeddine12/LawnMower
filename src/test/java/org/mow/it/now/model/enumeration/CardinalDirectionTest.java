package org.mow.it.now.model.enumeration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardinalDirectionTest {

    private static Stream<Arguments> parametersForRotateLeftTest() {
        return Stream.of(
                Arguments.of(CardinalDirection.N, CardinalDirection.W),
                Arguments.of(CardinalDirection.W, CardinalDirection.S),
                Arguments.of(CardinalDirection.S, CardinalDirection.E),
                Arguments.of(CardinalDirection.E, CardinalDirection.N)
        );
    }

    private static Stream<Arguments> parametersForRotateRightTest() {
        return Stream.of(
                Arguments.of(CardinalDirection.N, CardinalDirection.E),
                Arguments.of(CardinalDirection.E, CardinalDirection.S),
                Arguments.of(CardinalDirection.S, CardinalDirection.W),
                Arguments.of(CardinalDirection.W, CardinalDirection.N)
        );
    }

    @ParameterizedTest
    @MethodSource("parametersForRotateRightTest")
    @DisplayName("Test the right rotate method of the cardinal direction")
    void rotateToRight(final CardinalDirection actual, final CardinalDirection expected) {
        assertEquals(actual.rotateToRight(), expected);
    }

    @ParameterizedTest
    @MethodSource("parametersForRotateLeftTest")
    @DisplayName("Test the left rotate method of the cardinal direction")
    void rotateToLeft(final CardinalDirection actual, final CardinalDirection expected) {
        assertEquals(actual.rotateToLeft(), expected);
    }
}