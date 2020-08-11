package exam;

public class MST01P06 {
    public String compressString(String S) {
        if (S.length()==0){
            return S;
        }

        int count = 0;

        //将String拼接操作转换为Srting容器拼接，效率从184ms升级到46ms
        StringBuilder result = new StringBuilder();

        //将分解为字符串数组改为char数组，效率从46ms->8ms
        char[] ar = S.toCharArray();

        char curr = ar[0];
        for (int i = 0;i<S.length();i++){
            if (ar[i]==curr){
                count++;
            }else{
                result.append(curr).append(count);
                curr = ar[i];
                count = 1;
            }

            if (i==S.length()-1){
                result.append(curr).append(count);
            }
        }

        //有测试用例bb，结果输出要求为bb
        if (result.length()>=S.length()){
            return S;
        }else {
            return result.toString();
        }
    }
}
