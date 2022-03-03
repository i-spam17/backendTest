
package com.gb.backend.dto.response;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "servings",
    "title",
    "imageType",
    "image",
    "ingredients"
})
@Generated("jsonschema2pojo")
public class Value {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("servings")
    public Integer servings;
    @JsonProperty("title")
    public String title;
    @JsonProperty("imageType")
    public String imageType;
    @JsonProperty("image")
    public String image;
    @JsonProperty("ingredients")
    public List<Ingredient> ingredients = new ArrayList<Ingredient>();

}
