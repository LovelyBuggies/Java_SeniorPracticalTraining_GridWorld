package Jumper.src;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import java.awt.Color;

/**
 * A Jumper is an actor that can move, turn and jump.
 */
public class Jumper extends Actor
{
    //Constructs a jumper.
    public Jumper()
    {
        setColor(Color.BLUE);
    }

    /**
     * Constructs a bug of a given color.
     * @param JumperColor the color for this jumper
     */
    public Jumper(Color JumperColor)
    {
        setColor(JumperColor);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove()){
            move();
        }
        else{
            turn();
        }
    }

    /**
     * Turns the jumper half right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the jumper forward, leaving a flower into the location it previously occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null){
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        next = next.getAdjacentLocation(getDirection());
        moveTo(next);
    }

    /**
     * Tests whether this jumper can move forward into a location that is empty or contains a flower.
     * @return true if this Jumper can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null){
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        next = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(next)){
            return false;
        }
        Actor neighbor = gr.get(next);
        return (neighbor == null);
    }
}
