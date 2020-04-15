/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;


/**
 *
 * @author Logan Conley
 */
public class Complex {
    
    double r;
    double i;
    
    Complex() {
        
    } //Complex()
    
    Complex(int xReal, int yImaginary) {
        
        r = xReal;
        i = yImaginary;
    } //Complex(int, int)
    
    public static Complex addComplex(Complex comp1, Complex comp2) {
        
        Complex result = new Complex();
        
        result.r = comp1.r + comp2.r;
        result.i = comp1.i + comp2.i;
        
        return result;
    } //addComplex(Complex, Complex)
    
    public static Complex subComplex(Complex comp1, Complex comp2) {
        
        Complex result = new Complex();
        
        result.r = comp1.r - comp2.r;
        result.i = comp1.i - comp2.i;
                
        return result;
    } //subComplex(Complex, Complex)
    
    public static Complex multComplex(Complex comp1, Complex comp2) {
        
        Complex result = new Complex();
        
        result.r = (comp1.r * comp2.r) - (comp1.i * comp2.i);
        result.i = (comp1.r * comp2.i) + (comp1.i * comp2.r);
        
        return result;
    } //multComplex(Complex, Complex)
    
    public static Complex divComplex(Complex comp1, Complex comp2) {
        
        Complex result = new Complex();
        
        result.r = ((comp1.r * comp2.r) + (comp1.i * comp2.i)) / ((comp2.r * comp2.r) + (comp2.i * comp2.i));
        result.i = ((comp1.i * comp2.r) - (comp1.r * comp2.i)) / ((comp2.r * comp2.r) + (comp2.i * comp2.i));
        
        return result;
    } //divComplex(Complex, Complex)
    
    public static double magComplex(Complex comp) {
        
        double tempR = (comp.r * comp.r);
        double tempI = (comp.i * comp.i);
        double result = (tempR + tempI);
        
        result = (int) Math.sqrt(result);
        
        return result;        
    } //magComplex(complex)
    
    public static void printComplex(Complex comp) {
        
        if (comp.i < 0) {
            System.out.println(comp.r + " - " + Math.abs(comp.i) + "i");
        } //if
        
        if (comp.i >= 0) {
            System.out.println(comp.r + " + " + comp.i + "i");
        } //if
    } //printComplex(complex)   
} //Complex
