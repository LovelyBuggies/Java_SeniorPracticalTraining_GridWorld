
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;

/**
 * Runner
 */

public final class BlusterCritterRunner {
  public BlusterCritterRunner() {
  }

  public static void main(String[] args) {

    //construct a world
    ActorWorld world = new ActorWorld();
    for (int raw = 3; raw < 8; raw++) {
      for (int col = 3; col < 5; col++) {
        world.add(new Location(raw, col), new Rock());
      }
    }
    // add the BlusterCritter into the world
    world.add(new Location(0, 0), new BlusterCritter(4));
    for (int raw = 4; raw < 6; raw++) {
      for (int col = 4; col < 6; col++) {
        world.add(new Location(raw, col), new BlusterCritter(2));
      }
    }
    // show the world
    world.show();
  }
}