import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug{
    // the steps
    private int steps;
    // the side length
    private int sideLength;
    // in which part of ZPart
    private int zPart;

    /**
     * Constructs a Z bug that traces along a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        zPart = 0;
        // initial direction is east
        setDirection(Location.EAST);
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
    	// if finish a part
    	if(steps == sideLength) {
    		// finish the lower part
    		if(zPart == 2) {
    			return;
    		}
    		// finish the upper part, to start the lean part
    		else if(zPart == 0) {
            		setDirection(getDirection() + Location.SOUTHEAST);
                	zPart = 1;
                	steps = 0;
            	}
		// finish the lean part, to start the lower part
		else {
            	setDirection(getDirection() - Location.SOUTHEAST);
                zPart = 2;
            	steps = 0;
            }
    	}
    	// if on the road
    	else{
    		// stay and don't move
    		if(!canMove()) {
    			return;
    		}
    		move();
    		steps++;
        }
        
    }
}
