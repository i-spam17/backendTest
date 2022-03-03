
package com.gb.backend.dto.response;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "amount"
})
@Generated("jsonschema2pojo")
public class Ingredient {

    @JsonProperty("name")
    public String name;
    @JsonProperty("amount")
    public Float amount;

}
