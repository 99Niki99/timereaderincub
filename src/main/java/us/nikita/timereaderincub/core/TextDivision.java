package us.nikita.timereaderincub.core;

import java.util.ArrayList;
import java.util.List;

public class TextDivision {
   static ReadImage readImage = new ReadImage();
   static String textForDivision = readImage.readTextImage();
   static List<String> teamWorkers = new ArrayList<>();
   static List<String> cableName = new ArrayList<>();
   static List<Integer> cableLength = new ArrayList<>();
   static int totalLegth;


    private void divisionOnList(){
        String[] splitText = textForDivision.split("\\n+");

        for (String s : splitText) {
            String line = s.trim();
            String[] words = line.split("\\s+");
            if (hasEmployee(line)) {
                teamWorkers.add(line);
            }
                if (cableName(line)) {
                cableName.add(words[1]);
            }
                if (cableLength(line)) {
                try {                                               //If the program read numbers as letters.
                    cableLength.add(Integer.valueOf(words[1]));
                } catch (Exception e) {
                    System.out.println("not a numbers" + e.getMessage());
                }
            }
        }
       totalLegth = cableLength.stream().reduce(0,Integer::sum);
    }

    private static boolean hasEmployee(String line){
        String keyWords = line;

       return keyWords.startsWith("Operator")|| line.startsWith("Assistant");
    }
    private static boolean cableName (String line){
        String keyWords = line;

        return keyWords.startsWith("Start");
    }
    private static boolean cableLength(String line){
        String keyWords = line;

        return keyWords.endsWith("ft");
    }
}
