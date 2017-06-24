package gpo.parser;

import gpo.result.ParsedProduct;

import java.io.IOException;

/**
 * Created by gpowork on 24/06/2017.
 */
public class ParserRunner {

    public static void main(String... args) throws IOException {
        BabyrentKharkovUA parser = new BabyrentKharkovUA();
        System.out.println("Parsing of " + parser.basePath + " started...");
        while(parser.hasNext()) {
            ParsedProduct p = parser.parseProduct();
            if (p != null)
                System.out.println(p);
        }
    }
}
