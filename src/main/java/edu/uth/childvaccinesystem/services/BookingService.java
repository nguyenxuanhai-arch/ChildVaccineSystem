package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Booking;
import edu.uth.childvaccinesystem.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setChildId(bookingDetails.getChildId());
            booking.setVaccineId(bookingDetails.getVaccineId());
            booking.setAppointmentDate(bookingDetails.getAppointmentDate());
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Booking not found with id " + id);
        }
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
