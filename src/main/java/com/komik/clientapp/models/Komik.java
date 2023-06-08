package com.komik.clientapp.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Komik {
    private int id;
    private String title;
    private String slug;
    private String img;
    private Date releasedDate;
    private String typeKomik;
}
