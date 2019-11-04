package eu.costengineering.interview.algorithms;


public class ChainBreaker {


    /**
     * A chain is made of one or more links which have a value.
     * Break a given chain in three parts where the value of the removed links is minimal.
     * <p>
     * For example, the array [1, 2, 3, 4, 5, 6] represents a chain of links.
     * This chain can be broken only in three ways:<ul>
     * <li>[1], [3], [5, 6] (value of removed links = 2 + 4 = 6)
     * <li>[1], [3, 4], [6] (value of removed links = 2 + 5 = 7)
     * <li>[1, 2], [4], [6] (value of removed links = 3 + 5 = 8)
     * </ul>
     *
     * @param array with length in range [5, 10000], with values in range [-1000000, 1000000]
     * @return the minimum value of the removed links which breaks the chain into three separate chains.
     */
    public int calculateMinimumBreakValue(int[] array) {
    		if(array.length<5) {
			throw new IllegalArgumentException("array with length in range [5, 10000]");
		}
        return chainBreaker(array);
    }
    
    private int chainBreaker(int[] array) {
        // first chain break minimum cost
    		int result = array[1]+array[3]; 
        int cost = 0;
        for(int i=1; i<array.length-3; i++){
            for(int j = i+2; j<array.length-1; j++){
                cost = array[i]+array[j];
                if((array[i]>1000000 || array[i]<-1000000) || (array[j]>1000000 || array[j]<-1000000)) {
            			throw new IllegalArgumentException("with values in with range [-1000000, 1000000]");
                }
                if(cost < result){
                		result = cost;
                }
            }
        }
        return result;
    }


}
