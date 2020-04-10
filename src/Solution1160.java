public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int[] arg = new int[26];
        for (int i =0;i<chars.length();i++){
            arg[chars.charAt(i)-'a']++;
        }

        int result = 0;

        a:for (String word:words){
            if (word.length()<=chars.length()){
                int[] letters = new int[26];
                for (int i = 0;i<word.length();i++){
                    int index  = word.charAt(i)-'a';
                    letters[index]++;
                    if (arg[index]<letters[index]){
                        continue  a;
                    }
                }
                result +=word.length();
            }
        }

        return result;
    }
}
