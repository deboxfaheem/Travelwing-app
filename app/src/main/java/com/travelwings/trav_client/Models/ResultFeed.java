
package com.travelwings.trav_client.Models;


import com.google.gson.annotations.Expose;

import com.google.gson.annotations.SerializedName;


public class ResultFeed {

    @SerializedName("response")
    
@Expose
    private ResultFeed response;

    
/**
     * No args constructor for use in serialization
     * 
    
 */
    public ResultFeed() {
    }

 
   /**
     * 
     * @param response
     */
   
 public ResultFeed(ResultFeed response)
 {
        super();
        this.response = response;
    }

   
 public ResultFeed getResponse() {
        return response;
    }

   
 public void setResponse(ResultFeed response)
 {
        this.response = response;
    }

}
