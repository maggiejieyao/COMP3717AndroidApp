package ca.bcit.explorenewwest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maggi on 2018-04-08.
 */

public class Place implements Serializable {
    private String aName;
    private int imgId;
    private String desc;
    //private String address;


    public Place(String aName, int imgId, String desc) {
        this.aName = aName;
        this.imgId = imgId;
        //this.address = address;
        this.desc = desc;
    }

    public int getImgId(){
        return imgId;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

}
