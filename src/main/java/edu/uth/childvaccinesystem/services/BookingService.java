import java.util.ArrayList;
import java.util.List;

package edu.uth.childvaccinesystem.services;


public class BookingService {

    private List<Booking> bookings;

    public BookingService() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    public Booking getBookingById(int id) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }

    public boolean cancelBooking(int id) {
        return bookings.removeIf(booking -> booking.getId() == id);
    }
}
