import java.util.HashMap;

public class Solution242 {

    /**
     * 优化版本
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }

        int count[] = new int[26];

        for (int i = 0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }


        for (int i:count){
            if (i!=0){
                return false;
            }
        }

        return true;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }

        HashMap<Character,Integer> msg = new HashMap<>();

        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (msg.containsKey(c)){
                Integer integer = msg.get(c);
                integer++;
                msg.replace(c,integer);
            }else {
                msg.put(c,1);
            }
        }

        for (int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            if (msg.containsKey(c)){
                Integer integer = msg.get(c);
                integer--;
                if (integer<0){
                    return false;
                }
                msg.replace(c,integer);
            }else {
                return false;
            }
        }

        return true;
    }
}
