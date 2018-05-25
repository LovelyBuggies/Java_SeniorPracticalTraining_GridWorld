package ModifiedChamleonCritter.src;
import java.awt.*;
import java.util.ArrayList;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

/**
 * The ModifiedChameleonCritter takes on the color of neighboring
 * actors as it moves through the grid.
 */
public class ModifiedChameleonCritter extends Critter {

  private static final double DARKEN_FACTOR = 0.1;

  private void darken() {
    Color c = getColor();
    int blue = (int) (c.getBlue() * (1 - DARKEN_FACTOR));
    int red = (int) (c.getRed() * (1 - DARKEN_FACTOR));
    int green = (int) (c.getGreen() * (1 - DARKEN_FACTOR));
    setColor(new Color(red, green, blue));
  }

  /**
   * Randomly selects a neighbor and changes this critter's color to be the same
   * as that neighbor's. If there are no neighbors, its color will darken.
   */
  public void processActors(ArrayList<Actor> actors) {
    int count = actors.size();
    if (count == 0) {
      darken();
      return;
    }
    setColor(actors.get((int) (Math.random() * count)).getColor());
  }

  /**
   * Turns towards the new location as it moves.
   */
  public void makeMove(Location loc) {
    setDirection(getLocation().getDirectionToward(loc));
    super.makeMove(loc);
  }
}