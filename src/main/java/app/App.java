package app;

import collectors.nft.NFTsCollector;
import collectors.post.BlogsCollector;
import collectors.post.TweetsCollector;
import java.io.IOException;
import views.Home;

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
        
        BlogsCollector blogCollector = new BlogsCollector();
        blogCollector.active();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}
