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
     * Adds command to script
     * @param command - typed Callable
     */
    public void AddCommand(Callable command) {

        commands.add(command);
    }

    /**
     * Execute script start to finish
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
