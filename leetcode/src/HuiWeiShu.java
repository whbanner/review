/**
 * 2019 12-14
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HuiWeiShu {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if (x<=9){ //要考虑0的情况 不然 len/2=0 直接不进入for循环了  单数都是
            return true;
        }else{
            String str=String.valueOf(x);
            int len = str.length();
            //单数 eg：5/2 =2  1,2   4,5比  双数/2  12  34比
            int temp=len;
            for(int i=0;i<len/2;i++){
                if(str.charAt(i)!=str.charAt(temp-1)){
                    return false;
                }
                temp=temp-1;
//                return true;//这里不能return 不然只要一次匹配对 都会返回true
            }
            return true;
        }
    }

    /**
     * 官网解题
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x){
        //最后一位数不能为0 除0以外
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }else {
            int temp=0;
            //将后一半倒过来
            // 如12321  12321%10=1拿到倒数第一个   12321/10%10=2倒数第二个
            // 1*10+2=12  如何判断转了一半 当转的数大于等于x的前一半即可

            while (temp<x){
                temp=temp*10+x%10;
                x=x/10;
            }
            //如果是奇数直接除10与之前比较
            return temp/10==x||temp==x;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new HuiWeiShu().isPalindrome(1000030001));

    }

}
