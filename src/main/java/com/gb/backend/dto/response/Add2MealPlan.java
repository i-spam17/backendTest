
package com.gb.backend.dto.response;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nutritionSummary",
    "nutritionSummaryBreakfast",
    "nutritionSummaryLunch",
    "nutritionSummaryDinner",
    "date",
    "day",
    "items"
})
@Generated("jsonschema2pojo")
@Data
public class Add2MealPlan {
    @JsonProperty("nutritionSummary")
    public NutritionSummary nutritionSummary;
    @JsonProperty("nutritionSummaryBreakfast")
    public NutritionSummaryBreakfast nutritionSummaryBreakfast;
    @JsonProperty("nutritionSummaryLunch")
    public NutritionSummaryLunch nutritionSummaryLunch;
    @JsonProperty("nutritionSummaryDinner")
    public NutritionSummaryDinner nutritionSummaryDinner;
    @JsonProperty("date")
    public Integer date;
    @JsonProperty("day")
    public String day;
    @JsonProperty("items")
    public List<Item> items = new ArrayList<Item>();

}
