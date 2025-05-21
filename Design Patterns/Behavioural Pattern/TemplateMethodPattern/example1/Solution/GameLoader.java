package BehaviouralPattern.TemplateMethodPattern.example1.Solution;

/* 
    GameLoader abstract class which loads game by following certain steps like 
    loading dependencies, building GUI etc
*/
public abstract class GameLoader {
    
    public abstract void downloadDependencies();

    public abstract void buildGUI();

    // method to clean redundant files
    public void cleanRedundantFiles() {
        System.out.println("Cleaning redundant files from system");
    }

    // method to initiate game
    public void initiateGame() {
        System.out.println("Initiating Game\n");
    }

    // method to load game
    public final void load() {
        this.downloadDependencies();
        this.buildGUI();
        this.cleanRedundantFiles();
        this.initiateGame();
    }
}