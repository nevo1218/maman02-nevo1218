
public class HotelRoom {

    private static final int DEFAULT_ROOM_NUM = 999;
    private static final int DEFAULT_NUM_BEDS = 2;
    private static final int MIN_ROOM_NUM = 100;
    private static final int MAX_ROOM_NUM = 999;
    private static final int MIN_BEDS = 2;
    private static final int MAX_BEDS = 4;

    private int _roomNum;
    private int _numBeds;
    private boolean _occupied;
    private String _guest;

    public HotelRoom(int roomNum, int numBeds) {
        _roomNum = roomNumOk(roomNum) ? roomNum : DEFAULT_ROOM_NUM;
        _numBeds = numBedsOk(numBeds) ? numBeds : DEFAULT_NUM_BEDS;
        _occupied = false;
        _guest = "";
    }

    public int getRoomNum() {
        return _roomNum;
    }

    public int getNumBeds() {
        return _numBeds;
    }

    public boolean isOccupied() {
        return _occupied;
    }

    public String getGuest() {
        return _guest;
    }

   public void setRoomNum(int roomNum) {
    if (roomNumOk(roomNum)) {
        _roomNum = roomNum;
    }
    }

    public void setNumBeds(int numBeds) {
    if (numBedsOk(numBeds)) {
        _numBeds = numBeds;
    }
    }


    private boolean roomNumOk(int roomNum) {
        return roomNum >= MIN_ROOM_NUM
                && roomNum <= MAX_ROOM_NUM;
    }

    private boolean numBedsOk(int numBeds) {
        return numBeds >= MIN_BEDS
                && numBeds <= MAX_BEDS;
    }

    public boolean checkIn(String guest) {
        if (_occupied) {
            return false;
        }

        _occupied = true;
        _guest = guest;
        return true;
    }

    public void checkOut() {
        _occupied = false;
        _guest = "";
    }

    public boolean before(HotelRoom other) {
        return _roomNum < other._roomNum;
    }

    public boolean after(HotelRoom other) {
        return other.before(this);
    }

    public boolean equals(HotelRoom other) {
    if (other == null) {
        return false;
    }

    return _roomNum == other._roomNum
            && _numBeds == other._numBeds;
    }

    public String toString() {
        if (!_occupied) {
            return "Room " + _roomNum
                    + ", " + _numBeds
                    + " Beds: Available";
        }

        return "Room " + _roomNum
                + ", " + _numBeds
                + " Beds: Occupied by "
                + _guest;
    }
}
