package org.mow.it.now.service.impl;

import com.google.common.base.Preconditions;
import lombok.Getter;
import org.mow.it.now.config.Constants;
import org.mow.it.now.exceptions.MowerCreatorException;
import org.mow.it.now.exceptions.MowerOutOfBoundsException;
import org.mow.it.now.model.lawn.Rectangle;
import org.mow.it.now.model.mower.Mower;
import org.mow.it.now.service.MowerCreator;

/**
 * Create a mower lawn from an array of string
 *
 * @author BENMOHAMED Charfeddine
 * @name MowerCreator
 * @date 04/11/2022
 */
public class MowerCreatorImpl implements MowerCreator {

    @Getter
    private final Rectangle rectangle;

    public MowerCreatorImpl(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


    @Override
    public Mower createMower(String[] sources) {
        Preconditions.checkArgument(sources[0].matches(Constants.MOWER_PATTERN), new MowerCreatorException(sources[0]));
        String[] mowerInitializer = sources[0].split(Constants.WHITE_SPACE_SEPARATOR);

        Preconditions.checkArgument(isInBounds(Integer.parseInt(mowerInitializer[0]), Integer.parseInt(mowerInitializer[1])),
                new MowerOutOfBoundsException(rectangle.getWidth() + "," + rectangle.getHeight()));

        MowerConverterImpl mowerConverter = new MowerConverterImpl();
        Mower mower = mowerConverter.convert(mowerInitializer, sources[1]);

        if (!isOccupied(mower.getPositionX(), mower.getPositionY())) {
            placeMower(mower.getRef(), mower.getPositionX(), mower.getPositionY());
            move(mower);
        }
        return mower;
    }


    @Override
    public boolean isInBounds(int positionX, int positionY) {
        return positionX >= 0 && positionX <= rectangle.getWidth() && positionY >= 0 && positionY <= rectangle.getHeight();
    }

    @Override
    public void placeMower(int ref, int x, int y) {
        rectangle.getGrid()[x][y] = ref;
    }

    @Override
    public boolean isOccupied(int x, int y) {
        return rectangle.getGrid()[x][y] != 0;
    }

    @Override
    public void move(Mower mower) {
        mower.getInstructionSequence().stream().forEach(instruction -> {
            switch (instruction.toString()) {
                case "G":
                    mower.setDirection(mower.getDirection().rotateToLeft());
                    break;
                case "D":
                    mower.setDirection(mower.getDirection().rotateToRight());
                    break;
                case "A":
                    moveToFront(mower);
                    break;
                default:
                    break;
            }
            rectangle.getGrid()[mower.getPositionX()][mower.getPositionY()] = mower.getRef();
        });
    }

    private void moveToFront(Mower mower) {
        switch (mower.getDirection()) {
            case N:
                if (isInBounds(mower.getPositionX(), mower.getPositionY() + 1)) {
                    mower.setPositionY(mower.getPositionY() + 1);
                }
                break;
            case E:
                if (isInBounds(mower.getPositionX() + 1, mower.getPositionY())) {
                    mower.setPositionX(mower.getPositionX() + 1);
                }
                break;
            case W:
                if (isInBounds(mower.getPositionX() - 1, mower.getPositionY())) {
                    mower.setPositionX(mower.getPositionX() - 1);
                }
                break;
            case S:
                if (isInBounds(mower.getPositionX(), mower.getPositionY() - 1)) {
                    mower.setPositionY(mower.getPositionY() - 1);
                }
                break;
            default:
                break;
        }
    }
}
