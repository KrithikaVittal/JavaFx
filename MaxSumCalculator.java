
/**
 * Maximum Subarray (Java)
 
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * @author 325105690
 *
 */
public class MaxSumCalculator {
	
	public int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			System.out.println("*************************");
			//System.out.println("sum[i]-->"+sum[i-1]+"  A[i]-->"+A[i]);
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			//System.out.println("sum"+sum+"  A[i]-->"+A[i]);
			//System.out.println("max-->    "+max);
			max = Math.max(max, sum[i]);
			//System.out.println("max-->    "+max);
			System.out.println("*************************");
		}
 
		return max;
	}

	
	public static void main(String args[]){
		System.out.println(new MaxSumCalculator().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
}

