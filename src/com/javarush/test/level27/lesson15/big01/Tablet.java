package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by admin on 26.01.2016.
 */
public class Tablet extends Observable
{
    private final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        Order order = null;
        try
        {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty())
            {
                AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                manager.processVideos();
                setChanged();
                notifyObservers(order);
            }
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString()
    {
        return String.format("Tablet{number=%d}", number);
    }


}
