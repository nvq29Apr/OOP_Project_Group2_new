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
}
