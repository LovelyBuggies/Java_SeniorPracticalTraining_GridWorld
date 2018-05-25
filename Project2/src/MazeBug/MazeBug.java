package MazeBug;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import javax.swing.JOptionPane;

/**
 * A MazeBug can find its way in a maze. 
 */
public class MazeBug extends Bug {
  
  private final int basicSlp = 1;             // start slope of directions
  private final int bonusSlp = 5;             // bonus for the near directions
  private final int dirNum = 4;               // bonus for the near directions
  private final int stepLen = 100;            // predict step length
  private final int turnAngle = 90;           // rec-angle
  public Location next;                       // the next location to move
  public boolean isEnd;                       // whether the maze bug reach the final
  public Stack<ArrayList<Location>> crossLocation;  // to record the routes
  public Integer stepCount;                   // the number of steps
  public Stack<Location> trueWay;             // the way from start to now
  boolean hasShown;                           //final message has been shown
  private int[] slope = {basicSlp, basicSlp, basicSlp, basicSlp};  // slope array
  
  /**
   * Constructs a box bug.
   */
  public MazeBug() {
    setColor(Color.GREEN);
    stepCount = 0;
    isEnd = false;
    hasShown = false;
    trueWay = new Stack<Location>();
    crossLocation = new Stack<ArrayList<Location>>();
  }

  /**
   * Moves to the next location of the square.
   */
  public void act() {
    
    // add the initial location to the first array list
    if(stepCount==0){
      Location local = this.getLocation();
      ArrayList<Location> first = new ArrayList<Location>();
      first.add(local);
      trueWay.push(local);
      crossLocation.add(first);
    }
  
    if(stepCount % stepLen == 0){
      directionPredic();
    }
    
    boolean willMove = canMove();
    if (isEnd == true) {
      showRightWay(trueWay);
      //to show step count when reach the goal
      if (hasShown == false) {
        String msg = stepCount.toString() + " steps";
        JOptionPane.showMessageDialog(null, msg);
        hasShown = true;
      }
    } 
    else if (willMove) {
      move();
      //increase step count when move
      stepCount++;
    } 
    else {
      //If can't move, return to last location
      goBack();
    }
  }

  /**
   * Find all positions that can be move to.
   * 
   * @param loc - the location to detect
   * @return list of positions
   */
  public ArrayList<Location> getValid(Location loc) { 
    // get the grid and return null if cannot get
    Grid<Actor> gr = getGrid();
    if (gr == null) {
      return null;
    }
    
    // get the valid locations of the four direction
    ArrayList<Location> validNeighbors = new ArrayList<Location>();
    int[] dir = {Location.NORTH, Location.EAST, Location.SOUTH, Location.WEST};
    
    // for each location
    for( int i = 0; i < 4; i++ ){
      // get the adjacent locations and if they are valid
      Location location = loc.getAdjacentLocation(dir[i]);
      if(gr.isValid(location)){
        Actor actor = gr.get(location);
        // if the goal is around, the valid location is the target
        if( (actor instanceof Rock) && actor.getColor().equals(Color.RED) ) {
          next = location;
          ArrayList<Location> target = new ArrayList<Location>();
          target.add(next);
          return target;
        }
        // if there is an empty grid
        else if(actor == null){
          validNeighbors.add(location);
        }
      }
    }
    return validNeighbors;
  }

  /**
   * Test whether this bug can move forward into a location that is empty
   * or contains a flower.
   * 
   * @return true if this bug can move, false else
   */
  public boolean canMove() {
    // get the valid neighbors
    Location current = this.getLocation();
    ArrayList<Location> validLocation = new ArrayList<Location>();
    validLocation = getValid(current);
    
    // whether their is a valid neighbor
    return validLocation.size() > 0 ? true : false;
  }
  
  /**
   * Moves the bug forward, putting a flower into the location it previously
   * occupied.
   */
  public void move() {
    // get the current grid and return if current grid is null
    Grid<Actor> gr = getGrid();
    if (gr == null) {
      return;
    }
    
    // get the valid neighbors
    Location loc = this.getLocation();
    ArrayList<Location> validNeighbors = getValid(loc);
    
    /* set direction slope according to the direction-towards times;
     * that's to say, the slope of a certain direction is high when
     * the bug previously is more likely to move towards this direction
     */
    int maxDirPro = 0;
    int maxDirIndex = 0;
    int neighNum = 0;
    int whichOne = 0;
    for( Location got : validNeighbors ) {
      /*
       *  test whether the slope of a given direction exceed the max 
       *  direction slope, if true, renew the max direction slope
       *  with max direction index in the slope array, and record the
       *  index of max-towards neighbor index(whichOne) in the valid neighbors
       */
      int dir = loc.getDirectionToward(got);
      if( slope[dir/turnAngle] > maxDirPro ) {
        maxDirPro = slope[dir/turnAngle];
        maxDirIndex = (int) dir/turnAngle;
        whichOne = neighNum;
      }
      neighNum++;
    }
    
    // get the next location to move
    next = validNeighbors.get(whichOne); 
    slope[maxDirIndex]++;
    
    // after get the most likely location, move there and process properties
    Actor actor = (Actor)gr.get(next);
    // if reach the final
    if( actor instanceof Rock && actor.getColor().equals(Color.RED) ){
      isEnd = true;
      showRightWay(trueWay);
    }
    moveTo(next);
    trueWay.push(next);
    int facing = loc.getDirectionToward(next);
    this.setDirection(facing);
      
    // renew the record
    ArrayList<Location> temp = crossLocation.pop();
    temp.add(next);
    crossLocation.push(temp);
    
    // start a trial
    // peek of the crossLocation is a trial, an attempt
    ArrayList<Location> latest = new ArrayList<Location>();
    latest.add(next);
    crossLocation.push(latest);
    
    // print and add flower
    System.out.println(stepCount);
    Flower flower = new Flower(getColor());
    flower.putSelfInGrid(gr, loc);
  }
  
  /**
   * Go back to last site.
   */
  public void goBack(){
    // cannot goback exception
    if (crossLocation.size() == 0) {
      return;
    }
    
    // true way go back
    trueWay.pop();
    // trial fails
    crossLocation.pop();
    // record go back
    
    if(crossLocation.size() > 0) {
      Grid gr = getGrid();
      if( gr == null ) {
        return;
      }
      
      // get the last site
      Location current = this.getLocation();
      ArrayList<Location> back = crossLocation.peek();
      Location last = back.get(0);
            
      // move to the last site
      int dir = current.getDirectionToward(last);
      this.setDirection(dir);
      moveTo(last);
      stepCount++;
      
      // direction slope changes
      if ( (int)(dir/turnAngle) == 2 ) {
        slope[0]--;
      }
      else if ( (int)(dir/turnAngle) == 3 ) {
        slope[1]--;
      }
      else if ( (int)(dir/turnAngle) == 0 ) {
        slope[2]--;
      }
      else if ( (int)(dir/turnAngle) == 1 ) {
        slope[3]--;
      }
      
      // leave a flower
      Flower flower = new Flower(getColor());
      flower.putSelfInGrid(gr, current);
    }
  }
  
  /**
   * As a direction estimation, determine which direction the destination is 
   * located in the insect, and then select the location of the destination before 
   * choosing the location.
   */
  public void directionPredic() {
    Grid<Actor> gr = getGrid();
    ArrayList<Location> array = gr.getOccupiedLocations();
    
    for( Location l : array ){
      Actor actor = (Actor) gr.get(l);
      if ( actor instanceof Rock && actor.getColor().equals(Color.RED)){
        Location current = this.getLocation();
        if( current.getRow() < l.getRow() ){
          // resetSlope(slope, 0, 2);
          leanSlope(slope, 0, 2);
        }
        else {
          // resetSlope(slope, 2, 0);
          leanSlope(slope, 2, 0);
        }
        if( current.getCol() < l.getCol() ){
          // resetSlope(slope, 3, 1);
          leanSlope(slope, 3, 1);
        }
        else {
          // resetSlope(slope, 1, 3);
          leanSlope(slope, 1, 3);
        }
        break;
      }
    }
  }
  
  /**
   * Reset the value of slope array
   * 
   * @param slope - slope array
   * @param basicIndex - slope[basicIndex] = basicSlp
   * @param bonusIndex - slope[bonusIndex] = bonusSlp
   */
  public void resetSlope(int[] slope, int basicIndex, int bonusIndex) {
	slope[basicIndex] = basicSlp;
	slope[bonusIndex] = bonusSlp;
  }
  
  /**
   * Lean the value of slope array
   * 
   * @param slope - slope array
   * @param basicIndex - slope[basicIndex] = basicSlp
   * @param bonusIndex - slope[bonusIndex] = bonusSlp
   */
  public void leanSlope(int[] slope, int basicIndex, int bonusIndex) {
	slope[basicIndex] += basicSlp;
	slope[bonusIndex] += bonusSlp;
  }
  
  /**
   * Remark the right path with green flowers.
   * 
   * @param way - right path
   */
  public void showRightWay(Stack<Location> rightWay){
    for( Location w : rightWay ){
      Grid g = getGrid();
      Actor act = (Actor) g.get(w);
      act.setColor(Color.GREEN);
    }
  }
}