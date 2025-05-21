package BehaviouralPattern.TemplateMethodPattern.example1.Solution;

/* 
    CricketGameLoader which extends GameLoader to load online cricket game
    It has different implementation for download dependencies and building GUI
*/
public class CricketGameLoader extends GameLoader {

    // method to download dependencies for cricket game
    @Override
    public void downloadDependencies() {
        System.out.println("Downloading Cricket game dependencies");
    }

    // method to build GUI for cricket game
    @Override
    public void buildGUI() {
        System.out.println("Building GUI for Cricket game");
    }
}
