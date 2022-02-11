package com.gb.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UsersConnectDataRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
