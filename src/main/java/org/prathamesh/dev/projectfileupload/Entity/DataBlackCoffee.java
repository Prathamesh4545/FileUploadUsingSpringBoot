package org.prathamesh.dev.projectfileupload.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataBlackCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int end_year;
    private String citylng;
    private String citylat;
    private int intensity;
    private String sector;
    private String topic;
    @Column(length = 500)
    private String insight;
    private String swot;
    @Column(length = 500)
    private String url;
    private String region;
    private String start_year;
    private String impact;
    private String added;
    private String published;
    private String city;
    private String country;
    private int relevance;
    private String pestle;
    private String source;
    @Column(length = 500)
    private String title;
    private int likelihood;

    public DataBlackCoffee(int endYear, String citylng, String citylat, int intensity, String sector, String topic, String insight, String swot, String url, String region, String startYear, String impact, String added, String published, String city, String country, int relevance, String pestle, String source, String title, int likelihood) {
        this.end_year = endYear;
        this.region = region;
        this.citylng = citylng;
        this.citylat = citylat;
        this.intensity = intensity;
        this.sector = sector;
        this.topic = topic;
        this.insight = insight;
        this.swot = swot;
        this.url = url;
        this.start_year = startYear;
        this.impact = impact;
        this.added = added;
        this.published = published;
        this.city = city;
        this.country = country;
        this.relevance = relevance;
        this.pestle = pestle;
        this.source = source;
        this.title = title;
        this.likelihood = likelihood;
    }
}
