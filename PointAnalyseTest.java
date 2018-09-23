 
import java.util.Random;

public class PointAnalyseTest{


	public static final int testingSize = 5000000;

	public static void main(String[] args) {
		Random rng = new Random();

		testVersionTwo.test(rng);
		System.out.println();

		testVersionThree.test(rng);
		System.out.println();
		
		testVersionSix.test(rng);
	}

	/**
	 * Convert time in nanoseconds to milliseconds
	 *
	 * @param  time time in nanoseconds
	 * @return      time in milliseconds as a double
	 */
	private static double nanoToMilliSeconds(long time){
		return (double)time / 1000.0;
	}

	public static class testVersionTwo{

		public static void test(Random rng){
			System.out.println("Testing Version 2...");

			PointCPD2[] points = new PointCPD2[testingSize]; // carries the points we will be testing
			PointCPD2[] otherPoints = new PointCPD2[testingSize]; // holds other points for testing the distance function
			double[] testAngles = new double[testingSize]; //holds random angles to test the rotate function

			//loop to initialize the above arrays with random points
			for(int i = 0; i<testingSize; i++){
				points[i] = new PointCPD2('P', rng.nextDouble()*100 , rng.nextDouble()*360); 
				otherPoints[i] = new PointCPD2('P', rng.nextDouble()*100 , rng.nextDouble()*360);
				testAngles[i] = rng.nextDouble()*360;
			}

			testGetters(points);
			testDistance(points, otherPoints);
			testRotate(points, testAngles);
			testConversion(points);

		}

		public static void testGetters(PointCPD2[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getX();
			}

			elapsed = System.nanoTime()- start;
			System.out.println("time to getX of "+ points.length +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getY();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getY of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getRho();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getRho of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");


			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getTheta();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getTheta of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");
		}

		public static void testDistance(PointCPD2[] points, PointCPD2[] otherPoints){

			long start, elapsed;

			start = System.nanoTime();

			for(int i = 0; i<testingSize; i++){
				points[i].getDistance(otherPoints[i]);
			}

			elapsed = System.nanoTime() - start;
			
			System.out.println("time to do Distance of "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed) +" milliseconds.");			
		}

		public static void testRotate(PointCPD2[] points, double[] testAngles){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].rotatePoint(testAngles[i]);
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do rotate on "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");	
		}

		public static void testConversion(PointCPD2[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].convertStorageToCartesian();
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do conversion on "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");
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
				points[i] = new PointCPD3('C', rng.nextDouble()*100 , rng.nextDouble()*100); 
				otherPoints[i] = new PointCPD3('C', rng.nextDouble()*100 , rng.nextDouble()*100);
				testAngles[i] = rng.nextDouble()*360; //holds random angles to test the rotate function
			}

			testGetters(points);
			testDistance(points, otherPoints);
			testRotate(points, testAngles);
			testConversion(points);
		}

		public static void testGetters(PointCPD3[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getX();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getX of "+ points.length +" points: "+ nanoToMilliSeconds(elapsed) +" milliseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getY();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getY of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed) +" milliseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getRho();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getRho of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");


			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getTheta();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getTheta of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");
		}

		public static void testDistance(PointCPD3[] points, PointCPD3[] otherPoints){

			long start, elapsed;
			start = System.nanoTime();

			for(int i = 0; i<testingSize; i++){
				points[i].getDistance(otherPoints[i]);
			}

			elapsed = System.nanoTime() - start;
			System.out.println("time to do Distance of "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed) +" milliseconds.");			
		}

		public static void testRotate(PointCPD3[] points, double[] testAngles){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].rotatePoint(testAngles[i]);
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do rotate on "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");	
		}

		public static void testConversion(PointCPD3[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].convertStorageToPolar();
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do conversion on "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");
		}

		
	}


	public static class testVersionSix{
		
		public static void test(Random rng){
			System.out.println("Testing Version 6...");

			PointD6[] points = new PointD6[testingSize]; // carries the points we will be testing
			PointD6[] otherPoints = new PointD6[testingSize]; // holds other points for testing the distance function
			double[] testAngles = new double[testingSize]; //holds random angles to test the rotate function

			//loop to initialize half the above arrays with random carteisna points
			for(int i = 0; i<testingSize/2; i++){
				points[i] = new CartesianD6('C', rng.nextDouble()*100 , rng.nextDouble()*100); 
				otherPoints[i] = new CartesianD6('C', rng.nextDouble()*100 , rng.nextDouble()*100);
				testAngles[i] = rng.nextDouble()*360; //holds random angles to test the rotate function
			}

			//loop to initialize the above arrays with random polar points
			for(int i = testingSize/2; i< testingSize; i++){  // populates the other half of the array
				points[i] = new PointPolarD6('P', rng.nextDouble()*100 , rng.nextDouble()*360); 
				otherPoints[i] = new PointPolarD6('P', rng.nextDouble()*100 , rng.nextDouble()*360);
				testAngles[i] = rng.nextDouble()*360; //holds random angles to test the rotate function
			}

			testGetters(points);
			testDistance(points, otherPoints);
			testRotate(points, testAngles);
			testConversion(points);
		}

		public static void testGetters(PointD6[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getX();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getX of "+ points.length +" points: "+ nanoToMilliSeconds(elapsed) +" milliseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getY();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getY of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed) +" milliseconds.");

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getRho();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getRho of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");


			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].getTheta();
			}
			elapsed = System.nanoTime()- start;
			System.out.println("time to getTheta of "+testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");
		}

		public static void testDistance(PointD6[] points, PointD6[] otherPoints){

			long start, elapsed;
			start = System.nanoTime();

			for(int i = 0; i<testingSize; i++){
				points[i].getDistance(otherPoints[i]);
			}

			elapsed = System.nanoTime() - start;
			System.out.println("time to do Distance of "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed) +" milliseconds.");			
		}

		public static void testRotate(PointD6[] points, double[] testAngles){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize; i++){
				points[i].rotatePoint(testAngles[i]);
			}
			elapsed = System.nanoTime() - start;

			System.out.println("time to do rotate on "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");	
		}
		
		public static void testConversion(PointD6[] points){
			long start, elapsed;

			start = System.nanoTime();
			for(int i = 0; i<testingSize/2; i++){
				points[i].convertStorageToCartesian();
			}

			for(int i = testingSize; i<testingSize; i++){
				points[i].convertStorageToCartesian();
			}

			elapsed = System.nanoTime() - start;

			System.out.println("time to do conversion to opposite type on "+ testingSize +" points: "+ nanoToMilliSeconds(elapsed)+" milliseconds.");
		}

	}



}

