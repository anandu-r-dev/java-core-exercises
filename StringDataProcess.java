public class StringDataProcess {
    public static void processApiData(String payload){
        try{
            int weight = Integer.parseInt(payload);
            System.out.println("Parsed weight: " + weight + " kg");

        }catch (NumberFormatException e){
            System.out.println("Error: Corrupted API payload received");
        }finally {
            System.out.println("API connection closed");
        }

    }
    public static void main (String[] args){
        String validPayload = "85";
        String corruptPayload = "Eighty";

        processApiData(validPayload);
        processApiData(corruptPayload);
    }
}
