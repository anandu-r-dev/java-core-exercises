
class ServerNode {
    String nodeIp;

    public static int totalActiveNodes = 0;

    public void initializeNode(String ipAddress) {
        this.nodeIp = ipAddress;
        totalActiveNodes++;
    }
}

public class ClusterNodeManager {

    public static void main(String[] args) {
        System.out.println("Starting Cloud Infrastructure Monitoring Console...");
        System.out.println("Initial Cluster Active Count: " + ServerNode.totalActiveNodes);
        System.out.println("--------------------------------------------------");

        ServerNode nodeA = new ServerNode();
        nodeA.initializeNode("192.168.1.10");

        System.out.println("Node A deployed. Individual IP: " + nodeA.nodeIp);
        System.out.println("Current Global Cluster Count   : " + ServerNode.totalActiveNodes);
        System.out.println("--------------------------------------------------");

        ServerNode nodeB = new ServerNode();
        nodeB.initializeNode("192.168.1.20");

        System.out.println("Node B deployed. Individual IP: " + nodeB.nodeIp);
        System.out.println("Global Cluster Count (via Class) : " + ServerNode.totalActiveNodes);
        System.out.println("Global Cluster Count (via Node A): " + nodeA.totalActiveNodes);
        System.out.println("Global Cluster Count (via Node B): " + nodeB.totalActiveNodes);
        System.out.println("--------------------------------------------------");

        System.out.println("Verifying IP Isolation Check:");
        System.out.println(" Node A Address: " + nodeA.nodeIp);
        System.out.println(" Node B Address: " + nodeB.nodeIp);
    }
}