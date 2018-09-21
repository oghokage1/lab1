// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

/**
 * EDITED BY AISHA KHALID AND YUSRA ADINOYI
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTestQ4
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in three ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {

    PointD6 pointD6=null;
    PointCPD2 pointPolar=null;
    PointCPD3 pointCartesian=null;
    int design;
    
    System.out.println("Design Checker Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.
    try
    {
      if(args[0]=="2"){
         pointPolar = new PointCPD2( Double.valueOf(args[1]).doubleValue(), 
        Double.valueOf(args[2]).doubleValue());
        design=2;
      }
      if(args[0]=="3"){
         pointCartesian = new PointCPD3( Double.valueOf(args[1]).doubleValue(), 
        Double.valueOf(args[2]).doubleValue());
        design=3;
      }
      else{
         pointD6=new PointPolarD6(Double.valueOf(args[1]).doubleValue(), 
        Double.valueOf(args[2]).doubleValue());
        design=6;
      }
     
    }
    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        double[] info= getInput();
        if(info[0]==2){
           pointPolar = new PointCPD2( Double.valueOf(info[1]).doubleValue(), 
          Double.valueOf(info[2]).doubleValue());
          design=2;
        }
        if(info[0]==3){
           pointCartesian = new PointCPD3( Double.valueOf(info[1]).doubleValue(), 
          Double.valueOf(info[2]).doubleValue());
          design=3;
        }
        else{
           pointD6=new PointPolarD6(Double.valueOf(info[1]).doubleValue(), 
          Double.valueOf(info[2]).doubleValue());
          design=6;
        }

      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }

    if(design==2){
      System.out.println("\nYou entered:\n" + pointPolar);
      PointCPD2 otherPoint=pointPolar.rotatePoint(45);
      System.out.println("After rotating\n"+otherPoint);
      // System.out.println("Distance between random point and the original: " +pointPolar.getDistance(otherPoint));
    }
    if(design==3){
      System.out.println("\nYou entered:\n" + pointCartesian);
      PointCPD3 otherPoint=pointCartesian.rotatePoint(45);
      System.out.println("After rotating\n"+otherPoint);
    }
    if(design==6){
      System.out.println("\nYou entered:\n" + pointD6);
      PointD6 otherPoint=pointD6.rotatePoint(45);
      System.out.println("After rotating\n"+otherPoint);
    }
  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static double[] getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    int design = 6; // Temporary default, to be set to 2,3 or 6
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the number for the design you want to test: 2, 3 or 6");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (design == 3 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "Rho " : "Theta ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!(theInput.charAt(0)== '2'||theInput.charAt(0)=='3'||theInput.charAt(0)=='6'))
            {
              System.out.println("incorrect input");
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              design = Integer.parseInt(theInput);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    return (new double[]{ design, a,b});
  }
}
