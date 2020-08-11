import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 没有遇到空字符的样例，如果是空字符，不入队即可
 */
public class Solution20 {
    public boolean isValid(String s) {
        LinkedList<Character> characters = new LinkedList<>();
        char[] cs = s.toCharArray();
        for (int i = 0;i<cs.length;i++){
            if (characters.isEmpty()){
                characters.addLast(cs[i]);
            }else {
                if (isPair(characters.peekLast(),cs[i])){
                    characters.pollLast();
                }else {
                    characters.addLast(cs[i]);
                }
            }
        }
        return characters.isEmpty();
    }

    private boolean isPair(char a,char b){
        int count = a-b;
        return count==1|count==2||count==-1||count==-2;
    }
}
