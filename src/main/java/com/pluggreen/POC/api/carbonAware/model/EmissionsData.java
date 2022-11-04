package com.pluggreen.POC.api.carbonAware.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EmissionsData {
    private String location;
    @SerializedName(value="timestamp", alternate = "time")
    private String timestamp;
    private String duration;
    @SerializedName(value="value", alternate = "rating")
    private Double value;
}
