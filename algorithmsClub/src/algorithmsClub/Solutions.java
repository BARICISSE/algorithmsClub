package algorithmsClub;
import java.util.*;

public class Solutions {
	
	public static void main(String [] args){
		
		int[] arr1 = {1,2,3,4};
		int [] arr2 = {2, 3, 4, 6, 7};
		double median = findMedianSortedArrays(arr1,arr2);
		
		List<String> y = generateParenthesis(3);
		
		System.out.println("median is " + y);
		
		
		
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
    
    public static void generate(int n, StringBuilder sb, List parenthesisList, int left, int right ){
    	
    	if(left < right || left > n || right > n){
    		return;
    	}
    	
    	if(left == n && right == n){
    		parenthesisList.add(sb.toString());
    	}
    	
    	sb.append('(');
    	generate(n, sb, parenthesisList, left +1, right);
    	sb.deleteCharAt(sb.length() - 1);
    	
    	
    	sb.append(')');
    	generate(n, sb, parenthesisList, left, right + 1);
    	sb.deleteCharAt(sb.length() - 1);
    	
    }
 
}
