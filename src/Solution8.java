public class Solution8 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length()==0){
            return 0;
        }

        char[] chars = str.toCharArray();
        //默认为正数
        int flag = 1;

        //设置循环计数器
        int i =0;
        if (chars[0]=='-'){
            flag = -1;
            i=1;
        }else if (chars[0]=='+'){
            i=1;
        }

        long res = 0;
        for (;i<chars.length;i++){

            if (chars[i]>='0'&&chars[i]<='9'&&res<Integer.MAX_VALUE){
                //进位后个位
                res = res*10+chars[i]-'0';
            }else {
                break;
            }
        }
        res = res*flag;
        if (res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (res<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)res;
    }
}
