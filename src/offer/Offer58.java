package leetcode;

public class Offer58 {
    public String reverseWords(String s) {
        String[] temp = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length-1;i>=0;i--){
            sb.append(temp[i]);
            if (i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
