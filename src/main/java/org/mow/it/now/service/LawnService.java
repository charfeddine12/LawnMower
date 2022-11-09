package org.mow.it.now.service;

import org.mow.it.now.model.mower.Mower;

import java.util.List;

/**
 * Interface for the business logic and the launcher of the actions
 *
 * @author BENMOHAMED Charfeddine
 * @name LawnService
 * @date 03/11/2022
 */
public interface LawnService {


    /**
     * Start the mow operation from the input data with the instructions
     *
     * @param fileName
     * @return The mowers list with the finale position in the lawn
     */
    List<Mower> mow(String fileName);
}
