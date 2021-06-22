import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();

        int[] nums = {2,3,1,0,2,3,6};
        //int repeat = findRepeatNumber.findRepeatNumber(nums);
        int repeat = findRepeatNumber.findRepeatNumber2(nums);
        if(repeat==-1){
            System.out.println("无重复数字");
        }
        else{
            System.out.println("重复的数字是:"+ repeat);
        }
    }
}
