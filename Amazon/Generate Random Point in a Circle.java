class Solution {
    private double x;
    private double y;
    private double radius;
    private Random random;
    
    public Solution(double radius, double x, double y) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.random = new Random();
    }
    
    public double[] randPoint() {
        double radians = random.nextDouble() * 2 * Math.PI;
        double radius = this.radius * Math.sqrt(random.nextDouble());
        
        double x = this.x + radius * Math.cos(radians);
        double y = this.y + radius * Math.sin(radians);
        return new double[] { x, y };
    }
}
