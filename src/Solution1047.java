public class Solution1047 {
    public String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        int i = -1;
        if(s.length==1){
            return S;
        }

        /**
         * 只对同一数组进行操作，减少大量时间
         */
        for(Character c:s){
            if(i>=0&&s[i]==c) {
                i--;
            }else {
                s[++i]=c;
            }
        }
        return String.valueOf(s,0,i+1);
    }
}
