package org.mow.it.now.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mow.it.now.model.lawn.Rectangle;
import org.mow.it.now.service.impl.RectangleConverterImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleConverterTest {

    RectangleConverter rectangleConverter = new RectangleConverterImpl();

    @Nested
    @DisplayName("Test the rectangle creator with passed tests")
    class TestFunctional {

        @ParameterizedTest
        @ValueSource(strings = {"5 3"})
        @DisplayName("Test the rectangle creator")
        void should_create_a_rectangle(final String source) {
            // given
            final int expectedWidth = 5;
            final int expectedHeight = 3;
            final int[][] expectedGrid = new int[expectedWidth + 1][expectedHeight + 1];

            // when
            Rectangle rectangle = rectangleConverter.convert(source);

            // then
            assertEquals(expectedWidth, rectangle.getWidth());
            assertEquals(expectedHeight, rectangle.getHeight());
            assertArrayEquals(expectedGrid, rectangle.getGrid());

        }
    }

    @Nested
    @DisplayName("Test the rectangle creator exceptions")
    class TestExceptions {

        @ParameterizedTest
        @ValueSource(strings = {"5 0"})
        @DisplayName("Test the rectangle creator exception DimensionLawnException with a height 0")
        void should_throw_exception_when_creating_a_rectangle_with_height_zero(final String source) {
            // given
            final String expectedMessage = "Invalid dimension of lawn, width and height must have be greater than 0";

            // then
            assertThatThrownBy(() -> rectangleConverter.convert(source)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(expectedMessage);
        }

        @ParameterizedTest
        @ValueSource(strings = {"0 2"})
        @DisplayName("Test the rectangle creator exception DimensionLawnException with a width 0")
        void should_throw_exception_when_creating_create_a_rectangle_with_width_zero(final String source) {
            //given
            final String expectedMessage = "Invalid dimension of lawn, width and height must have be greater than 0";

            // then
            assertThatThrownBy(() -> rectangleConverter.convert(source)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(expectedMessage);
        }
    }

}