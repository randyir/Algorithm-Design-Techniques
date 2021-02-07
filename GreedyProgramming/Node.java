package greedy;
import java.util.ArrayList;

public class Node {
    private ArrayList<Node> branches = new ArrayList<Node>();
    private double weight;
    private double value;
    
    void addNewBranch(Node input) {
        branches.add(input);
    }
    
    ArrayList<Node> getBranchList() {
        return branches;
    }
    
    void setWeight(double weight) {
        this.weight = weight;
    }
    
    double getWeight() {
        return weight;
    }
    
    void setValue(double value) {
        this.value = value;
    }
    
    double getValue() {
        return this.value;
    }
}