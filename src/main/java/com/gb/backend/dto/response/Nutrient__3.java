
package com.gb.backend.dto.response;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "amount",
    "unit",
    "percentOfDailyNeeds"
})
@Generated("jsonschema2pojo")
public class Nutrient__3 {

    @JsonProperty("name")
    public String name;
    @JsonProperty("amount")
    public Float amount;
    @JsonProperty("unit")
    public String unit;
    @JsonProperty("percentOfDailyNeeds")
    public Integer percentOfDailyNeeds;

}
