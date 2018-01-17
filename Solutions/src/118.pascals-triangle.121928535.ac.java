class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> resultList = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        resultList.add(list);
        
        for(int i = 1; i < numRows; i++){
            LinkedList<Integer> tempList = (LinkedList<Integer>)resultList.get(i-1);
            int size = tempList.size();
            List<Integer> newList = new LinkedList<>();
            newList.add(1);
            for(int j = 0; j < size - 1; j = j+1){
                newList.add(tempList.get(j) + tempList.get(j+1));
            }
            newList.add(1);
            resultList.add(newList);
        }
        
        return resultList;
    }
}
