package io.kidlovec.lc.question;

/**
 * //【程序2】   题目：判断101-200之间有多少个素数，并输出所有素数。
 * //
 * //1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
 * //
 * //则表明此数不是素数，反之是素数。
 *
 * @author kidlovec
 * @date 2019-08-22
 * @since v1.0.0
 */
public class exp2{
    public static void main(String[] args){
        int i=0;
        int size = 200;
        int[] array = new int[size];

        for(i=1;i<=size;i++)
            array[i - 1] = i;

        PrimeNumber pm = new Math1();

        final int[] solve = pm.solve(array);

        for(i=1;i<=200;i++){
            System.out.println(solve[i - 1]);
        }
    }

}

 interface PrimeNumber {
    int[] solve(int[] array);
}

class Math1 implements PrimeNumber{
    @Override
    public int[] solve(int[] array) {
        int[] result = new int[array.length];
        int count = 0;
        for (int i : array) {
            result[count++] = f(i);
        }
        return result;
    }

    private int f(int x)
    {
        if(x==1 || x==2)
            return 1;
        else
            return f(x-1)+f(x-2);
    }
}

class Math2 implements PrimeNumber{

    @Override
    public int[] solve(int[] array) {
        int[] result = new int[array.length];
        int count = 0;
        for (int i : array) {
            if (isPrimeNumber(i)) {

                result[count++] = i;
            }
        }
        return result;
    }

    private boolean isPrimeNumber(int x) {
        for(int i=2;i<=x/2;i++)
            if (x % 2==0 )
                return false;
        return true;
    }
}
