package seattlesbest.angtaasapp;

/**
 * Created by Dalag, Magdaraog, Raymundo on 11/10/2017.
 */

public class FlashcardStack {
    private String name;
    private int icon;

    public FlashcardStack(String name, int icon){
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
