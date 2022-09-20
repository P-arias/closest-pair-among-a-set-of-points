/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpair_1;

/**
 *
 * @author paria
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Point {
    final double x;
    final double y;
    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public double distance(Point that) {
        
        return Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2);

    }
}
class Pair {
    Point one;
    Point two;
    public Pair(Point one, Point two) {
        this.one = one; this.two = two;
    }
}

public class ClosestPair_1 {

    /**
     * @param args the command line arguments
     */
     private static Pair findClosestPair(List<Point> points) {
        
       Pair closest = new Pair(points.get(0), points.get(1));
        
        for(int i = 0; i < points.size() - 1;i++){
            
            for(int j = i+1; j < points.size();j++){
                
                if(points.get(i).distance(points.get(j)) < closest.one.distance(closest.two))
                    closest = new Pair(points.get(i), points.get(j));
                
            }
        }
        
     return closest; 
    }

    public static void main(String[] args) {
         Scanner scanner =  new Scanner(System.in);
        int N = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        
        for (int i = 0; i < N; i+=1) {
            points.add(new Point(scanner.nextDouble(), scanner.nextDouble()));
        }

        Pair closest = findClosestPair(points);

        System.out.println(closest.one.x + " " + closest.one.y);
        System.out.println(closest.two.x + " " + closest.two.y);
    }
    
}
