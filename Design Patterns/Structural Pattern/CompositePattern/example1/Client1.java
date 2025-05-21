package StructuralPattern.CompositePattern.example1;

/*
    creating various computer components and assembling it together and at last
    printing all the components (single and composite) price
*/
public class Client1 {
    
    public static void main(String[] args) {
        
        // creating various components of computer

        // creating components which are single entity
        Component monitor = new Leaf("monitor", 4000.0);
        Component mouse = new Leaf("mouse", 200.0);
        Component keyboard = new Leaf("keyboard", 600.0);
        Component processor = new Leaf("processor", 6020.0);
        Component hardDrive = new Leaf("hardDrive", 2500.0);
        Component ram4gb = new Leaf("ram4gb", 2100.0);
        Component ram8gb = new Leaf("ram8gb", 4000.0);


        // creating components which are collection of enities
        Component cpu = new Composite("cpu");
        Component peripheralDivice = new Composite("perpheralDivice");
        Component motherBoard = new Composite("motherBoard");
        Component computer = new Composite("computer");


        // assembling computer by adding varoius components into other component
        
        // assembling motherboard
        motherBoard.addComponent(processor);
        motherBoard.addComponent(ram4gb);
        motherBoard.addComponent(ram8gb);

        // assembling cpu
        cpu.addComponent(motherBoard);
        cpu.addComponent(hardDrive);

        // asssembling peripheral divices
        peripheralDivice.addComponent(mouse);
        peripheralDivice.addComponent(keyboard);

        // assembling computer
        computer.addComponent(monitor);
        computer.addComponent(motherBoard);
        computer.addComponent(cpu);
        computer.addComponent(peripheralDivice);

        System.out.println("\nPrinting price of all components inside computer\n");

        for(Component c : computer.getComponents()) {
            System.out.println(c.getName() + ": Price = " + c.calculatePrice());
        }

        System.out.println("\nPrinting price of all components inside motherboard\n");

        for(Component c : motherBoard.getComponents()) {
            System.out.println(c.getName() + ": Price = " + c.calculatePrice());
        }

        System.out.println("\nPrinting price of all components inside CPU\n");

        for(Component c : cpu.getComponents()) {
            System.out.println(c.getName() + ": Price = " + c.calculatePrice());
        }

        System.out.println("\nPrinting price of all components inside periperal divice\n");

        for(Component c : peripheralDivice.getComponents()) {
            System.out.println(c.getName() + ": Price = " + c.calculatePrice());
        }
    }
}