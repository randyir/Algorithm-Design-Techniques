package greedy;
import java.util.ArrayList;
import java.util.Collections;

public class Method {
    double capacity;
    
    Node init;
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Node> usedNodes = new ArrayList<>();
        
    public Method(double capacity, ArrayList<Node> nodes) {
        this.capacity = capacity;
        this.nodes = nodes;
    }

    void setInit() {
        Node currentHighestWeight = new Node();
        for (int i = 0; i < nodes.size(); i++) {
            if (currentHighestWeight.getWeight() != 0) {
                if (nodes.get(i).getWeight() > currentHighestWeight.getWeight()) {
                    if (nodes.get(i).getWeight() <= capacity) {
                        currentHighestWeight = nodes.get(i);
                    }
                }
            } else {
                currentHighestWeight = nodes.get(i);
            }
        }

        this.init = currentHighestWeight;
    }

    Node checkNextNodes(double input) {
        Node currentHighestNode = new Node();
        for (int i = 1; i < nodes.size(); i++) {
            if (currentHighestNode.getWeight() != 0) {
                if (nodes.get(i).getWeight() > currentHighestNode.getWeight()) {
                    if (nodes.get(i).getWeight() <= input) {
                        currentHighestNode = nodes.get(i);
                    }
                }
            } else {
                currentHighestNode = nodes.get(i);
            }
        }

        for(int i = 0; i < usedNodes.size(); i++) {
            if(currentHighestNode == usedNodes.get(i)) {
                currentHighestNode = null;
            }
        }       
        return currentHighestNode;
    }

    void startCheck() {
        setInit();        
        if (init.getWeight() == capacity) {
            usedNodes.add(init);
            System.out.println("Selected: " + init.getWeight());
        } else if (init.getWeight() < capacity) {
            usedNodes.add(init);
            
            double currentCapacity = capacity - init.getWeight();
            boolean canFitMore = true;

            do {
                Node nextNode = checkNextNodes(currentCapacity);
                if (nextNode != null) {
                    currentCapacity -= nextNode.getWeight();
                    usedNodes.add(nextNode);
                } else {
                    canFitMore = false;
                }
            } while (canFitMore);
            
            System.out.print("Selected: ");
            for(int i = 0; i < usedNodes.size(); i++) {
                System.out.print(usedNodes.get(i).getWeight() + " ");
            }
        }
    }
}