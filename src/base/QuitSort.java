package base;

/**
 * 快排，基础知识
 */
public class QuitSort {

    public void sort(int[] ar){
        sorting(ar,0,ar.length-1);
    }

    private void sorting(int[] ar,int begin,int end){
        if (begin==end){
            return;
        }

        int pivot = ar[end];
        //慢指针始终指向比pivot小的数
        int slow =begin-1;
        int fast =begin;
        for (;fast<end+1;fast++){
            if (ar[fast]<=pivot){
                slow++;
                int temp = ar[fast];
                ar[fast] = ar[slow];
                ar[slow] = temp;
            }
        }

        for (int i:ar){
            System.out.print(i+" ");
        }

        System.out.println();
        sorting(ar,begin,slow-1);
        sorting(ar,slow,end);
    }
}
