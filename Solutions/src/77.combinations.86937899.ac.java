public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> result_list = new LinkedList<List<Integer>>();
		 result_list.add(new LinkedList<Integer>());
		 for(int i=k-1; i >= 0; i--){
		 	int size = result_list.size();
		 	for(int j=0; j<size; j++){
		 		LinkedList<Integer> result = (LinkedList<Integer>) result_list.pollFirst();
		        int start = (result.isEmpty()) ? 0 : result.getLast();
		        for(int m=start+1; m +i <=n ; m++){
		        	LinkedList<Integer> r = new LinkedList<Integer>(result);
		        	r.add(m);
		        	result_list.add(r);
		        		}	
		    		}
		 		}
		 return result_list; 
    }
}
