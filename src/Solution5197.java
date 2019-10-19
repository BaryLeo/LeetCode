import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution5197 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> pairs = new ArrayList<>();

        int minLun = Integer.MAX_VALUE;

        for (int i =0;i<arr.length;i++){
            for (int x = i+1;x<arr.length;x++){
                List<Integer> miniIntPair = new ArrayList<>();
                int endNum =  arr[i]-arr[x];

                if (Math.abs(endNum)<minLun){
                    minLun = Math.abs(arr[i]-arr[x]);
                    if (endNum<0){
                        miniIntPair.add(Integer.valueOf(arr[i]));
                        miniIntPair.add(Integer.valueOf(arr[x]));
                    }else {
                        miniIntPair.add(Integer.valueOf(arr[x]));
                        miniIntPair.add(Integer.valueOf(arr[i]));
                    }

                    pairs.clear();
                    pairs.add(miniIntPair);
                }else if (Math.abs(endNum)==minLun){

                    if (endNum<0){
                        miniIntPair.add(Integer.valueOf(arr[i]));
                        miniIntPair.add(Integer.valueOf(arr[x]));
                    }else {
                        miniIntPair.add(Integer.valueOf(arr[x]));
                        miniIntPair.add(Integer.valueOf(arr[i]));
                    }

                    pairs.add(miniIntPair);
                }
            }
        }


        for (int i=0;i<pairs.size();i++){
            for (int x = 0;x<pairs.size();x++){
                if (pairs.get(i).get(0)-pairs.get(x).get(0)<0){
                    List<Integer> temp = pairs.get(i);
                    pairs.set(i,pairs.get(x));
                    pairs.set(x,temp);
                }
            }
        }
        return pairs;
    }
}
