package org.mow.it.now.service.impl;

import com.google.common.base.Preconditions;
import org.mow.it.now.config.Constants;
import org.mow.it.now.exceptions.RectangleCreatorException;
import org.mow.it.now.model.lawn.Rectangle;
import org.mow.it.now.service.RectangleConverter;

/**
 * @author BENMOHMAED Charfeddine
 * @name LawnConverterImpl
 * @date 06/11/2022
 */
public class RectangleConverterImpl implements RectangleConverter {
    @Override
    public Rectangle convert(String source) {
        Preconditions.checkArgument(source.matches(Constants.LAWN_PATTERN), new RectangleCreatorException(source));
        String[] lawnInitializer = source.split(Constants.WHITE_SPACE_SEPARATOR);
        int x = Integer.parseInt(lawnInitializer[0]);
        int y = Integer.parseInt(lawnInitializer[1]);
        return new Rectangle(x, y);
    }
}
