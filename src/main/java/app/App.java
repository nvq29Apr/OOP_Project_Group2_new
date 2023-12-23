package app;

import collectors.nft.NFTsCollector;
import collectors.post.TweetsCollector;
import java.io.IOException;

/**
 *
 * @author quyetdaika
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        NFTsCollector nftCollector = new NFTsCollector();
        nftCollector.active();

        TweetsCollector tweetCollector = new TweetsCollector();
        tweetCollector.active();
    }
}
