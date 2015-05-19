package Classic_Algorithms;

/**
 * Program: Distance Between Two 3D Points
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: Computes the distance between two 3D
 * points when provided with three dimensional coordinates
 * for each points. The command: 'p2.distance(p1)' provides
 * the distance of point 2 from point 1.
 */

public class testP3D {

    public static void main(String []args){

        // Point Construction
        Point3D p1 = new Point3D(1, 2, 4);
        Point3D p2 = new Point3D(2, 1, 5);

        // Output
        System.out.println(p2.distance(p1));
        System.out.println(p2.distanceL1(p1));

    }

}

class Point3D{

    // Coordinate Storage
    private int[] coordinates = new int[3];

    // Point Structure Constructor
    Point3D(int point1, int point2, int point3){
        this.coordinates[0] = point1;
        this.coordinates[1] = point2;
        this.coordinates[2] = point3;

    }

    // Distance Between Point
    public double distance(Point3D point){

        // Coordinates of the First Point
        int[] point1coordinates = coordinates;

        // The the Coordinates to the Second Point Specified
        int[] point2coordinates = point.getCoordinates();

        // Distance Calculation
        double xcalculation = Math.pow((point1coordinates[0] - point2coordinates[0]), 2);
        double ycalculation = Math.pow((point1coordinates[1] - point2coordinates[1]), 2);
        double zcalculation = Math.pow((point1coordinates[2] - point2coordinates[2]), 2);
        double distance = Math.sqrt(xcalculation + ycalculation + zcalculation);

        // Return Distance
        return distance;

    }

    // Computes the L-1 (Manhattan) Distance
    public double distanceL1(Point3D point){

        // Coordinates of the First Point
        int[] point1coordinates = coordinates;

        // The the Coordinates to the Second Point Specified
        int[] point2coordinates = point.getCoordinates();

        // Distance Calculation
        double xcalculation = Math.abs(point1coordinates[0] - point2coordinates[0]);
        double ycalculation = Math.abs(point1coordinates[1] - point2coordinates[1]);
        double zcalculation = Math.abs(point1coordinates[2] - point2coordinates[2]);
        double distance = xcalculation + ycalculation + zcalculation;

        // Return Distance
        return distance;

    }

    // Return the Coordinates of the Specified Point
    public int[] getCoordinates(){
        return coordinates;

    }

}