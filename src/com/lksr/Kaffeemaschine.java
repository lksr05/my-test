package com.lksr;

public class Kaffemaschine{
    public static void main(String[]args){

     int[] füllwert = {248,249,251,247,250,252,246,248,249,250};
     int sum = 0;
     int highestvalue = 0;
     int lowestvalue = 1000;
     for (int i=0; i<füllwert.length; i++){
         sum = sum + füllwert[i];
         if (füllwert[i]>=highestvalue){
             highestvalue = füllwert[i];
         }
         if (füllwert[i]<=lowestvalue){
             lowestvalue = füllwert[i];
         }
     }
     double avg = sum/füllwert.length;   
     System.out.println("Höchster Wert: "+ highestvalue);
     System.out.println("Niedrigster Wert: "+ lowestvalue);
     System.out.println("Average: "+avg);
     System.out.println("Summe: "+sum);
    }
    
}