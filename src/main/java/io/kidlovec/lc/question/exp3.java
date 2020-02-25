package io.kidlovec.lc.question;

/**
 * 题目：打印出所有的 "水仙花数 "，
 * 所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153 是一个 "水仙花数 "，因为153=1的三次方 ＋5 的三次方 ＋3 的三次方。
 *
 * @author kidlovec
 * @date 2019-08-22
 * @since v1.0.0
 */
public class exp3 {

    int size = 200;

    public static void main(String[] args) {

        int[] array = init();

        NarcissusNumber x = new Method1();
        final int[] solve = x.solve(array);
        print(solve);
    }

    private static void print(int[] solve){
        int count = 0;
        for (int i : solve) {
            count ++;

            System.out.print(String.format("%5d ", i));
            if (count % 10 == 0){
                System.out.println();
            }
        }
    }

    private static int[] init(){
        int size = 200;
        int[] array = new int[size];

        for(int i=1;i <= size;i++) {
            array[i - 1] = i;
        }

        return array;
    }
}

class Method1 implements NarcissusNumber {

    @Override
    public int[] solve(int[] array) {
        int[] result = new int[array.length];
        int count = 0;
        for (int i : array) {
            if (f(i)){
                result[count] = i;
                count ++;
            }
        }


        return result;
    }

    private boolean f(int i) {
        int hundreds = i / 100;
        int decade = (i - hundreds * 100) / 10;
        int units = i % 10;
        final boolean b = i == (hundreds * hundreds + decade * decade + units * units);

        if (b){

            System.out.println(String.format(" %5d , %5d , %5d , %b"
                    , hundreds
                    , decade
                    , units
                    , b));
        }
        return b;
    }



}




interface NarcissusNumber {
    int[] solve(int[] array);
}