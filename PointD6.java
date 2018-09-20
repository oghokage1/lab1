public interface PointD6{
	
	public double getX();
	public double getY();
	public double getRho();
	public double getTheta();
	public PointD6 rotatePoint(double r);
	public double getDistance(PointD6 a);
}