import java.util.List;

public class Solution1057 {

    private int[] workerStatus;

    private int[] bikeStatus;

    private Node[][] arr;

    private List<Location> worker;

    private List<Location> bikes;

    public Solution1057(List<Location> worker,List<Location> bikes){
        //单车与工人的坐标
        this.worker = worker;
        this.bikes = bikes;

        //单车与工人的状态
        workerStatus = new int[worker.size()];
        bikeStatus = new int[bikes.size()];

        //采用散列表方式，每个工人对应一个桶，将桶中单车根据距离由小到大排序
        //node记录单车距离和单车编号
        arr = new Node[worker.size()][bikes.size()];

        //初始化单车和工人状态
        for (int i = 0;i<workerStatus.length;i++){
            workerStatus[i] = -1;
        }
        for (int i = 0;i<bikeStatus.length;i++){
            bikeStatus[i] = -1;
        }
    }

    public int[] getPattern(){
        for (int i = 0;i<worker.size();i++){
            //求出工人匹配所有单车的距离
            for (int j = 0;j<bikes.size();j++){
                //记录单车距离和单车编号
                //第一个参数为距离，第二个参数为单车编号
                arr[i][j]=new Node(getDistance(worker.get(i),bikes.get(j)),j);
            }
        }

        //排序每个工人的所有单车距离，由小到大，每个桶都进行了排序
        for (int i = 0;i<arr.length;i++){
            arr[i] = quickSort(arr[i],0,arr.length-1);
        }


        for (int i = 0;i<workerStatus.length;i++){
            for (int j = 0;j<bikeStatus.length;j++){
                //当工人状态已经有单车时，跳过此循环
                //当单车状态为已占用时，不断循环找到下一辆车
                //工人为X，车为Y，可以不满足满射要求
                if ((workerStatus[i] != -1)|| bikeStatus[j]==1){
                    continue;
                }
                //j为单车编号
                workerStatus[i] = arr[i][j].getBikeNum();
                //修改单车状态为占用
                bikeStatus[j] = 1;
            }
        }

        return workerStatus;
    }


    private int getDistance(Location worker,Location bike){
        //求曼哈顿距离
        return Math.abs(worker.getX()-bike.getX())+Math.abs(worker.getY()-bike.getY());
    }

    /**
     * 修改版快速排序,快速排序使用分治法，修改版只交换Node元素位置，但是是用Node元素中的distance排序
     * @param ar
     * @param left
     * @param right
     * @return
     */
    private Node[] quickSort(Node[] ar,int left,int right){
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return ar;
        }
        //设置最左边的元素为基准值
        Node key=ar[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(ar[j].getDistance()>=key.getDistance() && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(ar[i].getDistance()<=key.getDistance() && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                Node temp=ar[i];
                ar[i]=ar[j];
                ar[j]=temp;
            }
        }

        ar[left]=ar[i];
        ar[i]=key;
        quickSort(ar,left,i-1);
        quickSort(ar,i+1,right);
        return ar;
    }
}

class Node{
    private int distance;

    //单车编号
    private int bikeNum;

    public Node(int distance, int bikeNum) {
        this.distance = distance;
        this.bikeNum = bikeNum;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getBikeNum() {
        return bikeNum;
    }

    public void setBikeNum(int bikeNum) {
        this.bikeNum = bikeNum;
    }
}
class Location{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}