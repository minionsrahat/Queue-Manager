/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projectdemo;

import java.util.Scanner;

/**
 *
 * @author KOCHI
 */
public class regex {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str;
        str=in.nextLine();
        if(!str.matches("^[A-Za-z][A-Za-z][A-Za-z0-9]*(?:_[A-Za-z0-9]+)*$"))
        {
            System.out.println("enter valid name");
        }
    }
    
}
