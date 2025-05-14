package com.example.tuwaiqfinalproject.Controller;

import com.example.tuwaiqfinalproject.Api.ApiResponse;
import com.example.tuwaiqfinalproject.Model.Booking;
import com.example.tuwaiqfinalproject.Model.User;
import com.example.tuwaiqfinalproject.Service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    //ADMIN
    @GetMapping("/all")
    public ResponseEntity<?> getAllBookings() {
        return ResponseEntity.status(200).body(bookingService.getAllBookings());
    }

    //ADMIN
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(bookingService.getBookingById(id));
    }

    //PLAYER
    @GetMapping("/my")
    public ResponseEntity<?> getMyBookings(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(200).body(bookingService.getMyBookings(user.getId()));
    }

    //PLAYER
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBooking(@AuthenticationPrincipal User user, @PathVariable Integer id, @RequestBody @Valid Booking booking) {
        bookingService.updateBooking(user.getId(), id, booking);
        return ResponseEntity.status(200).body(new ApiResponse("Booking updated successfully"));
    }

    //ADMIN
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.status(200).body(new ApiResponse("Booking deleted successfully"));
    }

    //PLAYER
    @PostMapping("/private-match/{privateMatchId}")
    public ResponseEntity<?> bookPrivateMatch(@AuthenticationPrincipal User user, @PathVariable Integer privateMatchId) {
        bookingService.bookPrivateMatch(user.getId(), privateMatchId);
        return ResponseEntity.status(200).body(new ApiResponse("Private match booked successfully"));
    }

    //PLAYER
    @PostMapping("/public-match/{publicMatchId}")
    public ResponseEntity<?> bookPublicMatch(@AuthenticationPrincipal User user, @PathVariable Integer publicMatchId) {
        bookingService.bookPublicMatch(user.getId(), publicMatchId);
        return ResponseEntity.status(200).body(new ApiResponse("Public match booked successfully"));
    }

    //PLAYER
    @GetMapping("/getBookingPublicMatch")
    public ResponseEntity<?> getMyBookingForPublicMatch(@AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(bookingService.getMyBookingForPublicMatch(user.getId()));
    }

}
