package StructuralPattern.ProxyPattern.example1.Solution;

public class ProfileImageLoader implements ImageLoader{

    String imageName;
    String url;

    public  ProfileImageLoader(String imageName, String url) {
        this.imageName = imageName;
        this.url = url;
    }

    @Override
    public void loadImage(String imageName, String URL) {   
        
        System.out.println("Creating connection...");
        System.out.println("Fetching image");
    }
    
}
