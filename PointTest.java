 
import java.util.Random;

public class PointTest{


	public static final int testingSize = 10000000;

	public static void main(String[] args) {
		Random rng = new Random();

		testVersionTwo.test(rng);
		System.out.println();

		testVersionThree.test(rng);
		System.out.println();
		
		//testVersionSix.test(rng);
	}

	/**
	 * Convert time in nanoseconds to seconds
	 *
	 * @param  time time in nanoseconds
	 * @return      time in seconds as a double
	 */
	private static double nanoToSeconds(long time){
		return (double)time / 1000000.0;
	}

	public static class testVersionTwo{

		public static void test(Random rng){
			System.out.println("Testing Version 2...");

			PointCPD2[] points = new PointCPD2[testingSize]; // carries the points we will be testing
			PointCPD2[] otherPoints = new PointCPD2[testingSize]; // holds other points for testing the distance function
			double[] testAngles = new double[testingSize]; //holds random angles to test the rotate function

			//loop to initialize the above arrays with random points
			for(int i = 0; i<testingSize; i++){
				points[i] = new PointCPD2(rng.nextDouble()*100 , rng.nextDouble()*360); 
				otherPoints[i] = new PointCPD2(rng.nextDouble()*100 , rng.nextDouble()*360);
				testAngles[i] = rng.nextDouble()*360;
			}

			testGetters(points);
			testDistance(points, otherPoints);
			testRotate(points, testAngles);

		}

		public static void testGetters(PointCPD2[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getX();
			}

			elapsed = System.nanoTime()- start;
			System.out.println("time to getX of "+ points.length +" points: "+ nanoToSeconds(elapsed)+" seconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getY();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getY of "+testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getRho();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getRho of "+testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");


			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getTheta();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getTheta of "+testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");
		}

		public static void testDistance(PointCPD2[] points, PointCPD2[] otherPoints){

			long start, elapsed;

			start = System.nanoTime();

			for(int i = 0; i<testingSize; i++){
				points[i].getDistance(otherPoints[i]);
			}

			elapsed = System.nanoTime() - start;
			
			System.out.println("time to do Distance of "+ testingSize +" points: "+ nanoToSeconds(elapsed) +" seconds.");			
		}

		public static void testRotate(PointCPD2[] points, double[] testAngles){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].rotatePoint(testAngles[i]);
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do rotate on "+ testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");	
		}

	}



	public static class testVersionThree{
		
		public static void test(Random rng){
			System.out.println("Testing Version 3...");

			PointCPD3[] points = new PointCPD3[testingSize]; // carries the points we will be testing
			PointCPD3[] otherPoints = new PointCPD3[testingSize]; // holds other points for testing the distance function
			double[] testAngles = new double[testingSize]; //holds random angles to test the rotate function

			//loop to initialize the above arrays with random points
			for(int i = 0; i<testingSize; i++){
				points[i] = new PointCPD3(rng.nextDouble()*100 , rng.nextDouble()*360); 
				otherPoints[i] = new PointCPD3(rng.nextDouble()*100 , rng.nextDouble()*360);
				testAngles[i] = rng.nextDouble()*360; //holds random angles to test the rotate function
			}

			testGetters(points);
			testDistance(points, otherPoints);
			testRotate(points, testAngles);
		}

		public static void testGetters(PointCPD3[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getX();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getX of "+ points.length +" points: "+ nanoToSeconds(elapsed) +" nanoseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getY();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getY of "+testingSize +" points: "+ nanoToSeconds(elapsed) +" nanoseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getRho();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getRho of "+testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");


			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getTheta();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getTheta of "+testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");
		}

		public static void testDistance(PointCPD3[] points, PointCPD3[] otherPoints){

			long start, elapsed;
			start = System.nanoTime();

			for(int i = 0; i<testingSize; i++){
				points[i].getDistance(otherPoints[i]);
			}

			elapsed = System.nanoTime() - start;
			System.out.println("time to do Distance of "+ testingSize +" points: "+ nanoToSeconds(elapsed) +" seconds.");			
		}

		public static void testRotate(PointCPD3[] points, double[] testAngles){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].rotatePoint(testAngles[i]);
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do rotate on "+ testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");	
		}
		
	}

/*
	public static class testVersionSix{
		
		public static void test(Random rng){
			System.out.println("Testing Version 3...");

			Point[] points = new Point[testingSize]; // carries the points we will be testing
			Point[] otherPoints = new Point[testingSize]; // holds other points for testing the distance function
			double[] testAngles = new double[testingSize]; //holds random angles to test the rotate function

			//loop to initialize the above arrays with random points
			for(int i = 0; i<testingSize; i++){
				points[i] = new PointCPD3(rng.nextDouble()*100 , rng.nextDouble()*360); 
				otherPoints[i] = new PointCPD3(rng.nextDouble()*100 , rng.nextDouble()*360);
				testAngles[i] = rng.nextDouble()*360; //holds random angles to test the rotate function
			}

			testGetters(points);
			testDistance(points, otherPoints);
			testRotate(points, testAngles);
		}

		public static void testGetters(PointCPD3[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getX();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getX of "+ points.length +" points: "+ nanoToSeconds(elapsed) +" nanoseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getY();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getY of "+testingSize +" points: "+ nanoToSeconds(elapsed) +" nanoseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getRho();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getRho of "+testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");


			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getTheta();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getTheta of "+testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");
		}

		public static void testDistance(PointCPD3[] points, PointCPD3[] otherPoints){

			long start, elapsed;
			start = System.nanoTime();

			for(int i = 0; i<testingSize; i++){
				points[i].getDistance(otherPoints[i]);
			}

			elapsed = System.nanoTime() - start;
			System.out.println("time to do Distance of "+ testingSize +" points: "+ nanoToSeconds(elapsed) +" nanoseconds.");			
		}

		public static void testRotate(PointCPD3[] points, double[] testAngles){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].rotatePoint(testAngles[i]);
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do rotate on "+ testingSize +" points: "+ nanoToSeconds(elapsed)+" seconds.");	
		}	
	}

*/

}

