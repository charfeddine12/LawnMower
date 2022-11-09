package org.mow.it.now.model.lawn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mow.it.now.config.Constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @ParameterizedTest
    @ValueSource(strings = {"5 3"})
    @DisplayName("Test the rectangle creator")
    void should_create_a_rectangle(final String source) {
        // given
        final int expectedWidth = 5;
        final int expectedHeight = 3;
        final int[][] expectedGrid = new int[expectedWidth + 1][expectedHeight + 1];

        // when
        String[] dimensions = source.split(Constants.WHITE_SPACE_SEPARATOR);

        Rectangle rectangle = new Rectangle(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));

        // then
        assertEquals(expectedWidth, rectangle.getWidth());
        assertEquals(expectedHeight, rectangle.getHeight());
        assertArrayEquals(expectedGrid, rectangle.getGrid());

    }

    @ParameterizedTest
    @ValueSource(strings = {"5 0"})
    @DisplayName("Test the rectangle exception DimensionLawnException with a height 0")
    void should_throw_exception_when_creating_a_rectangle_with_height_zero(final String source) {
        // given
        final String expectedMessage = "Invalid dimension of lawn, width and height must have be greater than 0";

        // then
        String[] dimensions = source.split(Constants.WHITE_SPACE_SEPARATOR);

        assertThatThrownBy(() -> new Rectangle(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1])))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0 2"})
    @DisplayName("Test the rectangle exception DimensionLawnException with a width 0")
    void should_throw_exception_when_creating_create_a_rectangle_with_width_zero(final String source) {
        //given
        final String expectedMessage = "Invalid dimension of lawn, width and height must have be greater than 0";

        // then
        String[] dimensions = source.split(Constants.WHITE_SPACE_SEPARATOR);

        assertThatThrownBy(() -> new Rectangle(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1])))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}