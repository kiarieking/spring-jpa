package com.kingara.First_project.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="fileinfo")
public class FileInfo {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fileinfo generator")
    @SequenceGenerator(name = "fileinfo generator", sequenceName = "fileinfo generator", allocationSize = 50)
    private Long id;
    @Column(name = "filename")
    private String filename;
    @Column(name = "url")
    private String url;

    public FileInfo(String filename, String url) {
        this.filename = filename;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
