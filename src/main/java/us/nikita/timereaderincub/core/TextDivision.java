package us.nikita.timereaderincub.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextDivision {
    static ReadImage readImage = new ReadImage();
    static String textForDivision = readImage.readTextImage();
    static List<String> teamWorkers = new ArrayList<>();
    static List<String> cableName = new ArrayList<>();
    static List<Integer> cableLength = new ArrayList<>();
    static int totalLegth;


    private void setTextForDivision() {
        Arrays.stream(textForDivision.split("\\n+"))
                .map(String::trim)
                .forEach(line -> {
                    String[] words = Arrays.stream(line.split("\\s+"))
                            .map(String::trim)
                            .toArray(String[]::new);
                    addTeamWorkerIfExist(line);
                    cableNameIfExist(line, words);
                    cableLengthIfExist(line, words);
                });

        totalLegth = cableLength.stream().reduce(0, Integer::sum);
    }

    private static void addTeamWorkerIfExist(String line) {
        boolean employeeDataExist = line.startsWith("Operator") || line.startsWith("Assistant");
        if (employeeDataExist) {
            teamWorkers.add(line);
        }
    }

    private static void cableNameIfExist(String line, String[] words) {
        boolean cableNameDataExist = line.startsWith("Start");
                if (cableNameDataExist) {
            cableName.add(words[1]);
        }
    }

    private static void cableLengthIfExist(String line, String[] words) {
        boolean cableLengthDataExist = line.endsWith("ft");
        if (cableLengthDataExist) {
            cableLength.add(Integer.valueOf(words[1]));
        }
    }
}
