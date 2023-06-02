package us.nikita.timereaderincub.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextDivision {
   static ReadImage readImage = new ReadImage();
   static String textForDivision = readImage.readImage();

   static List<String> teamWorkers = new ArrayList<>();
   static List<String> cable = new ArrayList<>();
    static List<Integer> cableLength = new ArrayList<>();
    static int totalLegth;


    public static void main(String[] args){
        String[] splitText = textForDivision.split("\n");

        for (int i = 0; i < splitText.length; i++) {
            String line = splitText[i].trim();
            String[] words = line.split("\\s");
            if (words[0].equals("Operator") || words[0].equals("Assistent")) {
                teamWorkers.add(Arrays.toString(words));
                teamWorkers.remove(0);
            } else  if(words[1].equals("Start")){
                cable.add(words[1]);
            } else if (words[words.length-1].equals("ft")){
                try {
                    cableLength.add(Integer.valueOf(words[1]));
                }catch (Exception e){
                    System.out.println("Ошибка ввода числа" + e.getMessage());
                }
            }
        }
       totalLegth = cableLength.stream().reduce(0,Integer::sum);
        System.out.println(totalLegth);
    }
}
