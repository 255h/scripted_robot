

package ScriptedRobot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScriptedRobot {

    public static void main(String[] args) {

        String scriptName;
        if (args.length != 1){
            System.out.println("Usage: java ScriptedRobot <filename>");
            return;
        } else
            scriptName = args[0];

        String[] raw = readScript(scriptName);
        if (raw == null)
            return;


        Script script = ScriptFactory.GetScript(raw);
        script.execute();

    }

    private static String[] readScript(String scriptName) {

        File sf = new File(scriptName);
        if (!sf.isFile()){
            System.out.println("Script is not a file: " + scriptName);
            return null;
        }

        FileReader fileReader;
        try {
            fileReader = new FileReader(sf);
        } catch (FileNotFoundException e) {
            System.out.println("Script not found: " + scriptName);
            return null;
        }
        List<String> lines = getLines(fileReader);

        return lines.toArray(new String[0]);
    }

    private static List<String> getLines(FileReader fileReader) {

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();

        try {

            String line;
            do {
               line = bufferedReader.readLine();
               if(line != null){
                   line = line.trim().replaceAll("\\s+", " ");
                   line = line.toLowerCase();
                   lines.add(line);
               }

            }while(line != null);

            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

}


