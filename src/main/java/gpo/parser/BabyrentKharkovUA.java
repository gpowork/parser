package gpo.parser;

import gpo.result.ParsedProduct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by gpowork on 24/06/2017.
 */
public class BabyrentKharkovUA {

    private static String basePath = "http://babyrent.kharkov.ua/";
    private static String allProductsURL = basePath + "index.php?main_page=products_all&page=";
    private static String productPageURL = basePath + "index.php?main_page=product_info&products_id=";
    private int pageNumber = 0;
    private int currentLinkPosition = 0;

    private Document document = null;
    private Elements elements = null;

    private void getListOfProducts() throws IOException {
        document = Jsoup.connect(allProductsURL + (pageNumber++)).get();
        currentLinkPosition = 0;
        elements = null;
        if (document != null) {
            elements = document.getElementsByClass("product");
            for(Element el: elements) {
                System.out.println(el.tag());
            }
        }
    }

    public boolean hasNext() throws IOException {
        if (pageNumber == 0 || (elements != null && elements.size() == currentLinkPosition))
            getListOfProducts();
        return elements != null && currentLinkPosition < elements.size();
    }

    private BigDecimal parseRate1w(String text) {
        return null;
    }

    private BigDecimal parseRate1m(String text) {
        return null;
    }

    private BigDecimal parseDeposit(String text) {
        return null;
    }

    public ParsedProduct parseProduct() throws IOException {
        Elements links =  elements.get(currentLinkPosition++)
                .getElementsByClass("link");
        if (links != null && !links.isEmpty()) {
            String productURL = links
                                    .get(0)
                                    .attr("href");
            System.out.println(productURL);
            Document productPage = Jsoup.connect(productURL).get();
            if (productPage != null) {
                ParsedProduct p = new ParsedProduct(productURL);
                Element title = productPage.getElementById("productName");
                if (title != null)
                    p.setTitle(title.text());
                Element prices = productPage.getElementById("productPrices");
                if (prices != null) {
                    p.setRate1w(parseRate1w(prices.text()));
                    p.setRate1m(parseRate1m(prices.text()));
                    p.setDeposite(parseDeposit(prices.text()));
                }
                Element description = productPage.getElementById("productDescription");
                if (description != null)
                    p.setDescription(description.text());
                Element imgDiv = productPage.getElementById("productMainImage");
                if (imgDiv != null) {
                    Elements imgs = imgDiv.getElementsByTag("img");
                    if (imgs != null && !imgs.isEmpty()) {
                        Element img = imgs.get(0);
                        if (img != null && img.attr("src") != null)
                            p.setDefaultImage(basePath + img.attr("src"));
                    }
                }
                return p;
            }
        }
        return null;
    }

}
