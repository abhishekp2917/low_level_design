public class Client1 {
    
    public static void main(String[] args) {

        /* 
         * PROBLEM SOLUTION USING FLYWEIGHT PATTERN
         *
         * In this loop, we simulate drawing 100,000 circle instances with different positions.
         * However, we avoid creating 100,000 separate objects to save memory.
         * 
         * The Flyweight Pattern allows reusing `Shape` objects with the same intrinsic state
         * (i.e., same `radius` and `color`), fetched via `ShapeFactory`.
         *
         * The extrinsic data (`xCoordinate`, `yCoordinate`) is set dynamically on the reused object.
         */
        for (int i = 1; i <= 100000; i++) {

            // Get (or create if needed) a shared Circle object with same radius & color
            Shape circle = ShapeFactory.getShape(
                "CIRCLE",
                getRandomRadius(), 
                getRandomColor(),
                getRandomXCoordinate(), 
                getRandomYCoordinate()
            );

            // Draw the circle (extrinsic properties like position are set before draw)
            circle.draw();
            System.out.println();
        }
    }

    /*
     * Returns a random color from the enum list.
     * This value is part of the intrinsic state for flyweight reuse.
     */
    public static Color getRandomColor() {
        int index = (int) (Math.random() * (Color.values().length - 1));
        return Color.values()[index];
    }

    /*
     * Returns a random radius value, part of the intrinsic state.
     * The number of unique radii will affect object reuse count.
     */
    public static double getRandomRadius() {
        return Math.random() * 100;
    }

    /*
     * Returns random X coordinate (extrinsic state)
     */
    public static double getRandomXCoordinate() {
        return Math.random() * 1000;
    }

    /*
     * Returns random Y coordinate (extrinsic state)
     */
    public static double getRandomYCoordinate() {
        return Math.random() * 1000;
    }
}
