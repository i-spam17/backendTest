package com.gb.backend.dto.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Value extends CommonRequest {

    @Builder.Default
    @JsonProperty("ingredients")
    public List<Ingredient> ingredients = new ArrayList< Ingredient> (Collections.singleton(Ingredient.builder().build()));

    @Builder.Default
    @JsonProperty("id")
    public Integer id = faker.number().numberBetween(100000, 999999);

    @Builder.Default
    @JsonProperty("servings")
    public Integer servings = faker.number().numberBetween(1, 9);

    @Builder.Default
    @JsonProperty("title")
    public String title = faker.letterify("??? ???? ????");

    @Builder.Default
    @JsonProperty("image")
    public String image = faker.letterify("??? ???? ????");

    @Builder.Default
    @JsonProperty("imageType")
    public String imageType = faker.letterify("???");

}
