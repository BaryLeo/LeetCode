package leetcode;

public class Offer43 {

    public static void main(String[] args) {
        System.out.println(multi("100","21"));
    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }


    public static String multi(String num1, String num2){
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        int[] res = new int[(num1.length()+num2.length())];
        for (int i=num1.length()-1;i>=0;i--){
            int n1 = c1[i]-'0';
            for (int j = num2.length()-1;j>=0;j--){
                int n2 = c2[j]-'0';
                int sum = res[i+j+1]+n1*n2;
                res[i+j+1] = sum %10;
                res[i+j] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<res.length;i++){
            if (i == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
