package com.fenger.sys.utils;

public class DtreeNode {
//    "id":"001","title": "湖南省","checkArr": "0","parentId": "0","spread":false
    private Integer id;
    private String title;
    private String checkArr;
    private Integer parentId;
    private Boolean spread;
    private String iconClass;

    public DtreeNode(Integer id, String title, String checkArr, Integer parentId, Boolean spread, String iconClass) {
        this.id = id;
        this.title = title;
        this.checkArr = checkArr;
        this.parentId = parentId;
        this.spread = spread;
        this.iconClass = iconClass;
    }

    public DtreeNode() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCheckArr() {
        return checkArr;
    }

    public void setCheckArr(String checkArr) {
        this.checkArr = checkArr;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }
}
