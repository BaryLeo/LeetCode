import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main m= new Main();
        System.out.println(m.isValid("()[{}"));
    }

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
