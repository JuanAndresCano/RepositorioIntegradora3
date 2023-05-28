package model;

import java.util.Calendar;


public abstract class Product {
    private String id;
    private String name;
    private int numOfPages;
    private Calendar publicationDate;
    private String url;
    private int acumReadedPages;

    /**
     * Description: It is the constructor of the class Product.
     * @param name String It is the name of the product.
     * @param numOfPages int It is the amount of pages of the product.
     * @param publicationDate Calendar It is the date when registered the product.
     */
    public Product(String id,String name, int numOfPages){
        this.id = id;
        this.name = name;
        this.numOfPages = numOfPages;
        this.publicationDate = Calendar.getInstance();
        this.url = "";
        this.acumReadedPages = 0;
    }

    /**
     * Description: It is the getter of the id.
     * @return id String It is the id.
     */
    public String getId() {
        return id;
    }
    
    /**
     * Description: It is the getter of the name.
     * @return name String Is the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Description: It is the setter of the name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description: It is the getter of the numOfPages.
     * @return numOfPages int It is the amount of pages of the products.
     */
    public int getNumOfPages() {
        return numOfPages;
    }

    /**
     * Description: It is the setter of the numOfPages.
     * @param numOfPages int It is the amount of pages of the products.
     */
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    /**
     * Description: It is the getter of the publicationDate.
     * @return publicationDate Calendar It is the date when the product was published.
     */
    public Calendar getPublicationDate() {
        return publicationDate;
    }

    /**
     * Description: It is the getter of the url.
     * @return url String It is the url of product.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Description: It is the setter of the url.
     * @param url String It is the url of products.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Description: It is the amount of the pages readed.
     * @return acumReadedPages int It is the amount of pages readed.
     */
    public int getAcumReadedPages() {
        return acumReadedPages;
    }

    /**
     * Description: It is the setter of the amount of readed pages.
     * @param acumReadedPages int It is the amount of readed pages.
     */
    public void setAcumReadedPages(int acumReadedPages) {
        this.acumReadedPages = acumReadedPages;
    }

    /**
     * Description: This method updates the amount of readed pages.
     * @param newReadedPages int It is the readed pages of a session.
     */
    public void upToDateReadedPages(int newReadedPages) {
        this.acumReadedPages = getAcumReadedPages() + newReadedPages;
    }

    /**
     * The function increments the number of pages read.
     */
    public void newReadedPage(){
        this.acumReadedPages++;
    }

}

