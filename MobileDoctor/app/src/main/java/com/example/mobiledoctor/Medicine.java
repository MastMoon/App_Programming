package com.example.mobiledoctor;

public class Medicine {
    private final String name, efficacy, usage, price;

    public Medicine(String name, String efficacy, String usage, String price) {
        this.name     = name;
        this.efficacy = efficacy;
        this.usage    = usage;
        this.price    = price;
    }

    /** 약 이름 반환 */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "이름: "      + name
                + "\n효능: "     + efficacy
                + "\n복용법: "   + usage
                + "\n가격: "     + price;
    }
}
