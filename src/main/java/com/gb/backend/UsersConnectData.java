package com.gb.backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UsersConnectData {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
