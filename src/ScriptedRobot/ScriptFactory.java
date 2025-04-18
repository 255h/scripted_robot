package ScriptedRobot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ScriptedRobot.Commands.*;

public class ScriptFactory {
     /**
     * Фабрика
     * Открывает и парсит скрипт.
     * @param scriptName - имя текстового файла со скриптом
     * @return - Инстанция "скрипта"
     */
    static public Script GetScript(String scriptName) {
        Script script = new Script();

        File script_file = new File(scriptName);
        Scanner scanner;
        try {
            scanner = new Scanner(script_file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Callable cmd = parseCommand(line,script);
            if (cmd != null) {
                script.AddCommand(cmd);
            }
        }

        return script;
    }

    static private Callable parseCommand(String raw,Script script) {

        String[] arguments = raw.split(" ");

        String cmd  = extractArgument(arguments,0);
        String arg1 = extractArgument(arguments,1);
        String arg2 = extractArgument(arguments,2);
        String arg3 = extractArgument(arguments,3);
        String arg4 = extractArgument(arguments,4);
        String arg5 = extractArgument(arguments,5);

        Callable command = null;
        switch (cmd) {
            case "mouse":
                if (arg1.equals("move")){
                    command = new MouseMoveCommand(Integer.parseInt(arg2),Integer.parseInt(arg3));
                } else if (arg1.equals("press")) {
                    command = new MouseButtonCommand(Integer.parseInt(arg2),Boolean.parseBoolean(arg3));
                } else if (arg1.equals("wheel")) {
                    command = new MouseWheelCommand(Integer.parseInt(arg2));
                }
                break;
            case "keyboard":
                command = new KeyboardButtonCommand(Integer.parseInt(arg1),Boolean.parseBoolean(arg2));
                break;
            case "wait":
                command = new WaitCommand(Integer.parseInt(arg1));
                break;
            case "wait_pixel":
                command = new WaitPixelCommand(Integer.parseInt(arg1),Integer.parseInt(arg2),Integer.parseInt(arg3),Integer.parseInt(arg4),Integer.parseInt(arg5));
                break;
            case "reset":
                command = new RestartCommand(script);
        }

        return command;

    }

    static public String extractArgument(String[] raw,int index){
        if (index > raw.length-1){
            return "";
        }
        return raw[index];
    }
}
