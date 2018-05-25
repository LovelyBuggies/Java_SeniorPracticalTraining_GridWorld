import java.util.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;
import info.gridworld.actor.*;
import info.gridworld.grid.*;


public class SparseBoundedGrid2<E> extends AbstractGrid<E>
{
	// the occupant Map
    private Map<Location, E> occupantMap;
    private int COLUMN, ROW;

    /**
    * constructor
    */
    public SparseBoundedGrid2(int rows, int cols)
    {
    	// exception
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        // exception
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }

        COLUMN = cols;
        ROW = rows;
        occupantMap = new HashMap<Location, E>();
    }

    /**
    * getNumRows
    */
    public int getNumRows()
    {
        return ROW;
    }

    /**
    * getNumCols
    */
    public int getNumCols()
    {
        return COLUMN;
    }

    /**
    * whether is valid
    */
    public boolean isValid(Location loc)
    {
        return loc.getCol() < getNumCols() && loc.getRow() >=0 && loc.getRow() < getNumRows() && loc.getCol() >= 0;
    }

    /** 
    * get the Occupied Locations
    */
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet()) {
            a.add(loc);
        }
        return a;
    }

    /** 
    * remove the object from the world
    */
    public E remove(Location loc)
    {
    	// exception
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        
        return occupantMap.remove(loc);
    }
    /** 
    * get the object from the world
    */
    public E get(Location loc)
    {
    	// exception
        if (!isValid(loc)){
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        return occupantMap.get(loc);
    }
    /** 
    * put the object to the world
    */
    public E put(Location loc, E obj)
    {
    	// exception
        if (!isValid(loc)){
            throw new IllegalArgumentException("Location " + loc+ " is not valid");
        }
        // exception
        if (obj == null){
            throw new NullPointerException("obj == null");
        }

        return occupantMap.put(loc, obj);
    }

}