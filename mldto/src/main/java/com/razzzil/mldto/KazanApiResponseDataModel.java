package com.razzzil.mldto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KazanApiResponseDataModel {

    @JsonAlias("GaragNumb")
    private String garagNumb;

    @JsonAlias("Marsh")
    private String marsh;

    @JsonAlias("Graph")
    private String graph;

    @JsonAlias("Smena")
    private String smena;

    @JsonAlias("TimeNav")
    private String timeNav;

    @JsonAlias("Latitude")
    private String latitude;

    @JsonAlias("Longitude")
    private String longitude;

    @JsonAlias("Speed")
    private String speed;

    @JsonAlias("Azimuth")
    private String azimuth;
}
