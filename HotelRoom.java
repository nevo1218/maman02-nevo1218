/**
 * Represents a room in a hotel.
 */
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
        if (roomNum >= MIN_ROOM_NUM && roomNum <= MAX_ROOM_NUM) {
            _roomNum = roomNum;
        } else {
            _roomNum = DEFAULT_ROOM_NUM;
        }

        if (numBeds >= MIN_BEDS && numBeds <= MAX_BEDS) {
            _numBeds = numBeds;
        } else {
            _numBeds = DEFAULT_NUM_BEDS;
        }
        _occupied = false;
        _guest = "";
    }

    public HotelRoom(HotelRoom other) {
        if (other != null) {
            _roomNum = other._roomNum;
            _numBeds = other._numBeds;
            _occupied = other._occupied;
            _guest = other._guest;
        }
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
        if (roomNum >= MIN_ROOM_NUM && roomNum <= MAX_ROOM_NUM) {
            _roomNum = roomNum;
        }
    }

    public void setNumBeds(int numBeds) {
        if (numBeds >= MIN_BEDS && numBeds <= MAX_BEDS) {
            _numBeds = numBeds;
        }
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
        if (other == null) {
            return false;
        }
        return _roomNum < other._roomNum;
    }

    public boolean after(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return _roomNum > other._roomNum;
    }

    public boolean equals(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return _roomNum == other._roomNum && _numBeds == other._numBeds;
    }

    public String toString() {
        String res = "Room " + _roomNum + ", " + _numBeds + " Beds: ";
        if (!_occupied) {
            return res + "Available";
        }
        return res + "Occupied by " + _guest;
    }
}
