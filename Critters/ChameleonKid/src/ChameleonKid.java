
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.*;
import java.util.ArrayList;

/**
 * A ChameleonKid takes on the color of neighboring actors immediately in
 * front or behind as it moves.
 */

public class ChameleonKid extends Critter {
  private static final double DARKENING_FACTOR = 0.1;

  /**
   * A ChameleonKid gets the actors in the locations immediately in front,
   * at back
   *
   * @return a list of actors occupying two locations
   */
  public ArrayList<Actor> getActors() {
    ArrayList<Actor> actors = new ArrayList<Actor>();
    int[] direc = {Location.AHEAD, Location.HALF_CIRCLE};
    for (Location loc : getLocationsInDirections(direc)) {
      Actor item = getGrid().get(loc);
      if (item != null) {
        actors.add(item);
      }
    }
    return actors;
  }

  /**
   * darken the color according to the factor
   */
  private void darken() {
    Color c = getColor();
    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
    setColor(new Color(red, green, blue));
  }

  /**
   * Randomly selects a neighbor and changes this critter's color to be 
   * the same as that neighbor's. If there are no neighbors, its color will darken.
   */
  public void processActors(ArrayList<Actor> actors) {
    int count = actors.size();
    if (count == 0) {
      darken();
      return;
    }
    Actor attraction = actors.get((int) (Math.random() * count));
    setColor(attraction.getColor());
  }

  /**
   * Turns towards the new location as it moves.
   */
  public void makeMove(Location loc) {
    setDirection(getLocation().getDirectionToward(loc));
    super.makeMove(loc);
  }

  /**
   * get the locations
   * @param    direction array
   */
  public ArrayList<Location> getLocationsInDirections(int[] directions) {
    ArrayList<Location> locs = new ArrayList<Location>();
    Grid gr = getGrid();
    Location loc = getLocation();
    for (int dir : directions) {
      Location neigh = loc.getAdjacentLocation(getDirection() + dir);
      if (gr.isValid(neigh)) {
        locs.add(neigh);
      }
    }
    return locs;
  }
}