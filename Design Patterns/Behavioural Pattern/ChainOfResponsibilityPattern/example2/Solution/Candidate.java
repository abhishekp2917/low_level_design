package BehaviouralPattern.ChainOfResponsibilityPattern.example2.Solution;

public class Candidate {
    
    private String name;
    private int codingScore;
    private int technicalScore;
    private double experience;

    public Candidate(String name, int codingScore, int technicalScore, double experience) {
        this.name = name;
        this.codingScore = codingScore;
        this.technicalScore = technicalScore;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public int getTechnicalScore() {
        return technicalScore;
    }

    public double getExperience() {
        return experience;
    }
}
