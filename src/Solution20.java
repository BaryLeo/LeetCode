import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 待用更好的方法解决
 */
public class Solution20 {

    Stack<Character> characters = new Stack<>();

    Map<Character,Character> match = new HashMap<>();

    public Solution20(){
        match.put(')','(');
        match.put('}','{');
        match.put(']','[');
    }


    public boolean isValid(String s) {
        for (int i = 0;i<s.length();i++){
            if (!match.containsKey(s.charAt(i))){
                characters.add(s.charAt(i));
            }else {
                if (characters.isEmpty()){
                    return false;
                }else {
                    char temp = match.get(s.charAt(i));
                    if (temp != characters.pop()){
                        //匹配不上左右
                        return false;
                    }
                }

            }
        }

        if (characters.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
