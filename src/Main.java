import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Location> works = new ArrayList<>();
        works.add(new Location(0,0));
        works.add(new Location(1,1));
        works.add(new Location(2,0));
        ArrayList<Location> bikes = new ArrayList<>();
        bikes.add(new Location(1,0));
        bikes.add(new Location(2,2));
        bikes.add(new Location(2,1));
        Solution1057 solution = new Solution1057(works,bikes);
        for (int i:solution.getPattern()){
            System.out.println(i);
        }

    }
}
