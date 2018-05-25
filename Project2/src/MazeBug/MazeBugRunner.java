package MazeBug;


import java.awt.Color;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains maze bugs.
 */
public class MazeBugRunner {
  public static void main(String[] args) {
    ActorWorld world = new ActorWorld();
    world.add(new Location(0, 0), new MazeBug());
    world.add(new Location(9, 9),new Rock(Color.RED)); 
    for(int i=1;i<9;i++){ 
        for(int j=1;j<9;j++){ 
            world.add(new Location(i,j),new Rock()); 
        } 
    }
    world.show();
  }
}