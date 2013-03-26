package com.retro.paysimple.connector.response;

public class PagingDetails {
    private Integer totalItems;
    private Integer page;
    private Integer itemsPerPage;
    
    public Integer getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }
    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
}
