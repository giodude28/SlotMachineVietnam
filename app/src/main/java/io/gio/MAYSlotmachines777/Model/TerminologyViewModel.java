package io.gio.MAYSlotmachines777.Model;

public class TerminologyViewModel {

    String name;
    String desc;

    public TerminologyViewModel(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
