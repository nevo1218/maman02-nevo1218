public class HotelNevo1218Tester {
    public static void main(String[] args) {
        
        HotelRoom r1 = new HotelRoom(307, 4);
        HotelRoom r2 = new HotelRoom(205, 3);
        HotelRoom r3 = new HotelRoom(402, 2);

        System.out.println("--- Testing findRoomByNumber ---");
        System.out.println("1. Find exists (307): " + (Hotel.findRoomByNumber(307, r1, r2, r3) != null));
        System.out.println("2. Find exists (205): " + (Hotel.findRoomByNumber(205, r1, r2, r3) != null));
        System.out.println("3. Find exists (402): " + (Hotel.findRoomByNumber(402, r1, r2, r3) != null));
        System.out.println("4. Find non-exists (101): " + (Hotel.findRoomByNumber(101, r1, r2, r3) == null));
        System.out.println("5. Find invalid (0): " + (Hotel.findRoomByNumber(0, r1, r2, r3) == null));
        System.out.println();

        System.out.println("--- Testing displaySorted ---");
        System.out.println("1. Original: 307, 205, 402");
        Hotel.displaySorted(r1, r2, r3); 
        System.out.println("2. Already sorted: 100, 200, 300");
        Hotel.displaySorted(new HotelRoom(100, 2), new HotelRoom(200, 2), new HotelRoom(300, 2));
        System.out.println("3. Reverse order: 300, 200, 100");
        Hotel.displaySorted(new HotelRoom(300, 2), new HotelRoom(200, 2), new HotelRoom(100, 2));
        System.out.println("4. Middle smallest: 200, 100, 300");
        Hotel.displaySorted(new HotelRoom(200, 2), new HotelRoom(100, 2), new HotelRoom(300, 2));
        System.out.println("5. Two same rooms: 100, 100, 200");
        Hotel.displaySorted(new HotelRoom(100, 2), new HotelRoom(100, 3), new HotelRoom(200, 2));
        System.out.println();

        System.out.println("--- Testing checkIn (Static) ---");
        System.out.print("1. Valid check-in: ");
        Hotel.checkIn("Alice", 307, r1, r2, r3);
        System.out.print("2. Room occupied: ");
        Hotel.checkIn("Bob", 307, r1, r2, r3);
        System.out.print("3. Room not found: ");
        Hotel.checkIn("Charlie", 999, r1, r2, r3);
        System.out.print("4. Check-in to another: ");
        Hotel.checkIn("Dana", 402, r1, r2, r3);
        System.out.print("5. Case sensitive name check: ");
        System.out.println(r1.getGuest().equals("Alice"));
        System.out.println();

        System.out.println("--- Testing checkOut (Static) ---");
        System.out.print("1. Valid check-out (307): ");
        Hotel.checkOut(307, r1, r2, r3);
        System.out.print("2. Valid check-out (402): ");
        Hotel.checkOut(402, r1, r2, r3);
        System.out.print("3. Check-out already free: ");
        Hotel.checkOut(205, r1, r2, r3);
        System.out.print("4. Room not found: ");
        Hotel.checkOut(555, r1, r2, r3);
        System.out.print("5. Verify status (307): ");
        System.out.println(!r1.isOccupied());
        System.out.println();

        System.out.println("--- Testing findAvailableByBeds ---");
        r1.checkOut(); r2.checkOut(); r3.checkOut(); 
        System.out.print("1. Find 4 beds (307): ");
        Hotel.findAvailableByBeds(4, r1, r2, r3);
        System.out.print("2. Find 3 beds (205): ");
        Hotel.findAvailableByBeds(3, r1, r2, r3);
        Hotel.checkIn("Temp", 307, r1, r2, r3);
        System.out.print("3. Find 4 beds (now occupied): ");
        Hotel.findAvailableByBeds(4, r1, r2, r3);
        System.out.print("4. Invalid bed count (5): ");
        Hotel.findAvailableByBeds(5, r1, r2, r3);
        System.out.print("5. No match available (1 bed): ");
        Hotel.findAvailableByBeds(1, r1, r2, r3);
    }
}


