public class Solution860 {
    private int allMoney;

    private int fiveDollar;

    private int tenDollar;

    private int twentyDollar;

    public Solution860(){
        this.allMoney = 0;
        this.fiveDollar = 0;
        this.tenDollar = 0;
        this.twentyDollar = 0;
    }

    /**
     * 按业务逻辑的方式编写，时间4-5ms，将逻辑放在同一方法，时间2ms
     */

//    public boolean lemonadeChange(int[] bills) {
//        int five = 0, ten = 0;
//        for (int bill: bills) {
//            if (bill == 5)
//                five++;
//            else if (bill == 10) {
//                if (five == 0) return false;
//                five--;
//                ten++;
//            } else {
//                if (five > 0 && ten > 0) {
//                    five--;
//                    ten--;
//                } else if (five >= 3) {
//                    five -= 3;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public boolean lemonadeChange(int[] bills) {
        for (int bill:bills){
            if (canTrade(bill)){
                chargeMoney(bill);
            }else {
                return false;
            }
        }
        return true;
    }

    private boolean canTrade(int bill){
        switch (bill){
            case 5:{
                return true;
            }

            case 10:{
                if (fiveDollar>0){
                    return true;
                }else {
                    return false;
                }
            }

            case 20:{
                if (fiveDollar>2||(fiveDollar>0&&tenDollar>0)){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    private void chargeMoney(int bill){
        switch (bill){
            case 5:{
                this.fiveDollar +=1;
                break;
            }
            case 10:{
                this.fiveDollar -=1;
                this.tenDollar +=1;
                break;
            }
            case 20:{
                if (fiveDollar>0&&tenDollar>0){
                    this.fiveDollar -=1;
                    this.tenDollar -=1;
                    this.twentyDollar +=1;
                    break;
                }
                if (fiveDollar>2&&tenDollar==0){
                    this.fiveDollar -=3;
                    this.twentyDollar +=1;
                    break;
                }
            }
        }
    }
}
