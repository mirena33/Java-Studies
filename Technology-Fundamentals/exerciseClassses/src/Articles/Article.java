package Articles;

public class Article {

    private String title;
    private String content;
    private String author;



    public Article(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String content) {
        this.content = content;
    }

    public void changeAuthor(String author) {
        this.author = author;
    }

    public void rename(String title) {
        this.title = title;
    }

    public String getTitle(String title){
        return this.title;
    }

    public String getContent(String content){
        return this.content;
    }

    public String getAuthor(String author){
        return this.author;
    }


    @Override
    public String toString() {
        return String.format("%s - %s: %s", getTitle(title), getContent(content), getAuthor(author));
    }
}
