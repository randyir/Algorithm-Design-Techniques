import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    ArrayList<Integer> weights = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();
   
    int capacity;
   
    Node init;

    public static void main(String[] args) {
        Backtracking bt = new Backtracking();
        bt.backtrack();
    }

    public Backtracking() {
        weights.add(5);
        weights.add(3);
        weights.add(2);
        weights.add(1);

        values.add(28);
        values.add(16);
        values.add(14);
        values.add(7);

        capacity = 8;
    }

    public void backtrack() {
        ArrayList<Integer> usedWeights = new ArrayList<>();
        int capacityLeft = capacity;
        int finalValue = 0;
        setInitNode();

        do {
            Node checkedNode = new Node(0, 0);
            if (init.getBranches().isEmpty()) {
                checkedNode = init;
            } else {
                for (int i = 0; i < init.getBranches().size(); i++) {
                    if (init.getBranches().get(i).getStatus() == 0) {
                        checkedNode = init.getBranches().get(i);
                        i = init.getBranches().size();
                    }
                    Node branchToCheck = init;

                    while (checkedNode == new Node(0, 0)) {
                        for (int j = 0; j < branchToCheck.getBranches().size(); j++) {
                            if (branchToCheck.getBranches().get(j).getStatus() == 0) {
                                checkedNode = branchToCheck.getBranches().get(j);
                            }
                        }
                        if (checkedNode == new Node(0, 0)) {
                            for (int j = 0; j < branchToCheck.getBranches().size(); j++) {
                                if (!branchToCheck.getBranches().get(j).getBranches().isEmpty()) {
                                    for (int k = 0; k < branchToCheck.getBranches().get(j).getBranches().size(); k++) {
                                        if (branchToCheck.getBranches().get(j).getBranches().get(k).getStatus() == 0) {
                                            branchToCheck = branchToCheck.getBranches().get(j).getBranches().get(k);
                                            k = branchToCheck.getBranches().get(j).getBranches().size();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            boolean didSubstracted = false;

            for (int i = 0; i < values.size(); i++) {
                System.out.println("Capacity Left: " + capacityLeft);
                System.out.println("Weights: " + weights.get(i));
                if (capacityLeft >= weights.get(i)) {
                    boolean isWeightUsed = false;
                    if (usedWeights.size() > 0) {
                        for (int j = 0; j < usedWeights.size(); j++) {
                            if (weights.get(i) == usedWeights.get(j)) {
                                isWeightUsed = true;
                            }
                        }
                    }

                    if (!isWeightUsed) {
                        checkedNode.addBranch(new Node(weights.get(i), values.get(i)));
                        capacityLeft -= weights.get(i);
                        usedWeights.add(weights.get(i));
                        finalValue += values.get(i);
                        i = values.size();
                        didSubstracted = true;
                    }
                }
                System.out.println("Branch Size: " + checkedNode.getBranches().size());
                System.out.println();
            }

            if (!didSubstracted) {
                capacityLeft -= capacityLeft;
            }
        } while (capacityLeft > 0);

        System.out.println();
        System.out.print("Used Weights: ");
        for (int i = 0; i < usedWeights.size(); i++) {
            System.out.print(usedWeights.get(i));
            if (i != usedWeights.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
        }

        System.out.println();
        System.out.println("Final value: " + finalValue);
    }

    public void setInitNode() {
        init = new Node(0, 0);
    }
}

class Node {

    private int weight;
    private int value;
    private int status = 0;
    
    private ArrayList<Node> branches = new ArrayList<>();
 
    private Node parent;

    public Node(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public Node(int weight, int value, Node parent) {
        this.weight = weight;
        this.value = value;
        this.parent = parent;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public int getStatus() {
        return status;
    }

    public ArrayList<Node> getBranches() {
        return branches;
    }

    public Node getParent() {
        return parent;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addBranch(Node branch) {
        branches.add(branch);
    }

    public void setChecked() {
        this.status = 1;
    }
}
