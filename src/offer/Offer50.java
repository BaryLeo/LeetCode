package offer;

public class Offer50 {
    public char firstUniqChar(String s) {
        char[] ar = new char[26];
        for (char ch:s.toCharArray()){
            ar[ch-'a']++;
        }

        for (char ch:s.toCharArray()){
            if (ar[ch-'a']==1){
                return ch;
            }
        }
        return ' ';
    }
}
