import java.util.*;
/**
 * 在一个长度为n的数组nums里的所有数字都是在0~n-1的范围内，
 * 数组中某些数字事重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次
 * 请找出数组中任意一个重复的数字
 *
 */


public class FindRepeatNumber {
    /**
     * 法一：由于其只需要放回任意一个重复的数字，所以，采用HashSet结构
     * 其实质相当于是HashMap的Key部分。HashSet的add方法其内部调用了map.put()方法
     * public boolean add(E e) {
     *         return map.put(e, PRESENT)==null;
     * }
     *该方法的返回值是boolean，当map的key中没有相同元素时，将返回true（即添加成功）
     * 否则姜放回false，即存在相同元素，添加失败
     * 回到算法中来，此处就是靠着HashSet这一特性，如果添加失败了，则将添加失败的值赋值给repeat
     * 这个repeat就是一个重复的值
     */
    public int findRepeatNumber(int[] nums){
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for(int num : nums){
            if(!set.add(num)){
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 法二（执行不通过！！）：采用排序的方式，调用了Collections集合工具类，通过sort来进行排序
     *查看其前后两个元素是否相同即可得出结果(这里用i-1来做，是因为i+1会超过数组范围，报错：java.lang.IndexOutOfBoundsException)
     *
     * @param nums
     * @return 如果存在重复则返回重复值，否则返回-1
     */

    public int findRepeatNumber2(int[] nums){
        List<Integer> list = new ArrayList<>();
        int res = -1;
        for(int num:nums){
            list.add(num);
        }
        Collections.sort(list);
        for(int i = 1;i<list.size();i++){
            if(list.get(i)==list.get(i-1)){
               res =  list.get(i);
               break;
            }
        }
        return res;


    }

    /**法三：通过Arrays来排序
     *
     */
        public int findRepeatNumber3(int[] nums) {
            Arrays.sort(nums);
            int res = -1;
            for(int i = 1;i<nums.length;i++){
                if(nums[i] == nums[i-1]){
                    res = nums[i];
                    break;
                }
            }
            return res;
        }

}

