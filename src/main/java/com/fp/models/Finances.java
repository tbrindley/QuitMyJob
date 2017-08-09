package com.fp.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jayme on 8/9/2017.
 */
@Entity
public class Finances {
    private int finId;
    private int housing;
    private int transporation;
    private int savings;
    private int extras;
    private int food;
    private int debt;

    @Id
    @Column(name = "fin_id", nullable = false)
    public int getFinId() {
        return finId;
    }

    public void setFinId(int finId) {
        this.finId = finId;
    }

    @Basic
    @Column(name = "housing", nullable = false)
    public int getHousing() {
        return housing;
    }

    public void setHousing(int housing) {
        this.housing = housing;
    }

    @Basic
    @Column(name = "transporation", nullable = false)
    public int getTransporation() {
        return transporation;
    }

    public void setTransporation(int transporation) {
        this.transporation = transporation;
    }

    @Basic
    @Column(name = "savings", nullable = false)
    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    @Basic
    @Column(name = "extras", nullable = false)
    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    @Basic
    @Column(name = "food", nullable = false)
    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Basic
    @Column(name = "debt", nullable = false)
    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Finances finances = (Finances) o;

        if (finId != finances.finId) return false;
        if (housing != finances.housing) return false;
        if (transporation != finances.transporation) return false;
        if (savings != finances.savings) return false;
        if (extras != finances.extras) return false;
        if (food != finances.food) return false;
        if (debt != finances.debt) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = finId;
        result = 31 * result + housing;
        result = 31 * result + transporation;
        result = 31 * result + savings;
        result = 31 * result + extras;
        result = 31 * result + food;
        result = 31 * result + debt;
        return result;
    }
}
