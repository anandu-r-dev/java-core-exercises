class SecureContainer<T> {
    private T payload;

    public SecureContainer(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}

public class TransitCoreMatrix {

    public static void main(String[] args) {
        System.out.println("Activating Generic Data Transit Matrices...");
        System.out.println("---------------------------------------------------------");

        SecureContainer<String> textContainer = new SecureContainer<>("ENCRYPTED-SESSION-TOKEN");

        String textData = textContainer.getPayload();
        System.out.println("Text Container Payload: " + textData);


        System.out.println("---------------------------------------------------------");

        SecureContainer<Integer> metricContainer = new SecureContainer<>(404);

        Integer numericalData = metricContainer.getPayload();
        System.out.println("Metric Container Payload: " + numericalData);

        System.out.println("---------------------------------------------------------");
    }
}