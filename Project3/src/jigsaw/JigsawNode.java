package jigsaw;

/**
 * JigsawNode
 *
 * @author Nino
 */
public class JigsawNode {
  // private static final int dimension = 3;    // JigsawNode dimension
  private static final int dimension = 5; // JigsawNode dimension
  private int[] nodesState;   // State of nodes：First place to store the blank space; other stores correspond to values
  private int nodeDepth;      // The number of steps to this state from the initial state
  private JigsawNode parent;  // The parent jigsaw state in this state is used to obtain the solution path
  private int estimatedValue; // The estimated cost value

  /**
   * JigsawNode Constructor
   *
   * @param data - the state of node，a N*N+1 array.
   * The first element of the array is the position of blank and the other N*N place the numbers of boxes.
   */
  public JigsawNode(int[] data) {
    if (data.length == this.dimension * dimension + 1) {
      this.nodesState = new int[data.length];
      for (int i = 0; i < this.nodesState.length; i++)
        this.nodesState[i] = data[i];
      this.nodeDepth = 0;
      this.parent = null;
      this.estimatedValue = 0;
    } else
      System.out.println("Parameter fault：the dimension of current node is 3. Please change the node state array length to " 
    		  						+ (dimension * dimension + 1) + "，or adjust JigsawNode's dimension");
  }

  /**
   * JigsawNode Constructor
   *
   * @param jNode - copy of a JigsawNode
   */
  public JigsawNode(JigsawNode jNode) {
    this.nodesState = new int[dimension * dimension + 1];
    this.nodesState = (int[]) jNode.nodesState.clone();
    this.nodeDepth = jNode.nodeDepth;
    this.parent = jNode.parent;
    this.estimatedValue = jNode.estimatedValue;
  }

  /**
   * Get Dimension
   *
   * @return dimension - current dimension of a JigsawNode
   */
  public static int getDimension() {
    return dimension;
  }

  /**
   * Get NodeState
   *
   * @return nodesState - the array of nodes state
   */
  public int[] getNodesState() {
    return nodesState;
  }

  /**
   * Get NodeStep
   *
   * @return nodeDepth - the steps to obtain such JigsawNode
   */
  public int getNodeDepth() {
    return nodeDepth;
  }

  /**
   * Get Parent
   *
   * @return parent - the last step
   */
  public JigsawNode getParent() {
    return parent;
  }

  /**
   * Get Estimated Value
   *
   * @return estimatedValue - the estimated cost value
   */
  public int getEstimatedValue() {
    return estimatedValue;
  }

  /**
   * Set Estimated Value
   *
   * @param estimatedValue - the estimated cost value
   */
  public void setEstimatedValue(int estimatedValue) {
    this.estimatedValue = estimatedValue;
  }

  /**
   * Initialize Param: estimatedValue, nodeDepth, parent
   */
  public void setInitial() {
    this.estimatedValue = 0;
    this.nodeDepth = 0;
    this.parent = null;
  }

  /**
   * JigsawNode Equality Comparison
   *
   * @param obj - JigsawNode
   * @return true if equal, false else
   */
  public boolean equals(Object obj) {
    for (int i = 0; i < this.nodesState.length; i++) {
      if (this.nodesState[i] != ((JigsawNode) obj).nodesState[i]) {
        return false;
      }
    }
    return true;
  }

  /**
   * State2String
   *
   * @return State String
   */
  public String toString() {
    String str = new String();
    str += "{" + this.nodesState[0];
    for (int index = 1; index <= dimension * dimension; index++)
      str += "," + this.nodesState[index];
    str += "}";
    return str;
  }

  /**
   * String2Matrix
   *
   * @return State Matrix
   */
  public String toMatrixString() {
    String str = new String();
    for (int x = 1, index = 1; x <= dimension; x++) {
      for (int y = 1; y <= dimension; y++, index++) {
        str += this.nodesState[index] + "  ";
      }
      str += "\n";
    }
    return str;
  }

  /**
   * Within Bound
   *
   * @return movable array, 0, 1, 2, 3 represent up, down, left, right direction respectively
   */
  public int[] canMove() {
    int[] movable = new int[]{0, 0, 0, 0};
    if (this.nodesState[0] > dimension
            && this.nodesState[0] <= dimension * dimension)
      movable[0] = 1; // movable up within bound
    if (this.nodesState[0] >= 1
            && this.nodesState[0] <= dimension * (dimension - 1))
      movable[1] = 1; // movable down within bound
    if (this.nodesState[0] % dimension != 1)
      movable[2] = 1; // movable left within bound
    if (this.nodesState[0] % dimension != 0)
      movable[3] = 1; // movable right within bound
    return movable;
  }

  /**
   * Movable Up
   *
   * @return true if possible, false else
   */
  public boolean canMoveEmptyUp() {
    return (this.nodesState[0] > dimension && this.nodesState[0] <= dimension * dimension);
  }

  /**
   * Movable Down
   *
   * @return true if possible, false else
   */
  public boolean canMoveEmptyDown() {
    return (this.nodesState[0] >= 1 && this.nodesState[0] <= dimension * (dimension - 1));
  }

  /**
   * Movable Left
   *
   * @return true if possible, false else
   */
  public boolean canMoveEmptyLeft() {
    return (this.nodesState[0] % dimension != 1);
  }

  /**
   * Movable Right
   *
   * @return true if possible, false else
   */
  public boolean canMoveEmptyRight() {
    return (this.nodesState[0] % dimension != 0);
  }

  /**
   * Move
   *
   * @param direction - direction mark
   * @return true if success, false else
   */
  public boolean move(int direction) {
    switch (direction) {
      case 0:
        return this.moveEmptyUp();
      case 1:
        return this.moveEmptyDown();
      case 2:
        return this.moveEmptyLeft();
      case 3:
        return this.moveEmptyRight();
      default:
        return false;
    }
  }

  /**
   * move the blank up
   *
   * @return if move up successfully return true，false else
   */
  public boolean moveEmptyUp() {
    int emptyPos = this.nodesState[0];
    int emptyValue = this.nodesState[emptyPos];
    // if canMoveEmptyUp
    if (this.nodesState[0] > dimension
            && this.nodesState[0] <= dimension * dimension) {
      this.parent = new JigsawNode(this);
      // add the nodeDepth
      this.nodeDepth++;
      // exchange
      this.nodesState[emptyPos] = this.nodesState[emptyPos - dimension];
      this.nodesState[emptyPos - dimension] = emptyValue;
      this.nodesState[0] = emptyPos - dimension;
      return true;
    }
    return false;
  }

  /**
   * move the blank down
   *
   * @return if move up successfully return true，false else
   */
  public boolean moveEmptyDown() {
    int emptyPos = this.nodesState[0];
    int emptyValue = this.nodesState[emptyPos];
    // if canMoveEmptyDown
    if (this.nodesState[0] >= 1
            && this.nodesState[0] <= dimension * (dimension - 1)) {
      this.parent = new JigsawNode(this);
      // add the nodeDepth
      this.nodeDepth++;
      // exchange
      this.nodesState[emptyPos] = this.nodesState[emptyPos + dimension];
      this.nodesState[emptyPos + dimension] = emptyValue;
      this.nodesState[0] = emptyPos + dimension;
      return true;
    }
    return false;
  }

  /**
   * move the blank left
   *
   * @return if move up successfully return true，false else
   */
  public boolean moveEmptyLeft() {
    int emptyPos = this.nodesState[0];
    int emptyValue = this.nodesState[emptyPos];
    // if canMoveEmptyLeft
    if (this.nodesState[0] % dimension != 1) {
      this.parent = new JigsawNode(this);
      // add the nodeDepth
      this.nodeDepth++;
      // exchange
      this.nodesState[emptyPos] = this.nodesState[emptyPos - 1];
      this.nodesState[emptyPos - 1] = emptyValue;
      this.nodesState[0] = emptyPos - 1;
      return true;
    }
    return false;
  }

  /**
   * move the blank right
   *
   * @return if move up successfully return true，false else
   */
  public boolean moveEmptyRight() {
    int emptyPos = this.nodesState[0];
    int emptyValue = this.nodesState[emptyPos];
    // if canMoveEmptyRight
    if (this.nodesState[0] % dimension != 0) {
      this.parent = new JigsawNode(this);
      // add the nodeDepth
      this.nodeDepth++;
      // exchange
      this.nodesState[emptyPos] = this.nodesState[emptyPos + 1];
      this.nodesState[emptyPos + 1] = emptyValue;
      this.nodesState[0] = emptyPos + 1;
      return true;
    }
    return false;
  }

}