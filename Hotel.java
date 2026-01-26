import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HotelRoom r1 = new HotelRoom(307, 4);
        HotelRoom r2 = new HotelRoom(205, 3);
        r2.checkIn("Guest Test");
        HotelRoom r3 = new HotelRoom(402, 2);

        display(r1, r2, r3);

        System.out.println("\nHotel Menu:");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in to a room");
        System.out.println("3 - Check-out from a room");
        System.out.println("4 - Find available room by requested beds");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                displaySorted(r1, r2, r3);
                break;
            case 2:
                System.out.print("Enter room number: ");
                int roomIn = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter guest name: ");
                String name = scanner.nextLine();
                checkIn(name, roomIn, r1, r2, r3);
                break;
            case 3:
                System.out.print("Enter room number: ");
                int roomOut = scanner.nextInt();
                checkOut(roomOut, r1, r2, r3);
                break;
            case 4:
                System.out.print("Enter number of beds: ");
                int beds = scanner.nextInt();
                findAvailableByBeds(beds, r1, r2, r3);
                break;
            default:
                System.out.println("Error: Invalid menu choice");
        }
        
    }

    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        if (a.getRoomNum() == roomNum) return a;
        if (b.getRoomNum() == roomNum) return b;
        if (c.getRoomNum() == roomNum) return c;
        return null;
    }

    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom temp;
        if (b.before(a)) { temp = a; a = b; b = temp; }
        if (c.before(b)) { temp = b; b = c; c = temp; }
        if (b.before(a)) { temp = a; a = b; b = temp; }
        display(a, b, c);
    }

    public static void checkIn(String guestName, int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);
        if (room != null && room.checkIn(guestName)) {
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void checkOut(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);
        if (room != null) {
            room.checkOut();
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void findAvailableByBeds(int beds, HotelRoom a, HotelRoom b, HotelRoom c) {
        if (beds < 2 || beds > 4) {
            System.out.println("No available room with the requested number of beds");
            return;
        }
        
        if (!a.isOccupied() && a.getNumBeds() == beds) {
            System.out.println(a);
        } else if (!b.isOccupied() && b.getNumBeds() == beds) {
            System.out.println(b);
        } else if (!c.isOccupied() && c.getNumBeds() == beds) {
            System.out.println(c);
        } else {
            System.out.println("No available room with the requested number of beds");
        }
    }
}
