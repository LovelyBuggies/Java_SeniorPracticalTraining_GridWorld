package RockHound.src;

import java.awt.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * Runner
 */
public final class RockHoundRunner {

  public static void main(String[] args) {
    // construct a world
    ActorWorld world = new ActorWorld();
    // add the components to the world
    world.add(new Location(7, 8), new Rock());
    world.add(new Location(3, 3), new Rock());
    world.add(new Location(3, 0), new Flower(Color.PINK));
    world.add(new Location(1, 5), new Flower(Color.RED));
    world.add(new Location(2, 8), new Flower(Color.BLUE));
    world.add(new Location(8, 2), new Flower(Color.YELLOW));
    world.add(new Location(1, 0), new Flower(Color.PINK));
    world.add(new Location(1, 7), new Flower(Color.RED));
    world.add(new Location(2, 0), new Flower(Color.BLUE));
    world.add(new Location(5, 2), new Flower(Color.YELLOW));
    world.add(new Location(0, 4), new RockHound());
    world.add(new Location(3, 8), new RockHound());
    // show the world
    world.show();
  }
}