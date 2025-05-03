/*
    Class taking care of cinema seats layout
    It creates layout, print layout and can update layout
    if someone buy seats
 */

package cinema;


public class SeatLayout {
    private String[][] layout;

    public SeatLayout() {

    }

    // setting new layout

    public void setLayout(String[][] layout) {
        this.layout = layout;
    }

    // printing layout

    public void printLayout() {
        for (String[] row : this.layout) {
            for (String element : row) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
        System.out.println();
    }

    // create layout based on assignment template

    public void createLayoutArr() {
        for (int i = 0; i < this.layout.length; i++) {
            for (int j = 0; j < this.layout[i].length; j++) {
                if (i + j == 0) {
                    this.layout[i][j] = " ";
                } else if (i + j == j) {
                    this.layout[i][j] = "" + j;
                } else if (i + j == i) {
                    this.layout[i][j] = "" + i;
                } else {
                    this.layout[i][j] = "S";
                }
            }
        }
    }

    // check if seat is not already bought and update seat that someone bought

    public boolean checkAndUpdateSeatsLayout(int rowNumber, int seatNumber) {

        if (this.layout[rowNumber][seatNumber].equals("B")) {
            return false;
        }
        this.layout[rowNumber][seatNumber] = "B";
        return true;
    }


}
