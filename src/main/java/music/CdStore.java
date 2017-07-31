package music;

public class CdStore {
    public String artistName;
    public String albumName;
    public int releaseYr;
    public int price;

    public CdStore (String artName, String albName, int relYr, int price) {
        artistName = artName;
        albumName = albName;
        releaseYr = relYr;
        this.price = price;
    }
    public boolean releaseYear(int userReleaseYr) {
        return (releaseYr == userReleaseYr);
    }
    public boolean cost(int min, int max){
        return(price > min && price < max);
    }
    public boolean artistSearch(String name) {
        return(artistName.equals(name));
    }
}

