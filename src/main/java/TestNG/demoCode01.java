package TestNG;

public class demoCode01{
    public int doSum(int a, int b){
        int sum = a + b;
        if(sum > 100){
            System.out.println("OK");
        }
        else{
            System.out.println("Pending");
        }
        return sum;
    }
}
