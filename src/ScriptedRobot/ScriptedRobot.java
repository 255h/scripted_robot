

package ScriptedRobot;



public class ScriptedRobot {

    public static void main(String[] args) {

        String file_name = (args.length > 0)?args[0]:"useless_box.txt";
        Script script = ScriptFactory.GetScript(file_name);
        script.execute();

    }

}


