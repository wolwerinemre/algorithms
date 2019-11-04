package eu.costengineering.interview.algorithms;

public class JumpCounter {
    /**
     * Counts the number of jumps needed to get from the first index in the array to the given index.
     * A jump is made by adding the value in the array for the current index, to the current index.
     * <p>
     * For example, given the array [1, 2, 3, 4] and the index 3, there are two jumps:<ul>
     * <li>Start at index 0
     * <li>Jump to index 1 (0 plus the value at index 0)
     * <li>Jump to index 3 (1 plus the value at index 1)
     * </ol>
     * <br><br>
     * @param array of length with range [1, 10000], with values in with range [-1000000, 1000000]
     * @param jumpToIndex to reach by making jumps
     * @return the number of jump to reach the given index, or -1 if the index is never reached.
     */
    public int countJumpsToIndex (int[] array, int jumpToIndex) {
        if (array.length == 1) {
            return 0;
        }
        if(array.length < 1 || array.length>10000) {
        	 throw new IllegalArgumentException("array of length with range [1, 10000]");
        }
        return jumpCounter(array, jumpToIndex);
    }

	private int jumpCounter(int[] array, int index) {
		int count = 0;
        int i = 0;
        while (i + array[i] < index) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= array[i]; j++) {
                if (array[j + i] + j > maxVal) {
                    maxVal = array[j + i] + j;
                    maxValIndex = i + j;             
                }
            }
            if(maxVal >array[index]-array[i] &&  array[index]-array[i] !=0){
        			return -1;
            }
            if(array[i]==0) {
            		throw new IllegalArgumentException("Value = 0 so infinitive loop");
            } else if((array[i]>1000000 || array[i]<-1000000) || (array[index]>1000000 || array[index]<-1000000)) {
            		throw new IllegalArgumentException("with values in with range [-1000000, 1000000]");
            }
            i = maxValIndex;
            count++;
        }
		return count+1;
	}
    
}
