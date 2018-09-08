class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<>();
        dfsHelper(s, solutions,0,"",0);
        return solutions;
        
    }
    
    public void dfsHelper(String ip, List<String> solutions, int idx, String restoreString, int count){
        if(count > 4) return;
        if(count == 4 && idx == ip.length()) solutions.add(restoreString);
        
        for(int i = 1; i < 4; i++){
            if(idx + i > ip.length()) break;
            String s= ip.substring(idx, idx+i);
            //Only if i == 3 - Then the combination of substring will go beyond 256
            if((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) continue; 
            dfsHelper(ip, solutions, idx+i, restoreString+s+(count == 3 ?"":"."), count + 1);
        }
    }

    
}
