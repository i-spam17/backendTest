package com.gb.backend.dto.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gb.backend.Helpers;
import lombok.*;

@Data
@Builder
public class AddToMealPlan extends CommonRequest {
    @Builder.Default
    @JsonProperty("date")
    public Integer date = Helpers.currentDataToInt("2022-03-01");

    @Builder.Default
    @JsonProperty("slot")
    public Integer slot = faker.number().randomDigitNotZero();

    @Builder.Default
    @JsonProperty("position")
    public Integer position = faker.number().randomDigit();;

    @Builder.Default
    @JsonProperty("type")
    public String type = "RECIPE";

    @Builder.Default
    @JsonProperty("value")
    public Value value = Value.builder().build();

}
