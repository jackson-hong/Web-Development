package com.kh.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.kh.common.AESCrypto;

/**
 * Application Lifecycle Listener implementation class CryptoListener
 *
 */

@WebListener
public class CryptoListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CryptoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	new AESCrypto();
    }
}
