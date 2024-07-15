package com.jonasdurau.api_escola.dtos;

import java.time.LocalDate;

public record UserDTO(
    String name,
    String cpf,
    String rg,
    String phone1,
    String phone2,
    String email,
    LocalDate birthdate,
    String street,
    String neighborhood,
    String city,
    String state,
    String country,
    String password
) {}
