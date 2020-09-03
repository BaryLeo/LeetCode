import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n==0){
            return res;
        }

        find(res,n,n,"");
        return res;
    }

    public void find(List<String> res,int left,int right,String cur){
        if (left==0&&right==0){
            res.add(cur);
            return;
        }

        //剪枝
        if (left>right){
            return;
        }
        if (left>0){
            find(res,left-1,right,cur+"(");
        }

        if (right>0){
            find(res,left,right-1,cur+")");
        }

    }
}
