

import java.awt.Color;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains ModifiedChameleon critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public final class ModifiedChameleonRunner {
  public ModifiedChameleonRunner(){}

  public static void main(String[] args) {
    // construct the world
    ActorWorld world = new ActorWorld();
    // add components to the world
    world.add(new Location(5, 2), new Rock());
    world.add(new Location(3, 4), new Rock());
    world.add(new Location(1, 6), new Rock(Color.BLUE));
    world.add(new Location(7, 8), new Rock(Color.PINK));
    world.add(new Location(1, 4), new Rock(Color.RED));
    world.add(new Location(3, 6), new Rock(Color.YELLOW));
    world.add(new Location(7, 2), new ModifiedChameleonCritter());
    world.add(new Location(5, 8), new ModifiedChameleonCritter());
    world.add(new Location(0, 4), new ModifiedChameleonCritter());
    world.add(new Location(9, 8), new ModifiedChameleonCritter());
    // show the world 
    world.show();
  }
}
