/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author 729347
 */
public class Power {

    private static double base = 0.0;
    private static double answer = 0.0;
    private static double y = 0.0;

    public double calculatePower(double base, double y) {
        return Math.pow(base, y);
    }
}
