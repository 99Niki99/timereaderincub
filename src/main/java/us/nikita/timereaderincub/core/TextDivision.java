package us.nikita.timereaderincub.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextDivision {
    ReadImage readImage = new ReadImage();
    String textForDivision = readImage.readImage();

    List<String> teamWorkers = new ArrayList<>();
    List<String> cable = new ArrayList<>();


    public void textDivision(){
        String[] splitText = textForDivision.split("\n");
        for (int i = 0; i < splitText.length; i++) {
            String line = splitText[i].trim();
            String[] words = line.split("\\s");
            if (words[i].equals("Operator") || words[i].equals("Assistent")) {
                teamWorkers.add(Arrays.toString(words));
                teamWorkers.remove(0);
            } else  if(words[i].equals("Start")){
                cable.add(words[1]);
            }
        }
        for(String line : teamWorkers){
            System.out.println(line + " Новая строка");
        }
    }
}
