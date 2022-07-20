package model;

public class Email {
    private String language;
    private int papeSize;
    private boolean isSpamFilter;
    private String signature;

    public Email(String language, int papeSize, boolean isSpamFilter, String signature) {
        this.language = language;
        this.papeSize = papeSize;
        this.isSpamFilter = isSpamFilter;
        this.signature = signature;
    }

    public Email() {

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPapeSize() {
        return papeSize;
    }

    public void setPapeSize(int papeSize) {
        this.papeSize = papeSize;
    }

    public boolean isSpamFilter() {
        return isSpamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        isSpamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
