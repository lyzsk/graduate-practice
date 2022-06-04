package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Leetcode0478 {
    private double xc;
    private double yc;
    private double radius;

    public Leetcode0478(double radius, double x_center, double y_center) {
        this.xc = x_center;
        this.yc = y_center;
        this.radius = radius;
    }

    public double[] randPoint() {
        double r = Math.sqrt(Math.random()) * radius;
        double angle = Math.random() * 2 * Math.PI;
        return new double[] {xc + r * Math.sin(angle), yc + r * Math.cos(angle)};
    }
}
