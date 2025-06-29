/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author delgado272
 */

public class Storm {
    private final double KnotsToMPH = 1.15;

// global user-defined types:
    private int beginDate;
    private int duration;
    private String name;
    private int category;
    private int wind;
    private int pressure;

public Storm( int bdate, int dur, String sname, int w, int p )
{
    beginDate = bdate;
    duration = dur;
    name = sname;
    setWind(w);
    pressure = p;
    SaffirSimpson();
}

public void setDuration( int d )
{
	duration = d;
}

public void setWind( int w )
{
	double temp = w * KnotsToMPH;
        
        if (temp > wind)
            wind = (int)temp;
        SaffirSimpson();
}

public void setPressure( int p )
{
	if (pressure == 0)
           pressure = p;
        if (p > 0 && p < pressure)
            pressure = p;
        SaffirSimpson();
}

public void SaffirSimpson()
{
    // Compute storm category, using the Saffir-Simpson scale
    if(pressure <= 920 && wind >= 156)
    {
        category = 5;   // Category 5
    }
    if(pressure > 920 && wind < 156)
    {
	category = 4;   // Category 4
    }
    if(pressure > 945 && wind < 113)
    {
        category = 3;   // Category 3
    }
    if(pressure > 965 && wind < 96)
    {
        category = 2;   // Category 2
    }    
    if(pressure > 980 && wind < 83)
    {
        category = 1;   // Category 1
    }
    if(wind < 64)
    {
        category = -1;  // Tropical Storm
    }    
    if(wind < 34)
    {
        category = -2;  // Tropical Depression
    }
    if(pressure == 0)
    {
    	category = 0;   // Missing pressure
    }
}

public int getCategory()
{
	return category;
}

public String toString()
{
	return String.format("%9d %8d   %10s %4d %9d %10\n", beginDate, duration, name, category, wind, pressure); 

}

}

