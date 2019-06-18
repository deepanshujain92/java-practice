
public class MaximumSum {
    public static int getMaxSum(int arr[]){
      //we will be maintaining two variables, one to keep maximum sum so far and current sum till now.
    	int maxSoFar = 0;
    	int currentMax = 0;
    	for(int i=0;i<arr.length;i++){
    	      currentMax = currentMax+arr[i];
    	      //if currentMax is less than we can count it as zero
            currentMax = currentMax>0?currentMax:0;
    	      maxSoFar = currentMax>maxSoFar?currentMax:maxSoFar;    	
      }
    	return maxSoFar;
}
    public static void main(String[] args) {
    	
    	int arr[] = {4,-2,3,-11,0,4};
        System.out.println(getMaxSum(arr));
	}
}
