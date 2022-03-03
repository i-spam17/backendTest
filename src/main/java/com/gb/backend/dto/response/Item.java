
package com.gb.backend.dto.response;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "slot",
    "position",
    "type",
    "value"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("slot")
    public Integer slot;
    @JsonProperty("position")
    public Integer position;
    @JsonProperty("type")
    public String type;
    @JsonProperty("value")
    public Value value;

}
