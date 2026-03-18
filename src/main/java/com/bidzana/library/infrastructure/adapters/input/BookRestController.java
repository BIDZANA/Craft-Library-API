package com.bidzana.library.infrastructure.adapters.input;

import com.bidzana.library.domain.service.BookReservationService;
import com.bidzana.library.infrastructure.adapters.input.dto.ReservationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookReservationService reservationService;

    @PostMapping("/reserve")
    public ResponseEntity<Void> reserveBook(@RequestBody @Valid ReservationRequest request) {
        reservationService.reserveBook(request.isbn());
        return ResponseEntity.noContent().build(); // On répond 204 si tout va bien
    }
}