import java.util.*;


public class PartThree{
	public static void main(String[] args){

		int size = 20000000;
		Random rng = new Random();
		ArrayList<Integer> alist = new ArrayList<Integer>();
		Vector<Integer> vector = new Vector<Integer>();
		int[] array = new int[size];
		int temp;
		long start, elapsed;

		int sum = 0;
		for(int i = 0; i<size; i++){
			temp = rng.nextInt(9);
			alist.add(temp);
			vector.add(temp);
			array[i] = temp;
		}

		Iterator<Integer> aItr = alist.iterator();
		Iterator<Integer> vItr = vector.iterator();

		start = System.nanoTime();
		while(aItr.hasNext()){
			sum+= aItr.next();
		}
		elapsed = System.nanoTime() - start;
		System.out.println("ArrayList took " + elapsed/1000000000.0 + " seconds");

		start = System.nanoTime();
		while(vItr.hasNext()){
			sum+= vItr.next();
		}
		elapsed = System.nanoTime() - start;
		System.out.println("Vector took " + elapsed/1000000000.0 + " seconds");

		start = System.nanoTime();
		for(int i =0; i< size; i++){
			sum+= array[i];
		}
		
		elapsed = System.nanoTime() - start;
		System.out.println("Array took " + elapsed/1000000000.0 + " seconds");
	}
}