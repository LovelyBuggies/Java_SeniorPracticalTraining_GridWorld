

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
* auxiliary
*/
class OccupantInCol
{
      private Object occupant;
      private int col;

    /**
    * constructor
    */
      public OccupantInCol(Object o, int c) {
            this.occupant = o;
            this.col = c;
      }

    /**
    * getOccupant
    */
      public Object getOccupant() {
           return this.occupant;
     }

    /**
    * getOccupant
    */
      public int getCol() {
           return this.col;
      } 
}


public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
    private ArrayList<LinkedList<OccupantInCol>> occupantArray; 
    private int COL, ROW;

    /**
    * constructor
    */
    public SparseBoundedGrid(int rows, int cols)
    {
        if (rows <= 0){
        	// exception
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0){
        	// exception
            throw new IllegalArgumentException("cols <= 0");
        }

        COL = cols;
        ROW = rows;
        occupantArray = new ArrayList<LinkedList<OccupantInCol>>();
        for (int i = 0; i < ROW; i++) {
            occupantArray.add(null);
        }
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
        return COL;
    }

    /**
    * whether is valid
    */
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    /** 
    * get the Occupied Locations
    */
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        for (int r = 0; r < getNumRows(); r++)
        {
            if (occupantArray.get(r) == null) {
               continue;
            }
            for (int c = 0; c < occupantArray.get(r).size(); c++)
            {
                OccupantInCol tmp = occupantArray.get(r).get(c);
                Location loc = new Location(r, tmp.getCol());
                theLocations.add(loc);
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
        
        // Remove the object from the grid.
        E r = get(loc);
        if (r != null) {
	    for (int i = 0; i < occupantArray.get(loc.getRow()).size(); i++) {
            OccupantInCol tmp = occupantArray.get(loc.getRow()).get(i);
            if (tmp.getCol() == loc.getCol()){
                occupantArray.get(loc.getRow()).remove(i);
            }
          }
        }
        return r;
    }

    /** 
    * get the Occupied Locations
    */
    public E get(Location loc)
    {
        if (!isValid(loc)){
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (occupantArray.get(loc.getRow()) == null) {
           return null;
        }
        for (int i = 0; i < occupantArray.get(loc.getRow()).size(); i++) {
            OccupantInCol tmp = occupantArray.get(loc.getRow()).get(i);
            if (tmp.getCol() == loc.getCol()){
                return (E) tmp.getOccupant();
            }
        }
        return null;
    }

    /** 
    * put the object to the world
    */
    public E put(Location loc, E obj)
    {
        if (!isValid(loc)){
        	// exception
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (obj == null){
        	// exception
            throw new NullPointerException("obj == null");
        }

        // Add the object to the grid.
        E oldOccupant = get(loc);
        if (occupantArray.get(loc.getRow()) == null){
            occupantArray.set(loc.getRow(), new LinkedList<OccupantInCol>());
        }
        OccupantInCol tmp = new OccupantInCol(obj, loc.getCol());
        occupantArray.get(loc.getRow()).add(tmp);

	return oldOccupant;
    }

}
