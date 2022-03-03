
package com.gb.backend.dto.response;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nutrients"
})
@Generated("jsonschema2pojo")
public class NutritionSummary {

    @JsonProperty("nutrients")
    public List<Nutrient> nutrients = new ArrayList<Nutrient>();

}
