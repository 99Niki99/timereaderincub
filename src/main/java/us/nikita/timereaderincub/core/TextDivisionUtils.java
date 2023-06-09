package us.nikita.timereaderincub.core;

import jakarta.annotation.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The class divides the received text from the image into several Arrays
 * @author Nikita
 */
public final class TextDivisionUtils {

    private TextDivisionUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     *The method adds up all the cables produced during the day.
     * @return int all cables
     */
    public static int calculateCableLength(String[] lines) {
        return Arrays.stream(lines)
                .mapToInt(TextDivisionUtils::checkAndFoundLengthCable)
                .sum();
    }

    /**
     * The method stores the names of the workers to the Array <String> buildTea
     * @return List<String> name team workers
     */
    public static List<String> buildTeam(String[] lines) {
        return Arrays.stream(lines)
                .map(TextDivisionUtils::checkNameWorkerShift)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * The method stores cable names in an Array List<String>
     * @return List<String> cable name
     */
    public static List<String> addsCableNameToTheLIst(String[] lines) {
        return Arrays.stream(lines)
                .map(TextDivisionUtils::checkCableName)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    public static HashMap<String, Integer> addCableLength(String[] lines){
        return Arrays.stream(lines)
                .map(TextDivisionUtils::checkLineForAddInMap);
    }

    @Nullable
    private static String checkNameWorkerShift(String line) {
        boolean employeeDataExist = line.startsWith("Operator") || line.startsWith("Assistant");
        if (employeeDataExist) {
            return line;
        }
        return null;
    }

    @Nullable
    private static String checkCableName(String line) {
        boolean cableNameDataExist = line.startsWith("Start");
        if (cableNameDataExist) {
            String[] words = splitToWordsFromImage(line);
            if (words.length == 2) {
                return words[1];
            }
        }
        return null;
    }

    private static int checkAndFoundLengthCable(String line) {
        boolean cableLengthDataExist = line.endsWith("ft");
        if (cableLengthDataExist) {
            String[] words = splitToWordsFromImage(line);
            if (words.length == 3) {
                return Integer.parseInt(words[1]);
            }
        }
        return 0;
    }
    private static void checkLineForAddInMap(String line){
       boolean cableStartAndEndKeyWord = line.startsWith("A") && line.endsWith("ft");
       if (cableStartAndEndKeyWord){
           String[] words = splitToWordsFromImage(line);
        makeKey(words);
        makeObject(words);
       }
    }
    private static String makeKey(String[] words){
        return words[0];
    }
    private static String makeObject(String[] words){
        return words[1];
    }

    private static String[] splitToWordsFromImage(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(String::trim)
                .toArray(String[]::new);

    }

}
