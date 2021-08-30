package io.kidlovec;

/**
 * @author kidlovec
 * @date 2020-03-11
 * @since 1.0.0
 */
public class Main {


    private static final String ST = "/problems/";
    public static void main(String[] args) {
        String str;
//        str = "https://leetcode-cn.com/problems/majority-element/";
//        str = "https://leetcode-cn.com/problems/longest-increasing-subsequence/";

//        str = "https://leetcode-cn.com/problems/majority-element-ii/";
//        str = "https://leetcode-cn.com/problems/longest-increasing-subsequence/";
//        str = "max-area-of-island";

        str = "https://leetcode-cn.com/problems/median-of-two-sorted-arrays//";

        System.out.println(changeName(str));
        System.out.println();
    }

    private static String changeName(String str) {

        if (str.indexOf(ST) > 0){

            str = str.substring(str.indexOf(ST) + ST.length()).replaceAll("/","");
        }
        final String[] split = str.split("\\-");

        System.out.println();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            if (i != 0){

                sb.append(split[i].substring(0, 1).toUpperCase());
                sb.append(split[i].substring(1));
            } else {
                sb.append(split[i]);
            }

        }


        return sb.toString();
    }
}
