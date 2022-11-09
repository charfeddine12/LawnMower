package org.mow.it.now.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mow.it.now.model.enumeration.CardinalDirection;
import org.mow.it.now.model.enumeration.Instruction;
import org.mow.it.now.model.mower.Mower;
import org.mow.it.now.service.impl.LawnServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LawnServiceTest {

    private final LawnServiceImpl lawnService = new LawnServiceImpl();


    @BeforeEach
    public void setUp() {
    }

    @Nested
    @DisplayName("Test the lawn service with passed tests")
    class TestFunctional {

        @ParameterizedTest
        @ValueSource(strings = {"inputInstruction.txt"})
        @DisplayName("Test the lawn service")
        void should_create_a_rectangle(final String fileName) {
            // given
            final Queue<Instruction> expectedInstruction1 = new LinkedList<>(Arrays.asList(Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A));
            final Queue<Instruction> expectedInstruction2 = new LinkedList<>(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A));

            List<Mower> expectedMower = Arrays
                    .asList(
                            new Mower(1, 3, CardinalDirection.N, expectedInstruction1),
                            new Mower(5, 1, CardinalDirection.E, expectedInstruction2)
                    );
            List<Mower> mowers = lawnService.mow(fileName);

            // then
            assertThat(expectedMower)
                    .usingRecursiveComparison()
                    .ignoringFields("ref")
                    .isEqualTo(mowers);
        }
    }


    @Nested
    @DisplayName("Test the mower creator exceptions")
    class TestExceptions {

        @ParameterizedTest
        @ValueSource(strings = {"emptyFile.txt"})
        @DisplayName("Test the lawn service exception FileIncompleteException with empty file")
        void should_throw_exception_when_input_file_is_empty(final String fileName) {
            //given
            // then
            assertThatThrownBy(() -> lawnService.mow(fileName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"test.txt"})
        @DisplayName("Test the lawn service exception IOException with not found input file")
        void should_throw_exception_when_input_file_not_found(final String fileName) {
            //given
            // then
            assertThatThrownBy(() -> lawnService.mow(fileName))
                    .isInstanceOf(IOException.class);
        }

    }

}