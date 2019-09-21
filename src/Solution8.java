public class Solution8 {
    public int myAtoi(String str) {
        str = str.trim();
        int maxLen = 10;
        boolean isAdd = false;

        if (str.charAt(0)=='-'){
            maxLen++;
            if (str.charAt(1)>'9'||str.charAt(1)<'0'){
                return 0;
            }

        }else if (str.charAt(0)=='+'){
            maxLen++;
            isAdd=true;
            if (str.charAt(1)>'9'||str.charAt(1)<'0'){
                return 0;
            }
        }else if (str.charAt(0)>'9'||str.charAt(0)<'0'){
            return 0;
        }

        if (str.length()>maxLen){
            if (isAdd){
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }

        if (str.charAt(0)=='-'){
            if (str.length()==11){
                if (canToi(str,Integer.MIN_VALUE)){
                    return Integer.valueOf(str);
                }else {
                    return Integer.MIN_VALUE;
                }
            }else {
                return Integer.valueOf(str);
            }
        }

        if (str.length()==10){
            if (canToi(str,Integer.MAX_VALUE)){
                return Integer.valueOf(str);
            }else {
                return Integer.MAX_VALUE;
            }
        }else {
            return Integer.valueOf(str);
        }
    }

    private boolean canToi(String str,int value){
        char[] strc=str.toCharArray();
        char[] minc = String.valueOf(value).toCharArray();
        int index = 0;
        for (char c:strc){
            if (c > minc[index]){
                return false;
            }
        }
        return true;
    }


}
