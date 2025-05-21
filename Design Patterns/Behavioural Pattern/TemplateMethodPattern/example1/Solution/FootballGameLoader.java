package BehaviouralPattern.TemplateMethodPattern.example1.Solution;

/* 
    FootballGameLoader which extends GameLoader and load online football game
    It has different implementation for download dependencies and building GUI
*/
public class FootballGameLoader extends GameLoader{

    // method to download dependencies for cricket game
    @Override
    public void downloadDependencies() {
        System.out.println("Downloading Football game dependencies");
    }

    // method to build GUI for cricket game
    @Override
    public void buildGUI() {
        System.out.println("Building GUI for Football game");
    }
}
