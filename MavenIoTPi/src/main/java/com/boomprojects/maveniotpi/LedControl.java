/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boomprojects.maveniotpi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author CBoom (cboom.trf@gmail.com)
 */
public class LedControl {
	
    public static void main(String[] args) throws InterruptedException {
    	
        // get a handle to the GPIO controller
    	final GpioController gpio = GpioFactory.getInstance();
        
        // creating the pin with parameter PinState.HIGH
        // will instantly power up the pin
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "PinLED", PinState.HIGH);
        System.out.println("light is: ON");
        
        // wait 2 seconds
        Thread.sleep(2000);
        
        // turn off GPIO 1
        pin.low();
        System.out.println("light is: OFF");
        // wait 1 second
        Thread.sleep(1000);
        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
        pin.pulse(1000, true);
        
        // release the GPIO controller resources
        gpio.shutdown();
    }
}