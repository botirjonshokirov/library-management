package org.example;

public class SingleBook {
    private String id;
    private String title;
    private String author;
    private String published_Year;
    private String status;

    public SingleBook(String id, String title, String author, String published_Year, String status){
        this.id = id;
        this.title = title;
        this.author = author;
        this.published_Year = published_Year;
        this.status = status;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    };
    public void setAuthor(String author){
        this.author = author;
    }

    public String getPublished_Year(){
        return published_Year;
    }
    public void setPublished_Year(String published_Year){
        this.published_Year = published_Year;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString(){
        return  "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published_Year='" + published_Year + '\''+
                ", status='" + status + '\'' +
                '}';
    }
}