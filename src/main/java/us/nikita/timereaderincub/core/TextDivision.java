package us.nikita.timereaderincub.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextDivision {
    private static final List<String> EMPLOYEE_PREFIX = List.of("Operator", "Assistant");
   static ReadImage readImage = new ReadImage();
   static String textForDivision = readImage.readImage();

   static List<String> teamWorkers = new ArrayList<>();
   static List<String> cable = new ArrayList<>();
    static List<Integer> cableLength = new ArrayList<>();
    static int totalLegth;


    public static void main(String[] args){
        String[] splitText = textForDivision.split("\\n+");

        for (String s : splitText) {
            String line = s.trim();
            String[] words = line.split("\\s+");


            if (hasEmployee(line)) {
                teamWorkers.add(line);
            } else
                if (words[1].equals("Start")) {
                cable.add(words[1]);
            } else
                if (words[words.length - 1].equals("ft")) {
                try {
                    cableLength.add(Integer.valueOf(words[1]));
                } catch (Exception e) {
                    System.out.println("not number" + e.getMessage());
                }
            }
        }
       totalLegth = cableLength.stream().reduce(0,Integer::sum);
    }

    private static boolean hasEmployee(String line){

       return line.startsWith("Operator")|| line.startsWith("Assistant");
    }
}
