package ScriptedRobot;

import ScriptedRobot.Commands.Callable;

import java.util.ArrayList;



public class Script  {
    private int programCounter;
    protected ArrayList<Callable> commands = new ArrayList<>( );

    public void Goto(int pc){
        programCounter = pc;
    }

    /**
     * Добавляет комманду в скрипт
     * @param command - комманда типа Callable
     */
    public void AddCommand(Callable command) {

        commands.add(command);
    }

    /**
     * Выполнить скрипт
     */
    public void execute() {
        programCounter = 0;

        boolean is_running = true;
        do{
            if (programCounter >= commands.size() || programCounter < 0) {
                is_running = false;
                continue;
            }

            Callable command = commands.get(programCounter);
            programCounter++;

            command.call();



        }while(is_running);
    }

}
