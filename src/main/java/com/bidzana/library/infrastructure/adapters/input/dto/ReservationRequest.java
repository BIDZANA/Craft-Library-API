package com.bidzana.library.infrastructure.adapters.input.dto;

import jakarta.validation.constraints.NotBlank;

public record ReservationRequest(
        @NotBlank(message = "L'ISBN est obligatoire")
        String isbn
) {}