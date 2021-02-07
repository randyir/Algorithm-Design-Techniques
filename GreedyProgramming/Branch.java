package greedy;
import java.util.ArrayList;

public class Branch {
    ArrayList<Node> branches = new ArrayList<Node>();    
    void addNewBranch(Node input) {
        branches.add(input);
    }
    
    ArrayList<Node> getBranchList() {
        return branches;
    }
}