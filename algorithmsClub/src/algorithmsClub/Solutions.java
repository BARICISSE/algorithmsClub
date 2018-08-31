package algorithmsClub;

public class Solutions {
	
	public static void main(String [] args){
		
		int[] arr1 = {1,2,3,4};
		int [] arr2 = {2, 3, 4, 6, 7};
		double median = findMedianSortedArrays(arr1,arr2);
		
		System.out.println("median is " + median);
		
		
		
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
 
}
