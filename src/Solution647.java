public class Solution647 {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        char[] charArray = s.toCharArray();
        for (int j = 0; j < len; j++){
            for (int i = 0; i <= j; i++){
                if (j == i && charArray[j] == charArray[i]){
                    dp[i][j] = true;
                    count++;
                }else if (j - i == 1 && charArray[i] == charArray[j]){
                    dp[i][j] = true;
                    count++;
                }else if (j - i > 1 && dp[i + 1][j - 1] && charArray[i] == charArray[j]){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
