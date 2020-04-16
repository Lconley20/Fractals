/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;


public class Complex {
    
    double r;
    double i;
    
    Complex() {
        
    } //Complex()
    
    Complex(double xReal, double yImaginary) {
        
        r = xReal;
        i = yImaginary;
    } //Complex(int, int)
    
    public Complex addComplex(Complex comp) {
        
        Complex result = new Complex();
        
        result.r = this.r + comp.r;
        result.i = this.i + comp.i;
        
        return result;
    } //addComplex(Complex, Complex)
    
    public Complex subComplex(Complex comp) {
        
        Complex result = new Complex();
        
        result.r = this.r - comp.r;
        result.i = this.i - comp.i;
                
        return result;
    } //subComplex(Complex, Complex)
    
    public Complex multComplex(Complex comp) {
        
        Complex result = new Complex();
        
        result.r = (this.r * comp.r) - (this.i * comp.i);
        result.i = (this.r * comp.i) + (this.i * comp.r);
        
        return result;
    } //multComplex(Complex, Complex)
    
    public Complex divComplex(Complex comp) {
        
        Complex result = new Complex();
        
        result.r = ((this.r * comp.r) + (this.i * comp.i)) / ((comp.r * comp.r) + (comp.i * comp.i));
        result.i = ((this.i * comp.r) - (this.r * comp.i)) / ((comp.r * comp.r) + (comp.i * comp.i));
        
        return result;
    } //divComplex(Complex, Complex)
       
    public double sqrMagComplex() {
        
        double tempR = (this.r * this.r);
        double tempI = (this.i * this.i);
        double result = (tempR + tempI);
        
        return result;
    } //sqrMagComplex(Complex)
    
    public double magComplex() {

        double result = this.sqrMagComplex();
        result = Math.sqrt(result);

        return result;        
    } //magComplex(complex)
    
    public void printComplex() {
        
        if (this.i < 0) {
            System.out.println(this.r + " - " + Math.abs(this.i) + "i");
        } //if
        
        if (this.i >= 0) {
            System.out.println(this.r + " + " + this.i + "i");
        } //if
    } //printComplex(complex)   
} //Complex
