package com.football.organiser.server.models;

import java.util.List;
import java.util.Map;

public class Game {
    private Location location;
    private List<String> players;
    private List<Map> comments?;
    private String uuid;
    private String gameName;
    private String dateTime?;
    private String details;
    private String listingTime;
    private Boolean payment?;
    private PaymentOptions paymentAmount;
    private Boolean scheduleGameRegularly;
    private String scheduleDateTime?;
    private String teamName;
    private String description?;
}
