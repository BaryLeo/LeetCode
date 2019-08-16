package T1047;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public String removeDuplicates(String S) {
        ArrayList<Character> characters  = new ArrayList<>();
        for (int i = 0;i<S.length();i++){
            if (characters.isEmpty()){
                characters.add(S.charAt(i));
            }else {
                if (characters.get(characters.size()-1).equals(S.charAt(i))){
                    characters.remove(characters.size()-1);
                }else {
                    characters.add(S.charAt(i));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character:characters){
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
