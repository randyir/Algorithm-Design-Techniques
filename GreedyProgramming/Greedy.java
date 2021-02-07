package greedy;
import java.util.ArrayList;

public class Greedy {
    public static void main(String[] args) {
    ArrayList<Node> nodes = new ArrayList<>();
        Node nodeA = new Node();
        nodeA.setWeight(5);
        nodeA.setValue(28);
        
        Node nodeB = new Node();
        nodeB.setWeight(3);
        nodeB.setValue(16);
        
        Node nodeC = new Node();
        nodeC.setWeight(2);
        nodeC.setValue(14);
        
        Node nodeD = new Node();
        nodeD.setWeight(1);
        nodeD.setValue(7);
        
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);

        Method greedy = new Method(8, nodes);
        greedy.startCheck();
    }
}
