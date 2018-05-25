package Bugs.SpiralBug.src;
import info.gridworld.actor.Bug;

public class SpiralBug extends Bug{
    // the steps
    private int steps;
    // the side length
    private int sideLength;

    /**
     * Constructs a Spiral bug that traces along a square of a given side length
     * @param length the side length
     */
    public SpiralBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */   
    public void act()
    {
    	// whether exceed the side length and be movable
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        // turn around
        else
        {
            turn();
            turn();
            steps = 0;
            // side length grow with the turn
            sideLength++;
        }
    }
}
