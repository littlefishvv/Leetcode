import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();
        while (scan.hasNextLine()) {
            //得到每个数组

            list.add(scan.nextLine());

        }
        for (int i=0;i<list.size();i++){

        }
        String[] nums = list.get(1).split(" ");


        int len = nums.length;
        int count = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (Integer.parseInt(nums[j]) > Integer.parseInt(nums[i])) count++;
            }
        }
        // sort(arrs,0,arrs.length-1);
        System.out.println(count);
    }*/


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String[] nums = scan.nextLine().split(" ");
            int sum = 0;
            for(String num_s: nums){
                sum += Integer.parseInt(num_s);
            }
            System.out.println(sum);
        }
    }
}
