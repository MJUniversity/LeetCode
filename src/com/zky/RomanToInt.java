package com.zky;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuan
 * @date: 2023/1/18
 * Description: 罗马数字转整数，
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * *           通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 */

public class RomanToInt {
    /**
     * 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可。
     *
     * 例如 XXVII\texttt{XXVII}XXVII 可视作 X+X+V+I+I=10+10+5+1+1=27\texttt{X}+\texttt{X}+\texttt{V}+\texttt{I}+\texttt{I}=10+10+5+1+1=27X+X+V+I+I=10+10+5+1+1=27。
     *
     * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
     *
     * 例如 XIV\texttt{XIV}XIV 可视作 X−I+V=10−1+5=14\texttt{X}-\texttt{I}+\texttt{V}=10-1+5=14X−I+V=10−1+5=14。
     *
     */
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }



    /**
     * @author: yuan
     * @date: 2023/1/18 21:01
     * @param s
     * @return: int
     * @descipton: 其他精解
     */
    public static int romanToInt1(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            switch (c) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}



