public class HotelRoomNevo1218Tester {
    public static void main(String[] args) {
        
        System.out.println("--- Testing Constructor ---");
        System.out.println("1. Valid (101, 2): " + new HotelRoom(101, 2));
        System.out.println("2. Invalid Room (50): " + new HotelRoom(50, 3));
        System.out.println("3. Invalid Beds (1): " + new HotelRoom(102, 1));
        System.out.println("4. Invalid Beds (5): " + new HotelRoom(103, 5));
        System.out.println("5. Both Invalid: " + new HotelRoom(1000, 6));
        System.out.println();

        HotelRoom testRoom = new HotelRoom(200, 3);

        System.out.println("--- Testing setRoomNum ---");
        testRoom.setRoomNum(150); System.out.println("1. Valid (150): " + testRoom.getRoomNum());
        testRoom.setRoomNum(99);  System.out.println("2. Invalid (99): " + testRoom.getRoomNum());
        testRoom.setRoomNum(100); System.out.println("3. Valid (100): " + testRoom.getRoomNum());
        testRoom.setRoomNum(1000);System.out.println("4. Invalid (1000): " + testRoom.getRoomNum());
        testRoom.setRoomNum(999); System.out.println("5. Valid (999): " + testRoom.getRoomNum());
        System.out.println();

        System.out.println("--- Testing setNumBeds ---");
        testRoom.setNumBeds(2); System.out.println("1. Valid (2): " + testRoom.getNumBeds());
        testRoom.setNumBeds(1); System.out.println("2. Invalid (1): " + testRoom.getNumBeds());
        testRoom.setNumBeds(4); System.out.println("3. Valid (4): " + testRoom.getNumBeds());
        testRoom.setNumBeds(5); System.out.println("4. Invalid (5): " + testRoom.getNumBeds());
        testRoom.setNumBeds(3); System.out.println("5. Valid (3): " + testRoom.getNumBeds());
        System.out.println();

        System.out.println("--- Testing checkIn ---");
        HotelRoom r = new HotelRoom(300, 2);
        System.out.println("1. Normal check-in: " + r.checkIn("Alice"));
        System.out.println("2. Already occupied: " + r.checkIn("Bob"));
        r.checkOut();
        System.out.println("3. After checkout: " + r.checkIn("Charlie"));
        System.out.println("4. Guest name saved: " + r.getGuest().equals("Charlie"));
        System.out.println("5. Occupied status: " + r.isOccupied());
        System.out.println();

        System.out.println("--- Testing checkOut ---");
        r.checkOut();
        System.out.println("1. Status after: " + r.isOccupied());
        System.out.println("2. Name cleared: '" + r.getGuest() + "'");
        r.checkOut();
        System.out.println("3. Double checkout: " + r.isOccupied());
        r.checkIn("Guest");
        r.checkOut();
        System.out.println("4. Status after re-checkin: " + r.isOccupied());
        System.out.println("5. Name cleared again: " + r.getGuest().isEmpty());
        System.out.println();

        System.out.println("--- Testing equals ---");
        HotelRoom base = new HotelRoom(100, 2);
        System.out.println("1. Same room: " + base.equals(new HotelRoom(100, 2)));
        System.out.println("2. Different num: " + base.equals(new HotelRoom(101, 2)));
        System.out.println("3. Different beds: " + base.equals(new HotelRoom(100, 3)));
        System.out.println("4. Both different: " + base.equals(new HotelRoom(200, 4)));
        base.checkIn("Dan");
        System.out.println("5. Different guest: " + base.equals(new HotelRoom(100, 2)));
        System.out.println();

        System.out.println("--- Testing before & after ---");
        HotelRoom low = new HotelRoom(100, 2);
        HotelRoom high = new HotelRoom(200, 2);
        System.out.println("1. 100 before 200: " + low.before(high));
        System.out.println("2. 200 before 100: " + high.before(low));
        System.out.println("3. 200 after 100: " + high.after(low));
        System.out.println("4. 100 after 200: " + low.after(high));
        System.out.println("5. Same room: " + low.before(new HotelRoom(100, 2)));
    }
}
