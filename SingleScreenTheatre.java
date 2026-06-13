public class SingleScreenTheatre {

    public static void main(String[] args) {
        int[][] seatingGrid = new int[3][];

        seatingGrid[0] = new int[2];
        seatingGrid[1] = new int[4];
        seatingGrid[2] = new int[5];

        seatingGrid[0][1] = 1;
        seatingGrid[1][0] = 1;
        seatingGrid[1][2] = 1;
        seatingGrid[2][4] = 1;

        System.out.println("=== SINGLE SCREEN THEATRE LIVE SEATING MAP ===");
        System.out.println("----------------------------------------------");

        for (int row = 0; row < seatingGrid.length; row++) {
            System.out.print("Row " + row + " Layout: ");

            for (int seat = 0; seat < seatingGrid[row].length; seat++) {

                int bookingStatus = seatingGrid[row][seat];

                if (bookingStatus == 1) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[O] ");
                }
            }

            System.out.println();
        }
        System.out.println("----------------------------------------------");
        System.out.println("Map Key: [O] Available  |  [X] Reserved Booked");
    }
}