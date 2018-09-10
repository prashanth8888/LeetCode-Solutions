class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)) && (map.get(s.charAt(i)) == t.charAt(i))) {
                continue;
            }
            else if(!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                continue;
            }
            else
                return false;
        }
        return true;
    }
}
