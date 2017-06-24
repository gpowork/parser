package gpo.result;

import java.math.BigDecimal;

/**
 * Created by gpowork on 24/06/2017.
 */
public class ParsedProduct {
    private String title;
    private String defaultImage;
    private String description;

    private BigDecimal rate1w;
    private BigDecimal rate1m;
    private BigDecimal deposite;

    private String url;

    public ParsedProduct(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRate1w() {
        return rate1w;
    }

    public void setRate1w(BigDecimal rate1w) {
        this.rate1w = rate1w;
    }

    public BigDecimal getDeposite() {
        return deposite;
    }

    public void setDeposite(BigDecimal deposite) {
        this.deposite = deposite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getRate1m() {
        return rate1m;
    }

    public void setRate1m(BigDecimal rate1m) {
        this.rate1m = rate1m;
    }

    public String toString() {
        return title + ", (" + rate1w + ", " + rate1m +", " + deposite + "): " + description;
    }
}
