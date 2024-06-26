package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
		}
		
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException  e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
