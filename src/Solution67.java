public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        if (a.length()<b.length()){
            String temp = a;
            a = b;
            b = temp;
        }

        //余数
        int cf =0;
        int i =b.length()-1;
        int ai = a.length()-1;
        for (;i>=0;i--,ai--){
            int x = a.charAt(ai)-'0';
            int y = b.charAt(i)-'0';
            cf = x+y+cf;
            //求模可得当前位的结果
            result.append((cf)%2);
            //除一次后，相当于 除掉当前位，并且减去求模结果
            cf  = cf/2;
        }
        //清除剩余位
        while (ai>=0){
            int x = a.charAt(ai)-'0';
            cf = x+cf;
            //求模可得当前位的结果
            result.append((cf)%2);
            //除一次后，相当于 除掉当前位，并且减去求模结果
            cf  = cf/2;
            --ai;
        }

        if (cf>0){
            result.append("1");
        }
        return result.reverse().toString();
    }
}
