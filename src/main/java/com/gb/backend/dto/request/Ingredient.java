package com.gb.backend.dto.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient extends CommonRequest {
    @Builder.Default
    @JsonProperty("name")
    public String name = faker.food().ingredient();

    @Builder.Default
    @JsonProperty("unit")
    public String unit = faker.letterify("??? ???? ????");

    @Builder.Default
    @JsonProperty("amount")
    public String amount = faker.numerify("#");

    @Builder.Default
    @JsonProperty("image")
    public String image = faker.internet().domainName();
}
