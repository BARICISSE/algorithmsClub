package algorithmsClub;
import java.util.*;


public class Solutions {

	public static void main(String [] args){

		int[] arr1 = {1,2,3,4};
		int [] arr2 = {2, 3, 4, 8, 7};
		double median = findMedianSortedArrays(arr1,arr2);

		List<String> y = generateParenthesis(3);

		System.out.println("median is " + y);

		int x = findPeakElement(arr2);

		System.out.println("peak  is " + x);


		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(2);

		LinkedList<Integer> newList = removeDuplicates(list);

		System.out.println(list);


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
}
