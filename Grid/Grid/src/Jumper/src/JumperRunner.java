package Jumper.src;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import java.awt.Color;

public final class JumperRunner
{
    
    public static void main(String[] args) {

    // create a world
     ActorWorld world = new ActorWorld();
     // construct two jumpers
     Jumper nino = new Jumper(Color.YELLOW);
     Jumper lucas = new Jumper(Color.RED);
     // construct a bug
     Bug insect = new Bug();
     // construct obstacles
     Rock stone = new Rock();
     Rock granite = new Rock();
     // construct flower named orchid
     Flower orchid = new Flower();

     // add the components to the world
     world.add(new Location(4, 1), insect);
     world.add(new Location(4, 3), orchid);
     world.add(new Location(5, 2), stone);
     world.add(new Location(8, 1), granite);
     world.add(new Location(1, 5), nino);
     world.add(new Location(2, 6), lucas);

     //show the world
     world.show();
   }
}
