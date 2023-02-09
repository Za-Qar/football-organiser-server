package com.football.organiser.server.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String latLng;
    private String searchValue;
}
