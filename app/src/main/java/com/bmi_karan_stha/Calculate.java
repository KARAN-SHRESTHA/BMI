package com.bmi_karan_stha;

public class Calculate {

    private float Weight, Height;

    public float BMI_Calc()
    {
        float calculate = (100*100*Weight)/(Height*Height);
        return calculate;

    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        Height = height;
    }
}
