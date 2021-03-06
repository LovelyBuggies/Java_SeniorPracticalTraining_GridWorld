package QuickCrab.src;

import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * A QuickCrabCritter looks at a limited set of neighbors when it eats and moves. 
 */
public class QuickCrabCritter extends CrabCritter {

   /**
   * gets the location that is two steps far from the QuickCrab in a given direction.
   *
   * @param locs
   * @param direction
   */
  public void getMoveLocationsInDirection(ArrayList<Location> locs, int direction) {
    Grid gr = getGrid();
    Location currentLoc = getLocation();
    Location neigh = currentLoc.getAdjacentLocation(direction);
    if (gr.isValid(neigh) && gr.get(neigh) == null) {
      Location neigh_neigh = neigh.getAdjacentLocation(direction);
      if (gr.isValid(neigh_neigh) && gr.get(neigh_neigh) == null) {
        locs.add(neigh_neigh);
      }
    }
  }
  
  /**
   * A QuickCrab moves to one of the two locations, randomly selected, that are
   * two spaces to its right or left.
   * @return list of empty locations immediately in two steps to the right and to
   * the left.
   */
  public ArrayList<Location> getMoveLocations() {
    ArrayList<Location> locs = new ArrayList<Location>();
    int[] direc = {Location.LEFT, Location.RIGHT};
    getMoveLocationsInDirection(locs, getDirection() + direc[0]);
    getMoveLocationsInDirection(locs, getDirection() + direc[1]);
    if (locs.size() == 0) {
      return super.getMoveLocations();
    }
    return locs;
  }

}