package eu.costengineering.interview.algorithms;

public class BestShuffle {

    /**
     * Calculate the maximum sum of the differences of four elements.
     * <p>
     * For example, the sum of differences of the array [1, 2, 4, 8] is 7 (difference [0, 1] = 1, [1, 2] = 2 and [2, 3] = 4),
     * when re-ordered to [2, 4, 1, 8] it is 12 (difference [0, 1] = 2, [1, 2] = 3 and [2, 3] = 7),
     * but the maximum sum of differences is 16 for the ordering [2, 8, 1, 4] (difference [0, 1] = 6, [1, 2] = 7 and [2, 3] = 3);
     *
     * @param array of length four with values in with range [-1000000, 1000000]
     * @return the maximum value of the differences for any ordering of the given values
     */
	
    public int calculateBestShuffle(int[] array) {
    		int maxVal = 0;
		int currVal = 0;
		int orderVal = 24;
		for (int i = 0; i < orderVal; i++) {
				nextArray(array);
				currVal = sumDiff(array);
			if (currVal > maxVal)
				maxVal = currVal;
			
		}
      return maxVal;
    }
    
    private void nextArray(int[] array) {
        if(array == null || array.length<2)
            return;
     
        int p=0;            
        for(int i=array.length-2; i>=0; i--){
            if(array[i]<array[i+1]){
                p=i;
                break;
            }    
        }
     
        int q = 0;
        for(int i=array.length-1; i>p; i--){
            if(array[i]> array[p]){
                q=i;
                break;
            }    
        }
     
        if(p==0 && q==0){
            reverseArray(array, 0, array.length-1);
            return;
        }
     
        int temp=array[p];
        array[p]=array[q];
        array[q]=temp;
     
        if(p<array.length-1){
            reverseArray(array, p+1, array.length-1);
        }
    }
     
    private void reverseArray(int[] array, int left, int right){
        while(left<right){
            int temp = array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }
    
    private int sumDiff(int[] array){
        if (array.length == 0){ 
            throw new IllegalArgumentException("No length");
        }
        int sum = 0;
        for (int i = 0; i < array.length-1; ++i){
        		if(array[i]>1000000 || array[i]<-1000000) {
        			throw new IllegalArgumentException("Illegal Argument : array of length four with values in with range [-1000000, 1000000]");
        		}
         	sum += Math.abs(array[i] - array[i+1]);
        }
        return sum;
    } 
  

}
