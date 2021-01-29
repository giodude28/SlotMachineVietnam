package io.gio.MAYSlotmachines777.Model;

public class PrizesViewModel {
    String prizesName;
    String firstCoin;
    String secondCoin;
    String thirdCoin;
   int images;

    public PrizesViewModel(String prizesName, String firstCoin, String secondCoin, String thirdCoin, int images  ) {
        this.prizesName = prizesName;
        this.firstCoin = firstCoin;
        this.secondCoin = secondCoin;
        this.thirdCoin = thirdCoin;
        this.images = images;
    }

    public String getPrizesName() {
        return prizesName;
    }

    public void setPrizesName(String prizesName) {
        this.prizesName = prizesName;
    }

    public String getFirstCoin() {
        return firstCoin;
    }

    public void setFirstCoin(String firstCoin) {
        this.firstCoin = firstCoin;
    }

    public String getSecondCoin() {
        return secondCoin;
    }

    public void setSecondCoin(String secondCoin) {
        this.secondCoin = secondCoin;
    }

    public String getThirdCoin() {
        return thirdCoin;
    }

    public void setThirdCoin(String thirdCoin) {
        this.thirdCoin = thirdCoin;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
