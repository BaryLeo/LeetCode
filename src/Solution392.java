/**
 * 贪心算法，无后效性
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        //s to match t
        //t is source
        if (s.length()>t.length()){return false;}
        if (s.length()==0){return true;}
        int sIndex = 0;
        for (int i=0;i<t.length();i++){
            if (s.charAt(sIndex)==t.charAt(i)){
                sIndex++;
                if (sIndex>=s.length()){
                    return true;
                }
            }
        }

        return false;
    }
}
