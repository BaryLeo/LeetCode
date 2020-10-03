package leetcode;

public class Solution415 {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        //a的长度比b的长
        char[] a =num1.toCharArray();
        char[] b = num2.toCharArray();
        int up = 0,i = a.length-1,j=num2.length()-1;
        while (i>=0||j>=0||up!=0){
            if (i>=0){
                up += a[i--]-'0';
            }

            if (j>=0){
                up += b[j--]-'0';
            }

            sb.append(up%10);
            //要是有进位，肯定只能是1，所以除10即可
            up /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123456789", "987654321"));
    }
}
