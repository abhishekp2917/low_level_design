package StructuralPattern.BridgePattern.example1.solution;

/*
    creating resource interface from which all the concrete resources will be created
    which will be used by different View class to show and hide the resource
*/
public interface Resource {

    public void intro();

    public void description();
}
