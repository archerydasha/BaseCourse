package com.basecourse.model;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FeedInstance {
    private String fileName;

    public FeedInstance(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != FeedInstance.class) {
            return false;
        }
        FeedInstance otherInstance = (FeedInstance) o;
        return otherInstance.getFileName().equals(this.getFileName());
    }
}
