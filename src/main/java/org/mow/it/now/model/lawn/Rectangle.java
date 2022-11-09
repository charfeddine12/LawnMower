package org.mow.it.now.model.lawn;

import com.google.common.base.Preconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.mow.it.now.exceptions.DimensionLawnException;

/**
 * The Rectangle Model Object extends from shape and override his methods.
 * <p>
 * Rectangle object has a width, a height and is divided into a grid.
 * The grid is used to know where objects are located and for objects retrieval and removal.
 * Position {0,0} corresponds to the bottom left of the surface
 * and {width,height} to the top right.
 *
 * @author BENMOHAMED Charfeddine
 * @name Rectangle
 * @date 03/11/2022
 */

@Getter
@ToString(exclude = "grid")
@EqualsAndHashCode(exclude = "grid")
public class Rectangle{

    /**
     * The width of the surface
     */
    private final int width;

    /**
     * The height of the surface
     */
    private final int height;

    /**
     * The two-dimensional array that represents the Shape divided into a grid
     */
    private final int[][] grid;

    /**
     * Constructs a Shape surface with the width, the height
     * and the two-dimensional array according to the first parameters instance.
     * The Rectangle grid values are initialized to 0, meaning that no mower is on the Rectangle
     *
     * @param width
     * @param height
     */
    public Rectangle(final int width, final int height) {
        Preconditions.checkArgument(width > 0 && height > 0, new DimensionLawnException());
        this.width = width;
        this.height = height;
        this.grid = new int[width + 1][height + 1];
    }
}
