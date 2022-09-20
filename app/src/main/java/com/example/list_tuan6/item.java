package com.example.list_tuan6;

public class item
{
    private String itemName;
    private String images_dinner;
    private String itemInfo;
    public item(String itemName,String images_dinner,String itemInfo){
        this.itemName=itemName;
        this.images_dinner=images_dinner;
        this.itemInfo=itemInfo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImages_dinner() {
        return images_dinner;
    }

    public void setImages_dinner(String images_dinner) {
        this.images_dinner = images_dinner;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }
}
