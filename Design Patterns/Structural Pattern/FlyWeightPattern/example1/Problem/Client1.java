public class Client1 {

    public static void main(String[] args) {

        /*
         * In this simulation, we are creating 100,000 Circle objects — each with a
         * potentially different radius and color.
         *
         * Even though many circles may share the same color and possibly even radius,
         * a new object is being created every time. This results in a huge number of
         * objects, consuming large memory and affecting performance.
         *
         * This is where the Flyweight Pattern is useful. Instead of creating new
         * objects for circles with the same intrinsic state (e.g. color),
         * we can reuse existing objects — reducing memory footprint.
         *
         * This example shows the **problem scenario** (no Flyweight optimization yet).
         */

        for (int i = 1; i <= 100000; i++) {
            
            // New object created every time, even if color is the same
            Shape circle = new Circle(getRandomRadius(), getRandomColor());

            // Setting extrinsic state (position)
            circle.setPosition(getRandomXCoordinate(), getRandomYCoordinate());

            circle.draw();  // Simulate rendering the circle
            System.out.println();
        }
    }

    // Utility method to return a random color from enum
    public static Color getRandomColor() {
        int index = (int) (Math.random() * (Color.values().length - 1));
        return Color.values()[index];
    }

    // Utility method to return a random radius between 0–100
    public static double getRandomRadius() {
        return Math.random() * (100);
    }

    // Utility method to return random X coordinate
    public static double getRandomXCoordinate() {
        return Math.random() * (1000);
    }

    // Utility method to return random Y coordinate
    public static double getRandomYCoordinate() {
        return Math.random() * (1000);
    }
}
