/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."

 */
public class ReplaceSpace {
    /**
     * 直接使用String的replace方法
     * @param s
     * @return
     */
    public String replaceSpace(String s){
        String newString = s.replace(" ","%20");
        return newString;
    }
    /**
     * 自己写
     */
    public String replaceSpace2(String s){
        String newString = null;
        int length = s.length();
        int size = 0 ;
        char[] arr = new char[length*3];
        for(int i =0;i < length; i++){
            char c = s.charAt(i);
            if(c == ' ' ){
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            }
            else {
                arr[size++] = c;
            }
        }
        return new String(arr,0,size);
    }
}
