import java.util.HashMap;
import java.util.Map;

/**
 * 2019 12-12
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumAdd {
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] two=new int[2];
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){//for语句中第一步 int j  第二步判断J是不是满足条件 如果满足才进行下一步
                if ((nums[i]+nums[j])==target){
                    two[0]=i;
                    two[1]=j;
                    return two;
                }

            }
        }
        return null;
    }

    //利用map 先把数组放到map中  K为数 V为数的下标
    public static int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        int[] two = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<len;i++){
            map.put(nums[i],i);
        }
        for (int j=0;j<len;j++){
            int res=target-nums[j];
            //此api可以之久找到K有没有 想要的数, 后面是查询这个res是不是这个数本身
            if(map.containsKey(res)&&map.get(res)!=j){
                two[0]=j;
                two[1]=map.get(res);
                return two;
            }
        }
    return null;
    }


    public static void main(String[] args) {
        int[] prev={2,7,11,15};
        int[] result=twoSum2(prev,9);
        for (int i:result){
            System.out.println("数是"+prev[i]);
            System.out.println("他的下标是"+i);
        }

    }


}
