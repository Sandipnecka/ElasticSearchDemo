package com.company;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.filters.Filters;

public class Main {

     private static Client client = null;
    public static void main(String[] args) {
	// write your code here
    }

    public  void sampleCodes(){


        // initializing client


        //codes to  run client
        AppUtility appUtility = new AppUtility();
        client = appUtility.createClient();

        //Get document
        GetRequestBuilder getRequestBuilder = client.prepareGet("db", "staff", "AU1R4XYdVHRe9_PJcG2y");
        getRequestBuilder.setFields(new String[]{"name", "age"});
        GetResponse response = getRequestBuilder.execute().actionGet();
        // String name = response.getField("age").getValue().toString();
        // System.out.println(name);

        // Using Search api

        // match query followed by term filter
        /*
        SearchResponse searchResponse = client.prepareSearch("employeeinfo")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(
                        QueryBuilders.matchQuery("first_name","sanjeev")
                ).setPostFilter(FilterBuilders.termFilter("last_name","Ghimire")).execute().actionGet();


               System.out.println(searchResponse.toString());
*/
        /*
//   match query followed by range filter
        SearchResponse searchResponse = client.prepareSearch("employeeinfo")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(
                        QueryBuilders.matchQuery("last_name","tamang")
                ).setPostFilter(FilterBuilders.rangeFilter("age").from(18).to(22)).execute().actionGet();
        System.out.println(searchResponse.toString());

        */

// using multiple search query

        /*

        SearchRequestBuilder srOne  = client.prepareSearch().setQuery(QueryBuilders.matchQuery("last_name","tamang")).setSize(1);

        SearchRequestBuilder srTwo = client.prepareSearch().setPostFilter(FilterBuilders.rangeFilter("age")
                .from(18).to(22)).setSize(1);

        MultiSearchResponse  multiSearchResponse = client.prepareMultiSearch().add(srOne).add(srTwo).execute().actionGet();

        for(MultiSearchResponse.Item item : multiSearchResponse.getResponses()){

            SearchResponse searchResponse = item.getResponse();


             SearchHits searchHits  =  searchResponse.getHits();


            for (SearchHit searchHit : searchHits.getHits()){

                 Map map = searchHit.getSource();
                  System.out.println(map.get("first_name"));

            }
            //System.out.println(searchResponse.toString());
        }

      */
        /*
        // making use of aggregation part I

           SearchResponse searchResponse =  client.prepareSearch().setQuery(QueryBuilders.matchAllQuery())
                   .addAggregation(AggregationBuilders.terms("agg1").field("salary")).execute().actionGet();


        Terms terms = searchResponse.getAggregations().get("agg1");


          for(Terms.Bucket buck : terms.getBuckets()){

             System.out.println( buck.getKey());
        }

*/
        /*
        // making use of aggregation part I
        SearchResponse searchResponses = client.prepareSearch().setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(AggregationBuilders.avg("avgg").field("salary")).execute().actionGet();

       Avg avg = searchResponses.getAggregations().get("avgg");
        System.out.println(avg.getValue());
*/
/*
        // Metric Aggregations

        SearchResponse searchResponse1 =  client.prepareSearch()
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(AggregationBuilders.count("count").field("first_name")).execute().actionGet();
        ValueCount valueCount =  searchResponse1.getAggregations().get("count");

         System.out.println(valueCount.getValue());

 */
       



    }
    }


