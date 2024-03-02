# Collecting and Analyzing NFTs
_Project of Object-oriented Programming course_
## Introduction
### NFT
A non-fungible token (NFT) is a unique digital identifier that is recorded on a blockchain and is used to certify ownership and authenticity. It cannot be copied, substituted, or subdivided. The ownership of an NFT is recorded in the blockchain and can be transferred by the owner, allowing NFTs to be sold and traded. NFTs can be created by anybody and require few or no coding skills to create. NFTs typically contain references to digital files such as artworks, photos, videos, and audio. Because NFTs are uniquely identifiable, they differ from cryptocurrencies, which are fungible. ([Wikipedia](https://en.wikipedia.org/wiki/Non-fungible_token))
### About this project
![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/76663b95-992b-4f95-b49d-ed491936b844)

* Purpose : Practice object-oriented programming skills
* Assignment : Collect data on NFTs and articles related to them, from which statistics and analysis are derived
* Contributors: 2
* Time complete : 3 weeks
* My task: disign packages, crawl data, handle data
* Languages and Tools : Java, Selenium, Gson, IntelliJ IDEA

#### Design
*  Package dependency diagram ![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/d9a0ad7c-051a-4910-8eed-877acd5f485a)
* Package models ![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/5600633b-f519-492b-bdad-d5f56f142a88)
* Package collectors ![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/5f18cdac-f48a-4b0c-b324-3a389dc697e6)
* Package views ![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/dbbd8ed3-d15f-4344-b467-640e4c1d3d38)
> [Detail of class attributes and methods](https://drive.google.com/file/d/15D95S4GEHm0DRtriyFXiL8RaDOl_Hse0/view)
#### Crawl data
First, use Selenium to automatically collect data on NFTs and articles. Then store them as json files using the Gson library.
|  | NFT | Articles |
| --- | --- | ---|
| Data source | [Binance NFT](https://www.binance.com/en/nft) | [Tweet about NFT (X)](https://twitter.com/search?q=%22%22%20(%23NFT%20OR%20%23NFTCommunity)%20min_replies%3A1%20min_faves%3A1%20min_retweets%3A1%20-filter%3Areplies&src=typed_query%22), [Blog from nftcalendar](https://nftcalendar.io/) |
| Tools | Selenium, Gson |  Selenium, Gson|

![0302-ezgif com-video-to-gif-converter](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/2847a0d2-e1dc-4222-9d32-81426bb65998)

After that, crawled data will be stored in json file ![json](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/491277bc-259b-4380-9877-ee7684311b89)

#### Handle data
* Continue using Gson to model objects by converting from JSON to Java classes. ![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/ea1709b8-f498-4808-95b6-8b7996ef84e2)
* Related articles of NFT is articles that contain NFT name ![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/84284774-8b6a-455a-9564-4ab1de26929a)
* The UI will use Java Swing ![image](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/37335038-9ef1-4bd6-b46d-825ae09ded76)
#### Atatistics and analysis
* Search NFT by name
* Filter the hottest NFTs by various timeframes ![nftpage-ezgif com-video-to-gif-converter](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/13d502f2-7e7a-4ab6-95e3-2dbdf11b63cb)
* Search related articles of NFT. It'll also display the number of posts found. Additionally, it will provide statistics on the most frequently appearing hashtags. ![tweetpage-ezgif com-video-to-gif-converter](https://github.com/nvq29Apr/OOP_Project_Group2_new/assets/119597631/4cc69f5b-8fda-42be-a162-ec61676065b8)

