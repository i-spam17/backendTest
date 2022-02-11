package com.gb.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({
        "username",
        "start-date",
        "end-date",
        "hash"})
public class ShoppingListRequest {
    @JsonProperty("username")
    public String username;
    @JsonProperty("start-date")
    public String startDate;
    @JsonProperty("end-date")
    public String endDate;
    @JsonProperty("hash")
    public String hashData;
}
