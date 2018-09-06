package algorithmsClub;
import java.util.*;


public class Solutions {

	public static void main(String [] args){

		int[] arr1 = {3, 10, 5, 25, 2, 8};
		int [] arr2 = {73, 74, 75, 71, 69, 72, 76, 73};
		double median = findMedianSortedArrays(arr1,arr2);

		List<String> y = generateParenthesis(3);

		System.out.println("maxXOR is " + findMaximumXOR(arr1));

		int x = findPeakElement(arr2);

		


		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(2);

		LinkedList<Integer> newList = removeDuplicates(list);

		System.out.println(Arrays.toString(dailyTemperatures(arr2).toArray()));


	}

	//median of two sorted arrays -- has a bug
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double y = findMedian(nums1);
		double x = findMedian(nums2);
		double median = (y + x)/2;

		return median;
	}

	public static double findMedian(int [] arr){
		double med = 0;

		if(arr.length == 1){
			med = arr[0];
		}
		else if(arr.length %2 == 0){
			double first = arr[arr.length/2 -1 ];
			double second = arr[arr.length/2 ];
			med = (first + second)/2;
		}
		else{

			med = arr[(arr.length)/2];
		}

		return med;
	}


	//Generate parenthesis
	public static List<String> generateParenthesis(int n){

		List<String> parenthesisList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder("");

		generate(n,sb, parenthesisList,0,0);

		return parenthesisList;


	}

	public static void generate(int n, StringBuilder sb, List parenthesisList, int opening, int closing ){

		if(opening < closing || opening > n || closing > n){
			return;
		}

		if(opening == n && closing == n){
			parenthesisList.add(sb.toString());
		}

		sb.append('(');
		generate(n, sb, parenthesisList, opening +1, closing);
		sb.deleteCharAt(sb.length() - 1);


		sb.append(')');
		generate(n, sb, parenthesisList, opening, closing + 1);
		sb.deleteCharAt(sb.length() - 1);

	}

	//merging overlapping intervals. I HAVE BUGS IN THIS SOLUTION BUT I AM TOO LAZY TO FIX THEM
	/*
	 * 	Given a collection of intervals, merge all overlapping intervals.
	 * 	Input: [[1,3],[2,6],[8,10],[15,18]]
		Output: [[1,6],[8,10],[15,18]]
		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	 */
	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> overrap = new ArrayList<Interval>();

		for(int i = 0; i < intervals.size(); i++){
			for(int j = i + 1; i < intervals.size(); j++ ){
				Interval overrapInterval = new Interval();

				Interval first = intervals.get(i);
				Interval second = intervals.get(j);

				if((first.start <= second.start) && (second.start <= first.end)){
					overrapInterval.start = first.start;
					if(first.end >= second.end){
						overrapInterval.end = first.end;
					}
					else{
						overrapInterval.end = second.end;
					}
				}
				if((second.start <= first.start) && (first.start <= second.end)){
					overrapInterval.start = second.start;

					if(first.end >= second.end){
						overrapInterval.end = first.end;
					}
					else{
						overrapInterval.end = second.end;
					}
				}
				overrap.add(overrapInterval);
				intervals.remove(i);
				intervals.remove(j);
			}
		}

		if(!intervals.isEmpty()){
			for( Interval e : intervals){
				overrap.add(e);
			}
		}

		return overrap;
	}

	/*
	 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
	 * 	Input: [1,2,3]
		Output: [1,2,4]
		Input: [9]
		Output: [1,0]
	 */

	public int[] plusOne(int[] digits) {


		StringBuilder digit = new StringBuilder("");

		for(int number: digits){
			digit.append(number);
		}

		String convertedDigits = digit.toString();

		int convertedInt = Integer.parseInt(convertedDigits) + 1;

		StringBuilder sb = new StringBuilder("");
		sb.append(convertedInt);
		String newSb = sb.toString();

		int [] finalArray = new int[newSb.length()];

		for(int i = 0; i < newSb.length(); i++){

			finalArray[i] = Character.getNumericValue(newSb.charAt(i));
			//Character.getNumericValue(x);
		}



		return finalArray;


	}

	/*
	 * finding an index of a peak element
	 * A peak element is an element that is greater than its neighbors.
	 */
	public static int findPeakElement(int[] nums) {

		int peakIndex = 0;

		int index = 1;

		while(index < nums.length -1){
			if((nums[index] > nums[index - 1]) && (nums[index] > nums[index + 1])){
				peakIndex = index;
			}

			index ++;
		}


		return peakIndex;
	}

	//removing duplicates from a linkedList
	public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list ){

		for(int i = 0; i < list.size(); i++){
			for(int j = i+1; j <list.size(); j++){
				if(list.get(i) == list.get(j)){
					list.remove(j);
				}
			}
		}

		return list;

	}

	//print nth to last elements of a linkedList
	public static int findKthToLast(SNode list, int k){
		if(list == null){
			return 0;
		}
		int index = findKthToLast(list.next, k) +1;
		if(index == k){
			System.out.println(list.element);
		}

		return index;
	}

	//is power of 3
	//return true if an integer is a power of 3 and false if it is not
	public boolean isPowerOfThree(int n) {
		while((n > 2) && (n % 3 ==0)){
			n /= 3;
		}
		return n == 1;

	}
	
	//searching a 2D array
	public boolean searchMatrix(int[][] matrix, int target) {
		boolean isAvailable = false;
		
		for(int i = 0; i < matrix.length; i++){
			for(int index = 0; index < matrix[i].length; index++){
				if(matrix[i][index] == target){
					isAvailable = true;
				}
			}
		}
				
		return isAvailable;		
        
    }
	
	//third max number in from an array of integers
	public int thirdMax(int[] nums) {
		int thirdMax = nums[0];
		Arrays.sort(nums);
		
		int n = 1;
		for( int index = nums.length - 1; index > 0; index-- ){
			if(nums[index] != nums[index -1]){
				if(++n == 3){
					return nums[index-1];
				}
				
			}
		}
		
		return nums[nums.length -1];
	}
	
	/*
	 * Maximum XOR of Two Numbers in an Array
	 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

		Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
	 */
	//TRY RUNNING THIS IN O(n). currently i m running it in O(n^2) and nlogn best case
	public static int findMaximumXOR(int[] nums) {
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
        	for(int j = i +1; j < nums.length; j++){
        		
        		int foundXOR = nums[i] ^nums[j];
        		
        		if(foundXOR > max){
        			max = foundXOR;
        		}
        	}
        }
        
        return max;
    }
	
	/*
	 * Given a list of daily temperatures, produce a list that, for each day in the input,
	 *  tells you how many days you would have to wait until a warmer temperature. 
	 *  If there is no future day for which this is possible, put 0 instead.
	 *  For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
	 */
	//THERE IS AN indexOutOfBoundsException in this method
	public static List<Integer> dailyTemperatures(int[] temperatures) {
		List<Integer> daysToWait = new ArrayList<Integer>();
		
		for(int i = 0; i < temperatures.length; i++){
			int counter = 0;
			int index = i + 1;
			
			while(temperatures[index] <= temperatures[i]  && index < temperatures.length){
				index ++;
			}
			
			counter = index -i;
			
			if(index == temperatures.length){
				counter = 0;
			}
			daysToWait.add(counter);
		}
		
		return daysToWait;
    }
	
	/*
	 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
	 * 	You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, 
	 * output all of them with no order requirement. You could assume there always exists an answer.
	 */
	
	public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> restaurantsList = new ArrayList<String>();
        
        for(int i = 0; i < list1.length; i++){
        	if(contains(list2, list1[i])){
        		restaurantsList.add(list1[i]);
        		
        	}
        	
        }
        for(int j = 0; j < restaurantsList.size() -1;  j++){
        	int firstIndex = getIndex(list1, restaurantsList.get(j)) -getIndex(list2, restaurantsList.get(j));
        	int secondIndex = getIndex(list1, restaurantsList.get(j +1)) -getIndex(list2, restaurantsList.get(j +1));
        	
        	if(Math.abs(firstIndex) > Math.abs(secondIndex)){
        		restaurantsList.remove(j);
        	}
        	if(Math.abs(firstIndex) < Math.abs(secondIndex)){
        		restaurantsList.remove(j + 1);
        	}
        	
        }
        
        String [] restArray = new String[restaurantsList.size()];
        restArray = restaurantsList.toArray(restArray);
        
        return restArray;
    }
	
	//Helper method to check if an array contains a certain string
	public static boolean contains( String [] array, final String v) {

        boolean result = false;

        for(String i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }
	
	//helper method to retrieve indices
	public static int getIndex(String[] arr,String restaurant ){
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == restaurant){
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	
	
	
	
}