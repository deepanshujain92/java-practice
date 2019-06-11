
import java.util.PriorityQueue;

public class ArrayQuestions {
	public static void main(String args[]) {
		int[] arr = { 1, 2, 3,4, 5 };
		int k = 2;
		for (int i:new ArrayQuestions().rotateArray(arr, k)) {
			System.out.println(i);
		}
		int[] input = { 0, 1, 1,0, 1 };
		for (int i:new ArrayQuestions().sort01(input)) {
			System.out.println(i);
		}
	}

	public int findKthLargest(int[] nums, int k) {
		if (k > nums.length)
			return -1;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i : nums) {
			q.offer(i);

			if (q.size() > k) {
				q.poll();
			}
		}
		return q.peek();
	}

	public int[] rotateArray(int[] nums, int d) {
		int n=nums.length;
		int gcd = gcd(n, d);
        int i, j, k, temp; 
		for (i = 0; i < gcd; i++) {
            j = i; 
			temp=nums[i];
			while(true) {
				k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break;
                nums[j] = nums[k]; 
                j = k; 			
           }
            nums[j] = temp; 
		}
		return nums;
	}

	int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	public int[] sort01(int[] input)
	{
		int start=0;
		int end=input.length-1;
		while(start<end)
		{
			if(input[start]==1)
			{
				int temp = input[start];
				input[start]=input[end];
				input[end]=temp;
				end--;
			}
			else
			{
				start++;
			}
		}
		return input;
	}
}
