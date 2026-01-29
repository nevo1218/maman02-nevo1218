import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HotelRoom a = new HotelRoom(307, 4);
        HotelRoom b = new HotelRoom(205, 3);
        b.checkIn("Guest Test");
        HotelRoom c = new HotelRoom(402, 2);

        display(a, b, c);

        System.out.println();
        System.out.println("Hotel Menu :");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in to a room");
        System.out.println("3 - Check-out from a room");
        System.out.println("4 - Find available room by requested beds");
        System.out.println("Enter your choice :");

        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                displaySorted(a, b, c);
                break;
            case 2:
                System.out.print("Enter room number: ");
                int roomNum = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter guest name: ");
                String guest = scan.nextLine();
                checkIn(guest, roomNum, a, b, c);
                break;
            case 3:
                System.out.print("Enter room number: ");
                roomNum = scan.nextInt();
                checkOut(roomNum, a, b, c);
                break;
            case 4:
                System.out.print("Enter number of beds: ");
                int beds = scan.nextInt();
                findAvailableByBeds(beds, a, b, c);
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

    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom x = a, y = b, z = c, temp;

        if (y.before(x)) { 
            temp = x; 
            x = y; 
            y = temp; 
        }
        if (z.before(y)) { 
            temp = y;
            y = z;
            z = temp;
        }
        if (y.before(x)) {
            temp = x;
            x = y;
            y = temp; 
        }

        display(x, y, z);
    }

    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        if (a.getRoomNum() == roomNum){ 
        return a;
        }
        if (b.getRoomNum() == roomNum){
            return b;
        }
        if (c.getRoomNum() == roomNum) {
        return c;
        }
        return null;
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
