package io.gio.MAYSlotmachines777.Model;

public class MachineViewModel {
    String mname;
    String desc;
    int img;

    public MachineViewModel(String mname, String desc, int img) {
        this.mname = mname;
        this.desc = desc;
        this.img = img;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
