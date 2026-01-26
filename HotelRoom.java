public class HotelRoom {

    private static final int DEFAULT_ROOM_NUM = 999;
    private static final int DEFAULT_NUM_BEDS = 2;
    private static final int MIN_ROOM_NUM = 100;
    private static final int MAX_ROOM_NUM = 999;
    private static final int MIN_BEDS = 2;
    private static final int MAX_BEDS = 4;

    private int roomNum;
    private int numBeds;
    private boolean occupied;
    private String guest;

    public HotelRoom(int roomNum, int numBeds) {
        this.roomNum = roomNumOk(roomNum) ? roomNum : DEFAULT_ROOM_NUM;
        this.numBeds = numBedsOk(numBeds) ? numBeds : DEFAULT_NUM_BEDS;
        this.occupied = false;
        this.guest = "";
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getGuest() {
        return guest;
    }

    public void setRoomNum(int roomNum) {
        if (roomNumOk(roomNum)) {
            this.roomNum = roomNum;
        }
    }

    public void setNumBeds(int numBeds) {
        if (numBedsOk(numBeds)) {
            this.numBeds = numBeds;
        }
    }

    private boolean roomNumOk(int roomNum) {
        return roomNum >= MIN_ROOM_NUM && roomNum <= MAX_ROOM_NUM;
    }

    private boolean numBedsOk(int numBeds) {
        return numBeds >= MIN_BEDS && numBeds <= MAX_BEDS;
    }

    public boolean checkIn(String guest) {
        if (occupied) {
            return false;
        }
        occupied = true;
        this.guest = guest;
        return true;
    }

    public void checkOut() {
        occupied = false;
        guest = "";
    }

    public boolean before(HotelRoom other) {
        return roomNum < other.roomNum;
    }

    public boolean after(HotelRoom other) {
        return other.before(this);
    }

    public boolean equals(HotelRoom other) {
        return roomNum == other.roomNum && numBeds == other.numBeds;
    }

    public String toString() {
        if (!occupied) {
            return "Room " + roomNum + ", " + numBeds + " Beds: Available";
        }
        return "Room " + roomNum + ", " + numBeds +
               " Beds: Occupied by " + guest;
    }
}
