package ScriptedRobot.Commands;

import ScriptedRobot.Script;

public class RestartCommand implements  Callable{
    Script script;
    public RestartCommand(Script scr) {
        script = scr;
    }
    @Override
    public void call() {
        script.Goto(0);
    }
}
