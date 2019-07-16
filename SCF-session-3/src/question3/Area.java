package question3;

import java.util.*;

public class Area {

	/**
	 * Calculate area of triangle
	 * @param width  of the triangle
	 * @param height of the triangle
	 * @return area of the triangle
	 */
	static double areaOfTriangle(double width, double height) {
		double area;
		area = 0.5 * width * height;
		return Math.round(area * 100.0) / 100.0;
	}

	/**
	 * calculate area of rectangle
	 * @param width  of the rectangle
	 * @param height of the rectangle
	 * @return area of rectangle
	 */
	static double areaOfRectangle(double width, double height) {
		double area;
		area = width * height;
		return Math.round(area * 100.0) / 100.0;
	}

	/**
	 * calculate area of square
	 * @param width of the square
	 * @return area of the square
	 */
	static double areaOfSquare(double width) {
		double area;
		area = width * width;
		return Math.round(area * 100.0) / 100.0;
	}

	/**
	 * calculate area of circle
	 * @param radius of the circle
	 * @return area of the circle
	 */
	static double areaOfCircle(double radius) {
		double area;
		area = Math.PI * radius * radius;
		return Math.round(area * 100.0) / 100.0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;
		double height, radius, width;

		do {
			System.out.println("Select the preferred choice:\n1.Area of triangle\n2.Area of rectangle\n3.Area of square\n4.Area of circle\n5.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the height");
				height = sc.nextDouble();
				System.out.println("Enter the width");
				width = sc.nextDouble();
				System.out.println(areaOfTriangle(height, width));
				break;

			case 2:
				System.out.println("Enter the height");
				height = sc.nextDouble();
				System.out.println("Enter the width");
				width = sc.nextDouble();
				System.out.println(areaOfRectangle(height, width));
				break;

			case 3:
				System.out.println("Enter the width");
				width = sc.nextDouble();
				System.out.println(areaOfSquare(width));
				break;

			case 4:
				System.out.println("Enter the Radius");
				radius = sc.nextDouble();
				System.out.println(areaOfCircle(radius));
				break;

			case 5:
				System.exit(0);

			default:
				System.out.println("Invalid choice ... please try again");
				break;

			}
		} while (true);
	}
}
