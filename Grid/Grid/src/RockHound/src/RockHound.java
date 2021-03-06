package RockHound.src;

import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

/**
 * A RockHound takes on the color of neighboring actors as it 
 * moves through the grid.
 */
public class RockHound extends Critter {
  // if the neighbors have rocks, they will be removed
  public void processActors(ArrayList<Actor> actors) {
    for (Actor a : actors) {
      if (!(a instanceof Critter)) {
        a.removeSelfFromGrid();
      }
    }
  }
}