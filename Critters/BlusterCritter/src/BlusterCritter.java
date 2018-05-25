

import java.awt.*;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;

/**
 * A BlusterCritter looks at all of the creatures within two steps
 * of its current location. If the number of the creatures is lower
 * than c(courage), then it get brighter, else darker.
 */

public class BlusterCritter extends Critter {
  private static final int EYESIGHT = 2;
  private static final int MAX_COLOR_VAL = 255;
  private static final int BRIGHTEN = 10;
  private static final int DARKEN = -10;
  private int courage;

  /**
   * BlustCritter constructor
   *
   * @param c the courage needed for a BlustCritter to brighten itself
   */
  public BlusterCritter(int c) {
    courage = c;
    setColor(Color.PINK);
  }

  /**
   * The BlusterCritter looks at all of the creatures within two steps 
   * of a BlustCritter current location.
   */
  public ArrayList<Actor> getActors() {
    ArrayList<Actor> creatures = new ArrayList<Actor>();
    Location loc = getLocation();
    for (int raw = loc.getRow() - EYESIGHT; raw <= loc.getRow() + EYESIGHT; raw++) {
      for (int col = loc.getCol() - EYESIGHT; col <= loc.getCol() + EYESIGHT; col++) {
        Location tempLoc = new Location(raw, col);
        if (getGrid().isValid(tempLoc)) {
          Actor tempAct = getGrid().get(tempLoc);
          if (tempAct != null && tempAct != this) {
            creatures.add(tempAct);
          }
        }
      }
    }
    return creatures;
  }
  /**
   * change the color according to the change factor
   * @param    changeFactor 
   */
  private void colorChange(int changeFactor) {
    Color c = getColor();
    int redAfter = c.getRed() + changeFactor;
    int greenAfter = c.getGreen() + changeFactor;
    int blueAfter = c.getBlue() + changeFactor;

    if (redAfter < 0 || redAfter > MAX_COLOR_VAL) {
      redAfter -= changeFactor;
    }
    if (greenAfter < 0 || greenAfter > MAX_COLOR_VAL) {
      greenAfter -= changeFactor;
    }
    if (blueAfter < 0 || blueAfter > MAX_COLOR_VAL) {
      blueAfter -= changeFactor;
    }
    
    setColor(new Color(redAfter, greenAfter, blueAfter));
  }

  /**
   * It searches for the critters nearby. If there are fewer than c critters, the
   * BlusterCritter's color gets brighter (color values increase). If there are
   * c or more critters, the BlusterCritter's color darkens (color values
   * decrease). Here, c is a value that indicates the courage of the critter.
   * @param    the actors array
   */
  public void processActors(ArrayList<Actor> actors) {
    int count = 0;
    for (Actor item : actors) {
      if (item instanceof Critter) {
        count++;
      }
    }
    if (count > courage) {
      colorChange(DARKEN);
      return;
    } else {
      colorChange(BRIGHTEN);
      return;
    }
  }

}