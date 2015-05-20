package com.company;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;

/**
 * Created by Sandip on 5/14/2015.
 */
public class AppUtility {

   static  TransportClient transportClient = null ;

    public Client createClient() {

        if(transportClient==null){

            Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "elasticsearch")
                    .put("client.transport.sniff", true)
                    .build();
            return new TransportClient()
                    .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
        }else
        {

            return  transportClient;
        }


    }



}
