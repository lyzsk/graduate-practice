package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.SolBase;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class CodeTop0058 extends SolBase {
    /**
     * (randX() - 1) * Y + randY() 可以等概率的生成[1, X * Y]范围的随机数;
     * <p>
     * 如果生成数在 40 内，直接返回， 如果刚才生成的数在 41~49 之间，利用随机数再操作一遍;
     * <p>
     * 如果生成数再 60 内，直接返回， 如果刚才生成的数在 61~63 之间, 利用随机数再操作一遍
     * <p>
     * 原始思路是: 舍弃[41, 49] 之间的数，因为是独立事件，生成 [1, 40] 之间的数是等概率的，利用 [1, 40] 之间的数来得到 [1, 10] 之间的数
     * <p>
     * 原始思路代码:
     * <p>
     * {@code int num = (rand7() - 1) * 7 + rand7（）；} <br>
     * {@code while (num > 40) num = (rand7() - 1) * 7 + rand7(); }<br>
     * {@code return 1 + num % 10;}
     * 
     * @return
     */
    public int rand10() {
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 40) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return 1 + num % 10;
    }
}
