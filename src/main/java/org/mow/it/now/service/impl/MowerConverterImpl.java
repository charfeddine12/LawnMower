package org.mow.it.now.service.impl;

import com.google.common.base.Preconditions;
import org.mow.it.now.config.Constants;
import org.mow.it.now.exceptions.MowerConverterException;
import org.mow.it.now.exceptions.MowerCreatorException;
import org.mow.it.now.exceptions.MowerOutOfBoundsException;
import org.mow.it.now.model.enumeration.CardinalDirection;
import org.mow.it.now.model.enumeration.Instruction;
import org.mow.it.now.model.mower.Mower;
import org.mow.it.now.service.MowerConverter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author BENMOHMAED Charfeddine
 * @name MowerConverter
 * @date 05/11/2022
 */
public class MowerConverterImpl implements MowerConverter {

    @Override
    public Mower convert(String[] initializers, String instructions) {
        int x = Integer.parseInt(initializers[0]);
        int y = Integer.parseInt(initializers[1]);
        CardinalDirection cardinalDirection = CardinalDirection.valueOf(initializers[2]);
        Preconditions.checkArgument(instructions.matches(Constants.INSTRUCTION_PATTERN), new MowerConverterException(instructions));
        Mower mower = new Mower(x, y, cardinalDirection, createInstruction(instructions.split(Constants.CHARACTER_SEPRATOR)));
        return mower;
    }


    private Queue<Instruction> createInstruction(String[] instructionSequence) {
        Queue<Instruction> instructions = new LinkedList<>();
        Arrays.stream(instructionSequence).forEach(s -> instructions.add(Instruction.valueOf(s)));
        return instructions;
    }

}
