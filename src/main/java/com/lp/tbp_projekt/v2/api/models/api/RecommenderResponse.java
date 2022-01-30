package com.lp.tbp_projekt.v2.api.models.api;

public class RecommenderResponse<T>
{
    final private boolean success;
    final private String message;
    final private T data;

    public RecommenderResponse(final boolean success, final String message, final T data)
    {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public String getMessage()
    {
        return message;
    }
}