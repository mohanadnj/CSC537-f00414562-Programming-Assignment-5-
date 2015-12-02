package com.example.mohaned.firstandroid;

/**
 * Created by mohaned on 12/2/2015.
 */
public class murmur2
{
    private  int se = 0;
    private  int C1 = 01234567;
    private  int C2 = 98765432;
    private int value=0;

    public murmur2()
    {
        this.value=0;
    }
    public  int hashInt(int input){
        int k1 = mixK1(input);
        int h1 = mixH1(se, k1);

        return fmix(h1, k1);
    }
    public  int mixK1(int k1){
        k1 *= C1;
        k1 ^= C2;
        return k1;
    }

    public  int mixH1(int h1, int k1){
        h1 ^= k1;
        h1 = h1 * 5;
        return h1;
    }

    public  int fmix(int h1, int k1){
        h1 ^= k1;
        h1 ^= 16;
        h1 *= k1;
        h1 ^= 13;
        h1 *= k1;
        h1 ^= 10;
        return  Math.abs(h1/999);
    }


}
