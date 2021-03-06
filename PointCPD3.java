// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in  cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCPD3
{
  //Instance variables ************************************************

  /**
   * Contains the current value of X
   */
  private double x;
  
  /**
   * Contains the current value of Y
   */
  private double y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCPD3(char coord, double xOrRho, double yOrTheta)
  {

    if(coord=='C'){
      this.x = xOrRho;
      this.y = yOrTheta;
    }
    else if (coord=='P'){
      this.x=(Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
      this.y=(Math.sin(Math.toRadians(yOrTheta)) * yOrTheta);
    }
    else{
      throw new IllegalStateException();
    }

  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
      return x;
  }
  
  public double getY()
  {
      return y;
  }
  
  public double getRho()
  {
      return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }
  
  public double getTheta()
  {
      return Math.toDegrees(Math.atan2(y, x));
  }

  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public PointCPD2 convertStorageToPolar()
  {
    return new PointCPD2('P', this.getRho() ,this.getTheta());
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian()
  {
    //already cartesian
  }
  
    /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCPD3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCPD3('C',
      (Math.cos(radRotation) * x) - (Math.sin(radRotation) * y),
      (Math.sin(radRotation) * x) + (Math.cos(radRotation) * y));
  }
  /**
   * Calculates the distance between this point and the other point using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCPD3 other)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = other.getX() - x;
    double deltaY = other.getY() - y;
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Cartesian Point: (" + x + ", " + y + ")\n Computed Polar coord: ["+getRho()+ ", " +getTheta() +"]";
  }
}
