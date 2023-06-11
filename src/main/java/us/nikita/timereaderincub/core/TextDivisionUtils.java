package us.nikita.timereaderincub.core;

import jakarta.annotation.Nullable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The class divides the received text into several Arrays
 *
 * @author Nikita
 */
public final class TextDivisionUtils {

    private TextDivisionUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * The method stores the names of the workers to the Array <String> buildTea
     *
     * @param lines the text we got from the image
     * @return List<String> name team workers
     */
    public static List<String> buildTeam(String[] lines) {
        if (Objects.nonNull(lines)) {
            return Arrays.stream(lines)
                    .map(TextDivisionUtils::checkNameWorkerShift)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     * Extracts cable data from provided lines
     *
     * @param lines the text we got from the image
     * @return Map<String, Integer> cable Name and Length
     */
    public static Map<String, Integer> extractCableData(String[] lines) {
        if (Objects.nonNull(lines)) {
            return Arrays.stream(lines)
                    .map(TextDivisionUtils::checkLineContainsCableData)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toMap(e -> e[0], e -> Integer.valueOf(e[1])));
        }
        return Collections.emptyMap();
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

    @Nullable
    private static String[] checkLineContainsCableData(String line) {
        boolean cableStartAndEndKeyWord = line.startsWith("A") && line.endsWith("ft");
        if (cableStartAndEndKeyWord) {
            String[] words = splitToWordsFromImage(line);
            if (words.length == 3) {
                return words;
            }
        }
        return null;
    }

    private static String[] splitToWordsFromImage(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(String::trim)
                .toArray(String[]::new);

    }
}
