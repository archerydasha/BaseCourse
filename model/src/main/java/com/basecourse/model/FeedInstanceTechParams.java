package com.basecourse.model;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FeedInstanceTechParams {
    private String checksum;

    public FeedInstanceTechParams(String checksum) {
        this.checksum = checksum;
    }

    public String getChecksum() {
        return checksum;
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(o.getClass() != FeedInstanceTechParams.class){
            return false;
        }
        FeedInstanceTechParams otherParams = (FeedInstanceTechParams)o;
        return otherParams.getChecksum().equals(this.getChecksum());
    }
}
