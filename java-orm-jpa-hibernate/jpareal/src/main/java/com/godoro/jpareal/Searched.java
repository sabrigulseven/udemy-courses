package com.godoro.jpareal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(indexes = {
        @Index(columnList = "searchedName"),
        @Index(name = "myindex", columnList = "searchedName"),
        @Index(columnList = "searchedCount", unique = true),
        @Index(columnList = "searchedCount,searchedName")
},

        uniqueConstraints = @UniqueConstraint(columnNames = "singularName")

)
public class Searched {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long searchedId;
    private String searchedName;
    private double searchedValue;
    private int searchedCount;
    private String singularName;

    public long getSearchedId() {
        return searchedId;
    }

    public void setSearchedId(long searchedId) {
        this.searchedId = searchedId;
    }

    public String getSearchedName() {
        return searchedName;
    }

    public void setSearchedName(String searchedName) {
        this.searchedName = searchedName;
    }

    public double getSearchedValue() {
        return searchedValue;
    }

    public void setSearchedValue(double searchedValue) {
        this.searchedValue = searchedValue;
    }

    public int getSearchedCount() {
        return searchedCount;
    }

    public void setSearchedCount(int searchedCount) {
        this.searchedCount = searchedCount;
    }

    public String getSingularName() {
        return singularName;
    }

    public void setSingularName(String singularName) {
        this.singularName = singularName;
    }

}
