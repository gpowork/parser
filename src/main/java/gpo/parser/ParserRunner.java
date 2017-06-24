package gpo.parser;

import java.io.IOException;

/**
 * Created by gpowork on 24/06/2017.
 */
public class ParserRunner {

    public static void main(String... args) throws IOException {
        BabyrentKharkovUA parser = new BabyrentKharkovUA();
        while(parser.hasNext()) {
            System.out.println(parser.parseProduct());
        }
    }
}
