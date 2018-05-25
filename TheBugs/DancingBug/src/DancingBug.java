import java.util.Arrays;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class DancingBug extends Bug{
    // the steps
    private int steps;
    // the turn times
    private int[] turnTime;
    // the length of turn times
    private int maxStep;

        /**
     * Constructs a dancing bug that makes different turns before each move
     * @param the turn array
     */
    public DancingBug(int[] turn) {
    	turnTime = Arrays.copyOf(turn, turn.length); ;
    	steps = 0;
    	maxStep = turn.length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
    	// we should first justify the movability then move
    	// gurantee not exceed the max step
        setDirection(getDirection() + Location.HALF_RIGHT * turnTime[steps % maxStep]);
        steps++;
        if(canMove()) {
        	move();
        }
            
    }
}
