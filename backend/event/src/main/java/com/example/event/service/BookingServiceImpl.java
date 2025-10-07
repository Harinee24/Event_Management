package com.example.event.service;

import com.example.event.dto.BookingDTO;
import com.example.event.model.Booking;
import com.example.event.model.Event;
import com.example.event.model.User;
import com.example.event.repository.BookingRepository;
import com.example.event.repository.EventRepository;
import com.example.event.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              EventRepository eventRepository,
                              UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = convertToEntity(bookingDTO);
        Booking saved = bookingRepository.save(booking);
        return convertToDTO(saved);
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        return bookingRepository.findById(id)
                .map(existing -> {
                    existing.setNumberOfSeats(bookingDTO.getNumberOfSeats());
                    existing.setStatus(bookingDTO.getStatus());

                    // Update Event and User if needed
                    eventRepository.findById(bookingDTO.getEventId())
                            .ifPresent(existing::setEvent);
                    userRepository.findById(bookingDTO.getUserId())
                            .ifPresent(existing::setUser);

                    Booking updated = bookingRepository.save(existing);
                    return convertToDTO(updated);
                })
                .orElse(null);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    // Helper methods
    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setEventId(booking.getEvent() != null ? booking.getEvent().getId() : null);
        dto.setUserId(booking.getUser() != null ? booking.getUser().getId() : null);
        dto.setNumberOfSeats(booking.getNumberOfSeats());
        dto.setStatus(booking.getStatus());
        dto.setEventName(booking.getEvent() != null ? booking.getEvent().getTitle() : null);
        dto.setUsername(booking.getUser() != null ? booking.getUser().getUsername() : null);
        return dto;
    }

    private Booking convertToEntity(BookingDTO dto) {
        Booking booking = new Booking();
        booking.setNumberOfSeats(dto.getNumberOfSeats());
        booking.setStatus(dto.getStatus());

        if (dto.getEventId() != null) {
            eventRepository.findById(dto.getEventId())
                    .ifPresent(booking::setEvent);
        }

        if (dto.getUserId() != null) {
            userRepository.findById(dto.getUserId())
                    .ifPresent(booking::setUser);
        }

        return booking;
    }

    @Override
    public BookingDTO confirmBooking(Long id) {
        return bookingRepository.findById(id)
                .map(existing -> {
                    existing.setStatus("CONFIRMED");
                    Booking updated = bookingRepository.save(existing);
                    return convertToDTO(updated);
                })
                .orElse(null);
    }
    @Override
    public List<BookingDTO> getBookingsByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);

        return bookings.stream().map(booking -> new BookingDTO(
                booking.getId(),
                booking.getEvent().getId(),
                booking.getUser().getId(),
                booking.getNumberOfSeats(),
                booking.getStatus(),
                booking.getEvent().getTitle(), // assuming your Event entity has title
                booking.getUser().getUsername() // assuming your User entity has username
        )).collect(Collectors.toList());
    }


}
