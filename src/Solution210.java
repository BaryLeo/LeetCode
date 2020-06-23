import java.util.*;

/**
 * 有向图的拓补排序
 * 深度优先遍历，或者广度优先遍历
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses==0){
            return new int[]{};
        }

        int[] res = new int[numCourses];

        //第一个代表哪个课，第二个是next
        int[] inDegree = new int[numCourses];

        //计算入读
        for (int i =0;i<prerequisites.length;i++){
            //被指向的点，度+1
            int c = prerequisites[i][0];
            //下标
            inDegree[c]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        //入度为0的先入队
        for (int i =0;i<numCourses;i++){
            if (inDegree[i]==0){
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int index = queue.poll();
            res[count] = index;
            for (int[] ar:prerequisites){
                if (ar[1]==index){
                    if (inDegree[ar[0]]>0){
                        --inDegree[ar[0]];
                        if (inDegree[ar[0]]==0){
                            queue.offer(ar[0]);
                        }
                    }
                }
            }
            count++;
        }

        if (count<numCourses-1){
            return new int[]{};
        }
        return res;
    }
}