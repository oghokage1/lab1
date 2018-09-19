 
import java.util.Random;

public class PointTest{

	public static final int testingSize = 1000000;
	/*public void testGetters(){

	}

	public void testDistance(){

	}

	public void testRotate(){

	}

	public void test2Cartesian(){

	}

	public void test2Polar(){

	}

*/
	public static void main(String[] args) {
		Random rng = new Random();
		testVersionTwo.test(rng);
	}

	public static class testVersionTwo{

		public static void test(Random rng){
			System.out.println("Testing Version 2...");

			PointCPD2[] points = new PointCPD2[testingSize]; // carries the points we will be testing
			PointCPD2[] otherPoints = new PointCPD2[testingSize]; // holds other points for testing the distance function

			//loop to initialize the above arrays with random points
			for(int i = 0; i<testingSize; i++){
				points[i] = new PointCPD2(rng.nextDouble()*100 , rng.nextDouble()*360); 
				otherPoints[i] = new PointCPD2(rng.nextDouble()*100 , rng.nextDouble()*360);
			}

			testGetters(points);
			testDistance(points, otherPoints);

		}

		public static void testGetters(PointCPD2[] points){
			long start = System.nanoTime();
			for(int i = 0; i<points.length; i++){
				points[i].getX();
			}

			long elapsed = System.nanoTime()- start;
			System.out.println("time to getX of "+ points.length +" points: "+ elapsed +" nanoseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getY();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getY of "+testingSize +" points: "+ elapsed+" nanoseconds.");
		}

		public static void testDistance(PointCPD2[] points, PointCPD2[] otherPoints){

			long start, elapsed;
			start = System.nanoTime();

			for(int i = 0; i<testingSize; i++){
				points[i].getDistance(otherPoints[i]);
			}

			elapsed = System.nanoTime() - start;
			System.out.println("time to do Distance of "+ testingSize +" points: "+ elapsed+" nanoseconds.");			
		}

/*
		public void testRotate(){

		}

		public void test2Cartesian(){

		}

		public void test2Polar(){

		}
*/

	}


/*
	public void testVersionThree(){
		System.out.println("Testing Version 3...\n");		
	}

	public void testVersionSix(){
		System.out.println("Testing Version 6...\n");		
	}
*/

}