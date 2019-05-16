
/*

Given the radius and x-y positions of the center of a circle, 
write a function randPoint which generates a uniform random point in the circle.
Note:
input and output values are in floating-point.
radius and x-y position of the center of the circle is passed into the class constructor.
a point on the circumference of the circle is considered to be in the circle.
randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.

Example 1:
Input: 
["Solution","randPoint","randPoint","randPoint"]
[[1,0,0],[],[],[]]
Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]

Example 2:
Input: 
["Solution","randPoint","randPoint","randPoint"]
[[10,5,-7.5],[],[],[]]
Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]

*/

/*

Solution: use reject sampling, randomly choose a point in the square including the circle, and check if it's inside the circle
O(1),O(1)

*/

class Solution {
    
    private double radius;
    private double x_center;
    private double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double x = (2 * Math.random() - 1) * radius;
        double y = (2 * Math.random() - 1) * radius;
        while (x * x + y * y > radius * radius) {
            return randPoint();
        }
        return new double[] {x + x_center, y + y_center};
    }
}





