/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Lukas Bjørnvad
 */
public class Animal {
    String type;
    String sound;
    int birthYear;

    public Animal(String type, String sound, int birthYear) {
        this.type = type;
        this.sound = sound;
        this.birthYear = birthYear;
    }

    public Animal() {
    }
}
