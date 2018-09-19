public interface Point{
	
	public double getX();
	public double getY();
	public double getRho();
	public double getTheta();
	public Point rotatePoint(double r);
	public double getDistance(Point a);
}