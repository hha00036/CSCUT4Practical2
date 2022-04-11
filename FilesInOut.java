import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.Scanner;
/**
*
* CSCU9T4 Java strings and files exercise.
*
*/
public class FilesInOut {
static private final int distenceOfDateFirstChar = 23;
private static String formatedText = "";
public static void main(String[] args) throws FileNotFoundException
{
// Replace this with statements to set the file name (input) and file name (output).
System.out.println("Enter the input file:");
Scanner inputFile = new Scanner(System.in);
File fileIn = new File(inputFile.next());
Scanner in = new Scanner(fileIn);



System.out.println("Enter the output file:");
Scanner outPutFile = new Scanner(System.in);
String fileName = outPutFile.next();



File fileOut = new File(fileName);
if(!fileOut.exists()){
System.out.println("invalid output file!!");
}



else if(fileOut.exists()) {



// Initially it will be easier to hardcode suitable file names.



// Set up a new Scanner to read the input file.



String format;
do{
System.out.println("chose the format: (t)for title case. (u)for upper case.");
Scanner inFormat = new Scanner(System.in);



format = inFormat.next();



if(format.equals("t"))
{
saveOutput(titleCase(in),fileName);
break;
}
else if(format.equals("u"))
{
saveOutput(upperCase(in),fileName);
break;
}
else System.out.println("invalid input choise!!");



}while(format !="t" ||format !="u") ;
System.out.println("successfully formated...");
}
// Processing line by line would be sensible here.
// Initially, echo the text to System.out to check you are reading correctly.





// Then add code to modify the text to the output format.




// Set up a new PrintWriter to write the output file.
// Add suitable code into the above processing (because you need to do this line by line also.
// That is, read a line, write a line, loop.




// Finally, add code to read the filenames as arguments from the command line.




//System.out.println("You need to add your own code to do anything");




} // main
public static String upperCase(Scanner in) {
// TODO Auto-generated method stub\



while(in.hasNextLine()) {
String temp="" ;
// first letter to upper
if(in.hasNext())
{
String name = in.next();
name = name.toUpperCase();
temp += name+" ";



name = in.next();
temp += name.toUpperCase();
if(name.length() == 1) {
temp+=". ";
name = in.next();
temp+= name.toUpperCase();
}



}



// setting space
int difference = distenceOfDateFirstChar-temp.length();
for(int i =1;i<difference;i++) {
temp+=" ";
}
//date format
String date =in.next();
temp+=date.substring(0,2)+"/"+date.substring(2,4)+"/"+date.substring(4,date.length()) +"\n";
formatedText = formatedText + temp;



}



return formatedText;
}





public static String titleCase(Scanner in) {
while(in.hasNextLine()) {
String temp="" ;
// first letter to upper case



//check for next
if(in.hasNext()) {
String name = in.next();
String firstLetter = name.substring(0, 1);
String remainder = name.substring(1,name.length());
name = firstLetter.toUpperCase()+remainder;
temp += name+" ";



name = in.next();
firstLetter = name.substring(0, 1);
remainder = name.substring(1,name.length());
name = firstLetter.toUpperCase()+remainder;
temp += name;



if(name.length() == 1) {
temp+=". ";
name = in.next();
temp+= name.toUpperCase();
}
}
// setting space
int difference = distenceOfDateFirstChar-temp.length();
for(int i =1;i<difference;i++) {
temp+=" ";
}
//date format
String date =in.next();
temp+=date.substring(0,2)+"/"+date.substring(2,4)+"/"+date.substring(4,date.length())+"\n";
formatedText = formatedText + temp;



}
return formatedText;
}




public static void saveOutput(String jsonObj, String filePath){
// write your code here
BufferedWriter writer = null;
try
{
writer = new BufferedWriter(new FileWriter(filePath));
writer.write(jsonObj);
writer.close();
}
catch(IOException e) {
e.printStackTrace();
}
}
} // FilesInOut