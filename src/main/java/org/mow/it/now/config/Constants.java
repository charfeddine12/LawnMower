package org.mow.it.now.config;

/**
 * The constants of the application
 *
 * @author BENMOHAMED Charfeddine
 * @name Constants
 * @date 04/11/2022
 */
public final class Constants {

    public static final String BASE_PATH = "D:\\Projects\\Exam\\mine\\LawnMower\\src\\main\\resources\\";
    public static final String WHITE_SPACE_SEPARATOR = " ";
    public static final String MOWER_PATTERN = "^\\d+ \\d+ [N|E|W|S]$";
    public static final String INSTRUCTION_PATTERN = "[DGA.? ]*";
    public static final String LAWN_PATTERN = "^\\d+ \\d+$";
    public static final String CHARACTER_SEPRATOR = "(?!^)";


    private Constants() {
    }
}
