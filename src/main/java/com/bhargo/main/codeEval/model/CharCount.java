package com.bhargo.main.codeEval.model;

import java.util.Objects;

/**
 * Created by barya on 8/4/16.
 */
public class CharCount implements Comparable{

    private String str;
    private Integer count;

    public CharCount(String str, Integer count) {
        this.str = str;
        this.count = count;
    }

    public CharCount() {

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharCount charCount = (CharCount) o;
        return Objects.equals(str, charCount.str) &&
                Objects.equals(count, charCount.count);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, count);
    }

    @Override
    public int compareTo(Object o) {
        return this.getCount().compareTo(((CharCount)o).getCount());
    }
}
