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
public class KazanApiResponseModel {

    @JsonAlias("updated_at")
    private String updatedAt;

    private KazanApiResponseDataModel data;
}
