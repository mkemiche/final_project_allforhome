package io.allforhome.enums;

/**
 * @author mkemiche
 * @created 05/06/2021
 */
public enum Title {

    MR("Mr."),
    MS("Ms.");

    private String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
