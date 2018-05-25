package jigsaw;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * Implemente the N-Puzzle Problem 
 *
 * @author Nino Lau, SDCS, SYSU
 */
public class Jigsaw {
  JigsawNode beginJNode;   // Begin Node of Jigsaw
  JigsawNode endJNode;     // End Node of Jigsaw
  JigsawNode currentJNode; // Current Node of Jigsaw
  private Vector<JigsawNode> openList;     // open table：to store the node which has been found but not visited
  private Vector<JigsawNode> closeList;    // close table：to store the node which has been visited
  private Vector<JigsawNode> solutionPath; // Solution path: each state node from the initial state to the target state
  private boolean isCompleted;  // Completion mark: initial false, when the solution is successful, the tag is true
  private int searchedNodesNum; // Number of searched nodes: to record the number of nodes that have been searched

  /**
   * Constructor
   *
   * @param bNode - begin node of Jigsaw
   * @param eNode - end node of Jigsaw
   */
  public Jigsaw(JigsawNode bNode, JigsawNode eNode) {
	// initialization
    this.beginJNode = new JigsawNode(bNode);
    this.endJNode = new JigsawNode(eNode);
    this.currentJNode = new JigsawNode(bNode);
    this.openList = new Vector<JigsawNode>();
    this.closeList = new Vector<JigsawNode>();
    this.solutionPath = null;
    this.isCompleted = false;
    this.searchedNodesNum = 0;
  }

  /**
   * Scatter Function
   * 
   * This function is used to scatter the jigsaw: the initial state node jNode is randomly moved to len step, returning 
   * the state node after it is scattered.
   *
   * @param jNode - beginState jNode
   * @param len   - random length
   * @return the nodes after scattered
   */
  public static JigsawNode scatter(JigsawNode jNode, int len) {
    int randomDirection;
    len += (int) (Math.random() * 2);
    JigsawNode jigsawNode = new JigsawNode(jNode);
    for (int t = 0; t < len; t++) {
      int[] movable = jigsawNode.canMove();
      do {
        randomDirection = (int) (Math.random() * 4);
      } while (0 == movable[randomDirection]);
      jigsawNode.move(randomDirection);
    }
    jigsawNode.setInitial();
    return jigsawNode;
  }

  /**
   * Get Current Node
   *
   * @return currentJNode - current node of Jigsaw
   */
  public JigsawNode getCurrentJNode() {
    return currentJNode;
  }

  /**
   * Set Begin Node
   *
   * @param jNode - begin node of Jigsaw
   */
  public void setBeginJNode(JigsawNode jNode) {
    beginJNode = jNode;
  }

  /**
   * Get Begin Node
   *
   * @return beginJNode - begin node of Jigsaw
   */
  public JigsawNode getBeginJNode() {
    return beginJNode;
  }

  /**
   * Set End Node
   *
   * @param jNode - end node of Jigsaw
   */
  public void setEndJNode(JigsawNode jNode) {
    this.endJNode = jNode;
  }

  /**
   * Get End Node
   *
   * @return endJNode - end node of Jigsaw
   */
  public JigsawNode getEndJNode() {
    return endJNode;
  }

  /**
   * Get Complete State
   *
   * @return isCompleted - the complete state
   */
  public boolean isCompleted() {
    return isCompleted;
  }

  /**
   * Calculate Solution Path
   *
   * if Jigsaw is completed currently, store the solution path(the path from begin node to current node)
   * @return true if it's completed, false else
   */
  private boolean calSolutionPath() {
    if (!this.isCompleted()) {
      return false;
    } else {
      JigsawNode jNode = this.currentJNode;
      solutionPath = new Vector<JigsawNode>();
      while (jNode != null) {
        solutionPath.addElement(jNode);
        jNode = jNode.getParent();
      }
      return true;
    }
  }

  /**
   * SolutionPath2String
   *
   * @return SolutionPath2String, true if it's completed, false else
   */
  public String getSolutionPath() {
    String str = new String();
    str += "Begin->";
    if (this.isCompleted) {
      for (int i = solutionPath.size() - 1; i >= 0; i--) {
        str += solutionPath.elementAt(i).toString() + "->";
      }
      str += "End";
    } else
      str = "Jigsaw Not Completed.";
    return str;
  }

  /**
   * Get Searched Nodes Num
   *
   * @return searchedNodesNum
   */
  public int getSearchedNodesNum() {
    return searchedNodesNum;
  }

  /**
   * Print Results
   * 
   * Write the search results to the file, and show that if a search fails in the console, 
   * the problem is not solved, and the number of nodes that have been accessed has been accessed.
   * If complete，print beginJnode, endJNode, searchedNodesNum, nodeDepth and solutionPath.
   *
   * @param pw - file output the PrintWriter class object, if pw is null, then write to Result.txt
   * @throws IOException
   */
  public void printResult(PrintWriter pw) throws IOException {
    boolean flag = false;
    if (pw == null) {
      pw = new PrintWriter(new FileWriter("Result.txt")); 
      flag = true;
    }
    if (this.isCompleted == true) {
      // write2file
      pw.println("Jigsaw Completed");
      pw.println("Begin state:" + this.getBeginJNode().toString());
      pw.println("End state:" + this.getEndJNode().toString());
      pw.println("Solution Path: ");
      pw.println(this.getSolutionPath());
      pw.println("Total number of searched nodes:" + this.getSearchedNodesNum());
      pw.println("Length of the solution path is:"
              + this.getCurrentJNode().getNodeDepth());

      // print2console
      System.out.println("Jigsaw Completed");
      System.out.println("Begin state:" + this.getBeginJNode().toString());
      System.out.println("End state:" + this.getEndJNode().toString());
      System.out.println("Solution Path: ");
      System.out.println(this.getSolutionPath());
      System.out.println("Total number of searched nodes:"
              + this.getSearchedNodesNum());
      System.out.println("Length of the solution path is:"
              + this.getCurrentJNode().getNodeDepth());

    } else {
      // write2file
      pw.println("No solution. Jigsaw Not Completed");
      pw.println("Begin state:" + this.getBeginJNode().toString());
      pw.println("End state:" + this.getEndJNode().toString());
      pw.println("Total number of searched nodes:" + this.getSearchedNodesNum());

      // print2console
      System.out.println("No solution. Jigsaw Not Completed");
      System.out.println("Begin state:" + this.getBeginJNode().toString());
      System.out.println("End state:" + this.getEndJNode().toString());
      System.out.println("Total number of searched nodes:"
              + this.getSearchedNodesNum());
    }
    if (flag)
      pw.close();
  }
  
  /**
   * Find Adjacent JNode
   * 
   * Find all nodes that are adjacent to jNode (top, bottom, left, right).
   *
   * @param jNode - jNode
   * @return Vector<JigsawNode> that are adjacent to jNode
   */
  private Vector<JigsawNode> findAdjacentJNodes(JigsawNode jNode) {
    Vector<JigsawNode> adjacentJNodes = new Vector<JigsawNode>();
    JigsawNode tempJNode;
    for (int i = 0; i < 4; i++) {
      tempJNode = new JigsawNode(jNode);
      if (tempJNode.move(i))
        adjacentJNodes.addElement(tempJNode);
    }
    return adjacentJNodes;
  }

  /**
   * Find Follow JNode
   * 
   * Find all nodes that are adjacent to jNode (top, bottom, left, right) and never accessed.
   *
   * @param jNode - jNode
   * @return Vector<JigsawNode> that are adjacent to jNode and that are not visited
   */
  private Vector<JigsawNode> findFollowJNodes(JigsawNode jNode) {
    Vector<JigsawNode> followJNodes = new Vector<JigsawNode>();
    JigsawNode tempJNode;
    for (int i = 0; i < 4; i++) {
      tempJNode = new JigsawNode(jNode);
      if (tempJNode.move(i) && !this.closeList.contains(tempJNode)
              && !this.openList.contains(tempJNode))
        followJNodes.addElement(tempJNode);
    }
    return followJNodes;
  }

  /**
   * Insert JNode into the Open List
   * 
   * The jNode inserted into openList: the node is inserted into the openList according to the estimated value of the node.
   *
   * @param jNode - jNode
   */
  private void sortedInsertOpenList(JigsawNode jNode) {
    this.estimateValue(jNode);
    for (int i = 0; i < this.openList.size(); i++) {
      if (jNode.getEstimatedValue() < this.openList.elementAt(i)
              .getEstimatedValue()) {
        this.openList.insertElementAt(jNode, i);
        return;
      }
    }
    this.openList.addElement(jNode);
  }

  /**
   * BFS Method
   * 
   * Breadth first search algorithm to solve the optimal solution of 3*3 jigsaw (8-digital problem). 
   * isCompleted, openList, closeList, searchedNodesNum, solutionPath is renewed in this method.
   *
   * @return isCompleted
   * @throws IOException
   */
  public boolean BFSearch() throws IOException {
	// write2file
    PrintWriter pw = new PrintWriter(new FileWriter("BFSearchDialog.txt"));

    // ******************** BFS starts!!! ********************
    
    // update the currentNode
    currentJNode = beginJNode;
    
    // add current jNode to the openList(the found but not visited nodes list)
    openList.addElement(currentJNode);
    
    while (!openList.isEmpty()) {
    	
      // if reach the final
      if (currentJNode.equals(endJNode)) {
        isCompleted = true;
        calSolutionPath();
        break;
      } 
      
      // else continue
      else {
    	// get the adjacent nodes but not visisted nodes of jNode and add them to openList
        Vector<JigsawNode> child = findFollowJNodes(currentJNode);
        for (JigsawNode ch : child) {
          openList.addElement(ch);
        }
        
        // remove current jNode in the openList
        openList.removeElement(currentJNode);
        
        // add current jNode in the closeList
        closeList.addElement(currentJNode);
        // to BFS the nodes in openList
        // Attention!
        // The order here in openList is determined by findFollowJNodes() - in direction(UP, DOWN, LEFT, RIGHT).
        // Not in the order of estimated value.
        currentJNode = openList.firstElement();
        
        // searchedNodesNum++
        searchedNodesNum++;
      }
    }
    
    // ******************** BFS ends!!! ********************
    
    // print2console
    this.printResult(pw);
    pw.close();
    System.out.println("Record into BFSearchDialog.txt");
    return isCompleted;
  }

  /**
   * ASearch using Heuristic Search Method
   * 
   * Heuristic search to make the searchedNodesNum not greater than 30,000.
   * isCompleted, openList, closeList, searchedNodesNum, solutionPath is renewed in this method.
   *
   * @return true if success, false else
   * @throws IOException
   */
  public boolean ASearch() throws IOException {
    PrintWriter pw = new PrintWriter(new FileWriter("ASearchDialog.txt"));

    // maxNodesNum is 30 thousand
    int maxNodesNum = 30000;

    // follow nodes of a jNode
    Vector<JigsawNode> followJNodes = new Vector<JigsawNode>();

    // initialize isCompleted as false
    isCompleted = false;
    
    // ******************** ASearch starts!!! ********************

    // 1.Insert the beginJNode into the openList
    this.sortedInsertOpenList(this.beginJNode);

    // 2.If openList is empty, or the searchedNodesNum excceeds maxNodesNum, the search fails. Otherwise, the loop continue.
    while (this.openList.isEmpty() != true && searchedNodesNum <= maxNodesNum) {
    	
      // set the first element in openList to currentJNode
      this.currentJNode = this.openList.elementAt(0);
      
      // if reach the final
      if (this.currentJNode.equals(this.endJNode)) {
        isCompleted = true;
        this.calSolutionPath();
        break;
      }

      // remove the currentNode from the openList
      this.openList.removeElementAt(0);
      
      // add the currentNode to the closeList
      this.closeList.addElement(this.currentJNode);
      
      // searchedNodesNum++
      searchedNodesNum++;

      // write2file
      pw.println("Searching.....Number of searched nodes:"
              + this.closeList.size() + "   Current state:"
              + this.currentJNode.toString());
      System.out.println("Searching.....Number of searched nodes:"
              + this.closeList.size() + "   Current state:"
              + this.currentJNode.toString());

      // findFollowJNodes and then insert the nodes into openList in the order of estimated value
      followJNodes = this.findFollowJNodes(this.currentJNode);
      while (!followJNodes.isEmpty()) {
        this.sortedInsertOpenList(followJNodes.elementAt(0));
        followJNodes.removeElementAt(0);
      }
    }
    
    // ******************** ASearch ends!!! ********************

    // print2console
    this.printResult(pw); 
    pw.close(); 
    System.out.println("Record into " + "ASearchDialog.txt");
    return isCompleted;
  }

  /**
   * Calculate and Modify the Estimated Value of JNodes
   * 
   * Calculate and modify the cost estimate of the state node jNode.
   * f(n) = uncorrect(n) + depth(n) + Manhattan(n)
   * uncorrect(n): the number of the following uncorrected nodes 
   * depth(n): the steps from beginJNode to Node
   * manhattan(n): manhattan distance from a position of currentJNode to endJNode
   *
   * @param jNode - taget node - this method has a side-effect that can vary the estimated value of target value
   */
  private void estimateValue(JigsawNode jNode) {
	  
	int dimension = JigsawNode.getDimension();
	
    int uncorrectAfter = 0;    // the uncorrected following nodes
    int uncorrectPlace = 0;    // the current position get wrong place
    int manhattanDistance = 0; // Manhattan distance
    int distance = 0;          // geometric distance
    final int predictRate = 10;      // the proportion of predict value of 100
    final int estimateRate = 90;     // the proportion of estimate value of 100
    int predictValue = 0;      // the predict value of jNode according to its neighbor
    
    for (int index = 1; index < dimension * dimension; index++) {
    
      // add the number of the uncorrected following nodes
      if (jNode.getNodesState()[index]+1 != jNode.getNodesState()[index+1]) {
    	  uncorrectAfter++;
      }
      
      // add the current position get wrong place
      if (jNode.getNodesState()[index] != index && index != jNode.getNodesState()[0]) {
			uncorrectPlace++;
			int currentX = (index-1) / dimension;
			int currentY = (index-1) % dimension;
			int targetX = (jNode.getNodesState()[index]-1) / dimension;
			int targetY = (jNode.getNodesState()[index]-1) % dimension;
			// get the Manhattan distance
			manhattanDistance += Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
			// get the geometric distance
			distance += Math.sqrt(Math.abs(currentX - targetX)) + Math.sqrt(Math.abs(currentY - targetY));
      }
    }
    // initialized estimated
    int estimate = (int) (uncorrectAfter * 3 + manhattanDistance * 7 + distance * 2 + uncorrectPlace * 0);
    
    // ******************** Enhanced Estimate Begins ********************
    
    // find the adjacent nodes
    Vector<JigsawNode> adjacentJNodes = new Vector<JigsawNode>();
    adjacentJNodes = this.findAdjacentJNodes(jNode);
    int predictValueSum = 0;     // the predict value sum of the neighbors who has been estimated
    int predictDepthSum = 0;     // the predict depth sum of the neighbors who has been estimated
    
    // the neighbors
    for (JigsawNode ad : adjacentJNodes) {
    	// neighbor who has been estimated, avoid recursive - huge work!!!
    	if (ad.getEstimatedValue() != 0) {
    		// Deep depth deserve a higher predict proportion:
    		// As the estimate value of deep-depth node has a smaller estimate value in average.
    		predictValueSum = predictValueSum + ad.getEstimatedValue() * ad.getNodeDepth();
    		predictDepthSum = predictDepthSum + ad.getNodeDepth();
    	}
     }
    
    // refresh the estimated value in proportion
    if (predictValueSum != 0 && predictDepthSum != 0) {
    	predictValue = (int) (predictValueSum / predictDepthSum);
    	estimate = (int) ((estimate * estimateRate + predictValue * predictRate) / (estimateRate + predictRate));
    }
    
    // ******************** Enhanced Estimate Ends ********************
    
    // assign new estimated value to the node
    jNode.setEstimatedValue(estimate);
  }

}