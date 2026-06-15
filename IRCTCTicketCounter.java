public class IRCTCTicketCounter {

    public static void main(String[] args) {
        int[] coachManifestPnrs = {402135, 789541, 102458, 556321, 889412};

        int targetQueryA = 102458;
        int targetQueryB = 999999;

        int resultIndexA = performLinearSearch(coachManifestPnrs, targetQueryA);
        int resultIndexB = performLinearSearch(coachManifestPnrs, targetQueryB);

        System.out.println("Searching for PNR: " + targetQueryA);
        if (resultIndexA != -1) {
            System.out.println(" -> SUCCESS: Ticket found at manifest chart index position: " + resultIndexA);
        } else {
            System.out.println(" -> ALERT: Invalid PNR. Ticket not registered in this coach.");
        }

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Searching for PNR: " + targetQueryB);
        if (resultIndexB != -1) {
            System.out.println(" -> SUCCESS: Ticket found at manifest chart index position: " + resultIndexB);
        } else {
            System.out.println(" -> ALERT: Invalid PNR. Ticket not registered in this coach.");
        }
    }

    public static int performLinearSearch(int[] dataset, int targetKey) {
        for (int index = 0; index < dataset.length; index++) {

            if (dataset[index] == targetKey) {
                return index;
            }
        }
        return -1;
    }
}