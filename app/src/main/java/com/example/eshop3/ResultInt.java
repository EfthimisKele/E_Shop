package com.example.eshop3;

//Δημιουργώ αυτή τη κλάση με 2 μεταβλητές τύπου Integer μαζί μετα Setter και Getter τους
// γιατί θα τις χρησιμοποίησω στο Interface MyDao.

public class ResultInt {
    int field1, field2;

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }
}

