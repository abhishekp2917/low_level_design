package BehaviouralPattern.TemplateMethodPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating Cricket game loader
        GameLoader cricketGame = new CricketGameLoader();

        // creating football game loader
        GameLoader footballGame = new FootballGameLoader();

        // loading cricket game
        cricketGame.load();

        // loading football game
        footballGame.load();
    }
}
