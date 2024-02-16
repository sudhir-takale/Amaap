
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomHandler {
    Scanner scanner = new Scanner(System.in);
    List<Room> freeRoomList = new ArrayList<Room>();

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            String roomName = "Room" + i;
            Room room = new Room(roomName, true);
            Room.rooms.add(room);
        }

        RoomHandler roomHandler = new RoomHandler();
        while (true) {

            System.out.println("1 for view available rooms\n2 for book room");
            int choice = new Scanner(System.in).nextInt();
            if (choice == 1)
                roomHandler.showFreeRoom();
            else if (choice == 2)
                System.out.println(roomHandler.bookNewRoom());
            else if (choice == 3)
                break;
            else
                System.out.println("Your choice is wrong");

        }

    }

    public void showFreeRoom() {

        System.out.println("Showing available rooms");
        for (Room room : Room.rooms) {

            if (room.isStatus()) {
                freeRoomList.add(room);
                System.out.print(room.getRoomName() + " | ");
            }
        }
        System.out.println();

    }

    public String bookNewRoom() {

        System.out.println("Choose your Room");

        System.out.println("Available Room Names : ");
        for (Room room : freeRoomList) {
            System.out.print(room.getRoomName() + " | ");
        }
        System.out.println();
        System.out.println("Enter room Name");
        String roomName = scanner.nextLine();

        System.out.println("Enter client id");
        String clientId = scanner.nextLine();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter your arrival Date dd/MM/yyyy:");
        String arrival = scanner.next();
        LocalDate arrivalDate = LocalDate.parse(arrival, dateFormatter);

        System.out.println("Enter your departure Date dd/MM/yyyy:");
        String departure = scanner.next();
        LocalDate departureDate = LocalDate.parse(departure, dateFormatter);

        for (Room room : freeRoomList) {

            if (room.getRoomName().equalsIgnoreCase(roomName))
                room.setStatus(false);
        }

        return ("Room has been Booked Successfully." + " Your Room Name is " + roomName +
                " You need to free room on/before " + departureDate);
    }

    public void makeRoomsFree() {
        Booking book = new Booking();
        for (Room room : Room.rooms) {

            if (book.getDepartureDate().equals(LocalDate.now())) {
                room.setStatus(true);
            }
        }

    }

}
