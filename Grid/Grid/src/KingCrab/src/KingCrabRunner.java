
package KingCrab.src;

import java.awt.Color;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains KingCrab critters.
 */
public final class KingCrabRunner {

  public static void main(String[] args) {
    // construct a world
    ActorWorld world = new ActorWorld();
    // add components to the world
    world.add(new Location(5, 6), new Bug());
    world.add(new Location(9, 9), new Bug());
    world.add(new Location(7, 8), new Flower());
    world.add(new Location(2, 4), new Flower());
    world.add(new Location(3, 6), new Flower());
    world.add(new Location(3, 0), new Flower());
    world.add(new Location(1, 2), new Rock());
    world.add(new Location(6, 2), new Rock(Color.PINK));
    world.add(new Location(6, 7), new Rock(Color.RED));
    world.add(new Location(4, 3), new Rock(Color.BLUE));
    world.add(new Location(4, 0), new KingCrabCritter());
    world.add(new Location(4, 1), new KingCrabCritter());
    world.add(new Location(5, 0), new KingCrabCritter());
    // show the world
    world.show();
    }
}