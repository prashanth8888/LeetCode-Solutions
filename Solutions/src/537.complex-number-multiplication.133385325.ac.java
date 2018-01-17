class Solution {
    public String complexNumberMultiply(String a, String b) {
        
        String[] A = a.split("\\+");
        String[] B = b.split("\\+");
        
        
        int a1 = Integer.parseInt(A[0]);
        int b1 = Integer.parseInt(A[1].replaceAll("i", ""));
        
        int a2 = Integer.parseInt(B[0]);
        int b2 = Integer.parseInt(B[1].replaceAll("i", ""));
        
        int a1a2 = a1 * a2;
        int b1b2 = b1 * b2;
        
        int a1b2a2b1 = (a1 * b2) + (a2 * b1);
        
        String absolutePartFinal = (a1a2 + (-1) * b1b2) + "";
        String complexFinal = a1b2a2b1 + "i";
        
        return absolutePartFinal + "+" + complexFinal;
        
        
        
        
    }
}
