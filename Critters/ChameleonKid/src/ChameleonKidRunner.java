
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import java.awt.*;

/**
 * Runner
 */

public final class ChameleonKidRunner {

  public static void main(String[] args) {
    // construct a world
    ActorWorld world = new ActorWorld();
    // add the actors into the world
    world.add(new Location(4, 7), new ChameleonKid());
    world.add(new Location(5, 9), new ChameleonKid());
    world.add(new Location(1, 1), new ChameleonKid());
    world.add(new Location(3, 8), new ChameleonKid());
    // set some rocks and flowers
    world.add(new Location(9, 6), new Rock(Color.BLACK));
    world.add(new Location(5, 8), new Rock(Color.BLUE));
    world.add(new Location(5, 5), new Rock(Color.PINK));
    world.add(new Location(6, 3), new Flower(Color.PINK));
    world.add(new Location(1, 5), new Rock(Color.RED));
    world.add(new Location(8, 1), new Flower(Color.RED));
    world.add(new Location(6, 2), new Rock(Color.YELLOW));
    world.show();
  }
}