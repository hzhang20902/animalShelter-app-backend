package com.shelterapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HouseDto {

    private LocalDateTime submitTimestamp;

    private UUID volunteerId;

    private boolean hCleanGroomRoom;

    private boolean hEmptyWashKongs;

    private boolean hOrganizeVolArea;

    private boolean hLaundry;

    private boolean hGroundskeeping;


}
