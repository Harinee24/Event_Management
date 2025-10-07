package com.example.event.service;

import com.example.event.dto.BookingDTO;
import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    BookingDTO createBooking(BookingDTO bookingDTO);
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
    void deleteBooking(Long id);
    BookingDTO confirmBooking(Long id);
    List<BookingDTO> getBookingsByUserId(Long userId);
}
