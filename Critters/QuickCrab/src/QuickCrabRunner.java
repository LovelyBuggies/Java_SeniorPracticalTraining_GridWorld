
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Bug;


/**
 * This class runs a world that contains crab critters.
 */
public final class QuickCrabRunner {
  private QuickCrabRunner(){}

  public static void main(String[] args) {
    // construct a world
    ActorWorld world = new ActorWorld();
    // add the components to the world
    world.add(new Location(1, 5), new Rock());
    world.add(new Location(2, 4), new Rock());
    world.add(new Location(6, 4), new Rock());
    world.add(new Location(0, 3), new Rock());
    world.add(new Location(7, 6), new Flower());
    world.add(new Location(2, 2), new Flower());
    world.add(new Location(3, 7), new Flower());
    world.add(new Location(7, 8), new Flower());
    world.add(new Location(6, 7), new Bug());
    world.add(new Location(6, 3), new Bug());
    world.add(new Location(4, 5), new QuickCrabCritter());
    world.add(new Location(6, 0), new QuickCrabCritter());
    world.add(new Location(7, 4), new QuickCrabCritter());
    // show the world
    world.show();
  }
}
