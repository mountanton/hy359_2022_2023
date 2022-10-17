/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json_tester;

public class Person {
     String name;
     String work;
     int age;
     String city;
 
    // Creating toString
    @Override
    public String toString()
    {
        return "Name="
            + name
            + "\nwork="
            + work
                + "\ncity="
            + city
            + "\nage="
            + age + "";
    }
}