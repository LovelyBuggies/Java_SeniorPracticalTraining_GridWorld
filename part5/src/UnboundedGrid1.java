import java.util.*;
import info.gridworld.actor.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;


public class UnboundedGrid1<E> extends AbstractGrid<E>
{
    // the occupant array
    private Object[][] occupantArray;

    /**
    * constructor
    */
    public UnboundedGrid1()
    {
        occupantArray = new Object[16][16];
    }

    /**
    * getNumRows
    */
    public int getNumRows()
    {
        return -1;
    }

    /**
    * getNumCols
    */
    public int getNumCols()
    {
        return -1;
    }

    /**
    * whether is valid
    */
    public boolean isValid(Location loc)
    {
        return (loc.getRow() >= 0 && loc.getCol()>= 0);
    }

    /** 
    * get the Occupied Locations
    */
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        for (int r = 0; r < occupantArray.length; r++)
        {
            for (int c = 0; c < occupantArray[0].length; c++)
            {
                Location loc = new Location(r, c);
                if (get(loc) != null){
                    theLocations.add(loc);
                }
            }
        }

        return theLocations;
    }

    /** 
    * remove the object from the world
    */
    public E remove(Location loc)
    {        
        if (!isValid(loc)){
            // exception
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }

        if (loc == null){
            // exception
            throw new NullPointerException("loc == null");
        }
 
        E r = get(loc);
        if (loc.getCol() < occupantArray.length && loc.getRow() < occupantArray.length){
        occupantArray[loc.getRow()][loc.getCol()] = null;
        }
        return r;
    }

    /** 
    * get the object from the world
    */
    public E get(Location loc)
    {
        if (loc == null){
            // exception
            throw new NullPointerException("loc == null");
        }
        if (!isValid(loc)){
            // exception
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (loc.getRow() >= occupantArray.length || loc.getCol() >= occupantArray[0].length){
            return null;
        }
        return (E) occupantArray[loc.getRow()][loc.getCol()]; // unavoidable warning
    }

    /** 
    * put an object to the loc
    */
    public E put(Location loc, E obj)
    {
        if (loc == null){
            // exception
            throw new NullPointerException("loc == null");
        }
        if (obj == null){
            // exception
            throw new NullPointerException("obj == null");
        }

        if (!isValid(loc)){
            // exception
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }

        E oldOccupant = get(loc);
        if (loc.getRow() < occupantArray.length && loc.getCol() < occupantArray[0].length) {
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        } 
        else {
          Object[][] tmp = occupantArray;
          int len = tmp.length;
          while(loc.getRow() >= len || loc.getCol() >= len){
               len *= 2;
          }
          occupantArray = new Object[ant][ant];
          for (int r = 0; r < tmp.length; r++) {
               for (int c = 0; c < tmp.length; c++){
                   occupantArray[r][c] = tmp[r][c];
               }
          }
          occupantArray[loc.getRow()][loc.getCol()] = obj;
        }
        return oldOccupant;
    }


}
