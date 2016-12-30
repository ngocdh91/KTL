package kl.tool.ngoc.ktl.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ngocdh on 30,December,2016
 */

public class ExOneModel extends RealmObject{
    private double n , Y , X1 , X2 ;
    @PrimaryKey
    private long key;

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getX1() {
        return X1;
    }

    public void setX1(double x1) {
        X1 = x1;
    }

    public double getX2() {
        return X2;
    }

    public void setX2(double x2) {
        X2 = x2;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }
}
