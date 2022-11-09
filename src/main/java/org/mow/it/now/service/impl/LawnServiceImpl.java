package org.mow.it.now.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mow.it.now.config.Constants;
import org.mow.it.now.exceptions.FileIncompleteException;
import org.mow.it.now.model.lawn.Rectangle;
import org.mow.it.now.model.mower.Mower;
import org.mow.it.now.service.LawnService;
import org.mow.it.now.service.RectangleConverter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The starter of the mow action
 *
 * @author BENMOHAMED Charfeddine
 * @name LawnServiceImpl
 * @date 04/11/2022
 */
@Slf4j
public class LawnServiceImpl implements LawnService {


    @Override
    public List<Mower> mow(final String fileName) {
        Preconditions.checkArgument(readFile(fileName).size() > 2, new FileIncompleteException());
        Iterator<String> inputFile = readFile(fileName).iterator();

        RectangleConverter rectangleConverter = new RectangleConverterImpl();
        Rectangle rectangle = rectangleConverter.convert(inputFile.next());
        log.info("The rectangle created with the dimension :{}", rectangle);
        List<Mower> mowers = new ArrayList<>();
        while (inputFile.hasNext()) {
            MowerCreatorImpl mowerCreator = new MowerCreatorImpl(rectangle);
            Mower mower = mowerCreator.createMower(new String[]{inputFile.next(), inputFile.next()});
            log.info("The mower: {} was created and finished all his movements with cardinality X: {}, Y: {}, direction: {}",
                    mower.getRef(), mower.getPositionX(), mower.getPositionY(), mower.getDirection());
            mowers.add(mower);
        }
        return mowers;
    }

    @SneakyThrows(IOException.class)
    private List<String> readFile(final String fileName) {
        return Files.readLines(new File(Constants.BASE_PATH + fileName), StandardCharsets.UTF_8);
    }

}
