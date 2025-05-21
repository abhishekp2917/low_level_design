package StructuralPattern.BridgePattern.example1.solution;

/* 
    creating Film resource to show it in different views
*/
public class Film implements Resource {
    
    private String title;
    private String genere;

    Film(String title, String genere) {
        this.genere = genere;
        this.title = title;
    }

    public String getGenere() {
        return genere;
    }

    public String getTitle() {
        return title;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*
        overriding intro method to show Film intro 
    */
    @Override
    public void intro() {
        System.out.println("Film Title : " + this.title);
    }

    /*
        overriding intro method to show Film description 
    */
    @Override
    public void description() {
        System.out.println("Genere : " + this.genere);
    }
}
