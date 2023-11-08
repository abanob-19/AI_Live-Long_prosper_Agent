package AI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GenericSearch {
    private Problem problem;
    private SearchStrategy searchStrategy;
    private int numExpandedNodes=0;
    private boolean visualize;

    public boolean isVisualize() {
        return visualize;
    }

    public void setVisualize(boolean visualize) {
        this.visualize = visualize;
    }


    public int getNumExpandedNodes() {
        return numExpandedNodes;
    }

    public void setNumExpandedNodes(int numExpandedNodes) {
        this.numExpandedNodes = numExpandedNodes;
    }



    public GenericSearch(Problem problem, SearchStrategy searchStrategy) {
        this.problem = problem;
        this.searchStrategy = searchStrategy;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public SearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
    public Node SolveGenericSearch (){
        Node initialNode= new Node(problem.getInitialState(),null,null,0,0,0);
        List<Node> nodesBF_DF=null;
        PriorityQueue<Node> nodesUC_GR1_GR2_AS1_AS2=null;
        if (searchStrategy== SearchStrategy.BF|| searchStrategy== SearchStrategy.DF )
        {
            return BF_DFSearch(initialNode);
        }
        else if(searchStrategy==SearchStrategy.UC){
            nodesUC_GR1_GR2_AS1_AS2=new PriorityQueue<>((node1,node2)->node1.getPathCost()-node2.getPathCost());
        }
        else if (searchStrategy==SearchStrategy.GR1) {
            nodesUC_GR1_GR2_AS1_AS2=new PriorityQueue<>((node1,node2)->node1.getHeuristicValue()-node2.getPathCost());
        }
        else if (searchStrategy==SearchStrategy.GR2) {

        }
        else if (searchStrategy==SearchStrategy.AS1) {

        }
        else {

        }




    }

    private Node BF_DFSearch(Node initialNode){
        List<Node> nodesBF_DF=null;

        nodesBF_DF=new ArrayList<Node>();
        nodesBF_DF.add(initialNode);

        while(!(nodesBF_DF.isEmpty())) {
            Node current = nodesBF_DF.removeFirst();
            numExpandedNodes++;
            if (goalTest(current))
                return current;
            List<Node> tempNodes = expand(current);

            for (int i = 0; i < 6; i++) {
                if (searchStrategy == SearchStrategy.BF) {
                    if (tempNodes.get(i) != null) {
                        nodesBF_DF.add(tempNodes.get(i));
                    }
                }
                if (searchStrategy == SearchStrategy.DF) {
                    if (tempNodes.get(5 - i) != null) {
                        nodesBF_DF.addFirst(tempNodes.get(5 - i));
                    }
                }
            }
        }
        return null;
    }

    private Node IDSearch(Node initialNode){


        int currentMaxLevel=0;
        for(int j=0;j<Integer.MAX_VALUE;j++) {
            for (int i = 0; i <= currentMaxLevel; i++) {

                List<Node> nodesID = null;
                nodesID = new ArrayList<Node>();
                nodesID.add(initialNode);
                while (!(nodesID.isEmpty())) {
                    Node current = nodesID.removeFirst();
                    numExpandedNodes++;
                    if (goalTest(current))
                        return current;

                    //check if we reached tha max level
                    if (current.getDepth() == currentMaxLevel) {
                        break;
                    }

                    List<Node> tempNodes = expand(current);
                    for (int j = 0; j < 6; j++) {
                        if (tempNodes.get(5 - j) != null) {
                            nodesID.addFirst(tempNodes.get(5 - j));
                        }
                    }
                }

                return null;
            }
            currentMaxLevel++;
        }

    }

    public Node iterativeDeepeningSearch(Node root) {
        int depth = 0;
        while (true) {
            NodeIDResultPair result = depthLimitedSearch(root, depth);
            if (result.getResult() == IDResult.GOAL_FOUND) {
                return result.getNode();
            } else if (result.getResult() == IDResult.CUTOFF) {
                depth++;
            } else if (result.getResult() == IDResult.FAILURE) {
                return null;
            }
        }
    }

    public  NodeIDResultPair depthLimitedSearch(Node node, int depth) {
        if (goalTest(node)) {
            return new NodeIDResultPair(node,IDResult.GOAL_FOUND);
        } else if (depth == 0) {
            return new NodeIDResultPair(node,IDResult.CUTOFF);
        } else {
            boolean cutoffOccurred = false;
            for (Node child : expand(node)) {
                NodeIDResultPair result = depthLimitedSearch(child, depth - 1);
                if (result.getResult() == IDResult.CUTOFF) {
                    cutoffOccurred = true;
                } else if (result.getResult() == IDResult.GOAL_FOUND) {
                    return new NodeIDResultPair(node,IDResult.GOAL_FOUND);
                }
            }
            if (cutoffOccurred) {
                return new NodeIDResultPair(node,IDResult.CUTOFF);
            } else {
                return new NodeIDResultPair(node,IDResult.FAILURE);
            }
        }
    }

    public  ArrayList<Node> expand(Node current) {
        ArrayList<Node> tempNodes = new ArrayList<>();
        Node node1 = Actions.requestFood(current, visualize);
        Node node2 = Actions.requestMaterials(current, visualize);
        Node node3 = Actions.requestEnergy(current, visualize);
        Node node4 = Actions.wait(current, visualize);
        Node node5 = Actions.build1(current, visualize);
        Node node6 = Actions.build2(current, visualize);
        tempNodes.add(node1);
        tempNodes.add(node2);
        tempNodes.add(node3);
        tempNodes.add(node4);
        tempNodes.add(node5);
        tempNodes.add(node6);
        return tempNodes;
    }
    private boolean goalTest(Node testNode){
        if(testNode.getState().getCurrentProsperity()>=100 && testNode.getState().getMoneySoFar()<=100000 )
           return true;
        return false;
    }
}