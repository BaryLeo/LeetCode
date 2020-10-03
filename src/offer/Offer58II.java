package leetcode;

public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n;i<s.length();i++){
            sb.append(cs[i]);
        }
        for (int i = 0;i<n;i++){
            sb.append(cs[i]);
        }
        return sb.toString();
    }
}
