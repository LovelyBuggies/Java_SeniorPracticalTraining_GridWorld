package Bugs.CircleBug.src;
import info.gridworld.actor.Bug;

public class CircleBug extends Bug{
	// the steps
	private int steps;
	// the side length
    private int sideLength;

    /**
     * Constructs a circle bug that traces along a square of a given side length
     * @param length the side length
     */
    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
    	// to justify whether the bug can move
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
        	// if can not move, then turn
            turn();
            steps = 0;
        }
    }
}
