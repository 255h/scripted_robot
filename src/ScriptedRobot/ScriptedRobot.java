

package ScriptedRobot;



public class ScriptedRobot {

    public static void main(String[] args) {

        if (args.length != 1){
            System.out.println("Usage: java ScriptedRobot <filename>");
            return;
        }

        Script script = ScriptFactory.GetScript(args[0]);
        script.execute();

    }

}


