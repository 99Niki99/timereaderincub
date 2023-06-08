package us.nikita.timereaderincub.core;

import jakarta.annotation.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/** Здесь должен быть JavaDoc */
public final class TextDivisionUtils {

    private TextDivisionUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static int calculateCableLength(String[] lines) {
        return Arrays.stream(lines)
                .mapToInt(TextDivisionUtils::cableLengthIfExist)
                .sum();
    }

    public static List<String> buildTeam(String[] lines) {
        return Arrays.stream(lines)
                .map(TextDivisionUtils::addTeamWorkerIfExist)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static List<String> getCableName(String[] lines) {
        return Arrays.stream(lines)
                .map(TextDivisionUtils::cableNameIfExist)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Nullable
    private static String addTeamWorkerIfExist(String line) {
        boolean employeeDataExist = line.startsWith("Operator") || line.startsWith("Assistant");
        if (employeeDataExist) {
            return line;
        }
        return null;
    }

    @Nullable
    private static String cableNameIfExist(String line) {
        boolean cableNameDataExist = line.startsWith("Start");
        if (cableNameDataExist) {
            String[] words = splitToWords(line);
            if (words.length == 2) {
                return words[1];
            }
        }
        return null;
    }

    private static int cableLengthIfExist(String line) {
        boolean cableLengthDataExist = line.endsWith("ft");
        if (cableLengthDataExist) {
            String[] words = splitToWords(line);
            if (words.length == 3) {
                return Integer.parseInt(words[1]);
            }
        }
        return 0;
    }

    private static String[] splitToWords(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(String::trim)
                .toArray(String[]::new);

    }

}
