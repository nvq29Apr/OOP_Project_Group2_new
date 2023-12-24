package dataprocessors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.ConstantVar;
import models.NFT;
import models.Tweet;

/**
 *
 * @author quyetdaika
 */
public interface GetDataFromJson extends ConstantVar {
    Gson gson = new Gson();
    default List<NFT> getNFTsFromJson(){
        List<NFT> nfts = null;
        try (FileReader reader = new FileReader(NFT_JSON_PATH)) {
            Type type = new TypeToken<List<NFT>>() {}.getType();
            nfts = gson.fromJson(reader, type);
        } catch (Exception e) {
            
        }
        return nfts;
    }
    
    default Set<String> getUniqueNFTNameToSearch(){
        Set<String> uniqueNames = new HashSet<>();
        List<NFT> nfts = getNFTsFromJson();
        for(NFT x : nfts){
            String name = x.getName().split(":|-")[0];
            uniqueNames.add(name.trim());
        }
        return uniqueNames;
    }
    
    default List<Tweet> getTweetsFromJson(){
        List<Tweet> tweets = null;
        try (FileReader reader = new FileReader(TWEET_JSON_PATH)) {
            Type type = new TypeToken<List<Tweet>>() {}.getType();
            tweets = gson.fromJson(reader, type);
        } catch (Exception e) {
            
        }
        return tweets;
    }
}
