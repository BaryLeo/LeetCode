package array_linklist;

import java.util.*;

public class Solution20 {

    int pairA = Math.abs('('-')');
    int pairB = Math.abs('['-']');
    int pairC = Math.abs('{'-'}');

    LinkedList<Character> characters = new LinkedList<>();

    public boolean isValid(String s) {
        char[] ar = s.toCharArray();
        for (char c:ar){
            if (characters.isEmpty()){
                characters.add(c);
            }else {
                char check = characters.peekLast();
                if (isPair(c,check)){
                    characters.pollLast();
                }else {
                    characters.add(c);
                }
            }
        }

        return characters.isEmpty();
     }

    boolean isPair(char a , char b){
        int check = Math.abs(a-b);
        return check==pairA||check==pairB||check==pairC;
    }
}
