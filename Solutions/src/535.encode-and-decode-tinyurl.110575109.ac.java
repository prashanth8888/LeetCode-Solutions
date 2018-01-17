public class Codec {
    
    HashMap<Integer, String> urlMap = new HashMap<>();
    Random rand = new Random();
    StringBuilder urlBuilder = new StringBuilder("");
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urlBuilder.setLength(0);
        int number = 10000 + rand.nextInt(90000);
        urlBuilder.append("http://tinyurl.com/" + number);
        urlMap.put(number, longUrl);
        return urlBuilder.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String shortUrledited = shortUrl.replace("http://tinyurl.com/","");
        return urlMap.get(Integer.parseInt(shortUrledited));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
