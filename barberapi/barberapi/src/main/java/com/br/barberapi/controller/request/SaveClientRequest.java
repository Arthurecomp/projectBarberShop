package com.br.barberapi.controller.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Email;



public record SaveClientRequest(
        @NotNull
        @JsonProperty("name")
        String name,
        @NotNull
        @Email
        @JsonProperty("email")
        String email,
        @NotNull
        @JsonProperty("phone")
        String phone
) {}